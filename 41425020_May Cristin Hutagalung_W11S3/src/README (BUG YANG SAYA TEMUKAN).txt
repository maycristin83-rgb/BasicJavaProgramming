Nim	: 41425020
Nama	: May Cristin Hutagalung
Prodi	: DIV-Teknologi Rekayasa Perangkat Lunak

1. Bug yang ditemukan

Setelah semua test pertama saya lulus, saya membaca ulang method
tambahKuota() di Kupon.java. Isi method-nya waktu itu seperti ini:

    public void tambahKuota(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah harus lebih dari 0");
        }
        kuota += jumlah;
    }

Method ini hanya memeriksa bahwa jumlah yang ditambahkan lebih dari 0,
tetapi tidak memeriksa apakah hasil penjumlahannya masih muat di tipe
int. Nilai maksimum int adalah 2.147.483.647 (Integer.MAX_VALUE).
Kalau kuota sudah berada di nilai itu lalu ditambah 1, hasilnya tidak
menjadi 2.147.483.648, melainkan "berputar" ke nilai paling kecil, yaitu
-2.147.483.648. Dalam Java kejadian ini disebut integer overflow dan
tidak menimbulkan error apa pun.

Akibatnya kuota kupon bisa bernilai negatif, padahal aturan di
konstruktor jelas melarang kuota negatif. Jadi ada celah: data yang
ditolak lewat konstruktor ternyata bisa tercipta lewat tambahKuota().
Ketika kuota sudah negatif, isHabis() juga mengembalikan false
(karena hanya mengecek kuota == 0), sedangkan pakai() akan menolak
karena kuota tidak lebih dari 0. Status kuponnya menjadi tidak konsisten.

2. Cara saya membuktikan bug ini

Saya tidak langsung mengubah kodenya. Saya menulis test dulu di
KuponTest.java:

    @Test
    void tambahKuota_overflow_melemparArithmeticException() {
        Kupon penuh = new Kupon("PENUH", 10, Integer.MAX_VALUE, 0);
        assertThrows(ArithmeticException.class, () -> penuh.tambahKuota(1));
    }

Test ini membuat kupon dengan kuota maksimum, menambah 1, lalu berharap
ada ArithmeticException.

Hasil run sebelum perbaikan (kode masih kuota += jumlah):
- Tests run: [20], Failures: [1], Errors: [0]
- Test yang gagal: tambahKuota_overflow_melemparArithmeticException
- Pesan dari JUnit: [salin pesan dari tab Output, kira-kira
  "Expected ArithmeticException to be thrown, but nothing was thrown."]
- Screenshot: [nama file screenshot sebelum perbaikan]

Pesan itu menunjukkan bahwa tidak ada exception sama sekali, artinya
kuota memang berubah diam-diam menjadi negatif.

3. Perbaikan

Baris penjumlahan saya ganti dengan:

    kuota = Math.addExact(kuota, jumlah);

Math.addExact menjumlahkan dua int dan melempar ArithmeticException
kalau hasilnya melebihi batas. Dengan begitu kuota tidak pernah bisa
berubah menjadi negatif lewat penambahan, dan nilai kuota sebelumnya
tetap utuh karena exception dilempar sebelum nilainya ditimpa.

Hasil run setelah perbaikan:
- Tests run: [20], Failures: [0], Errors: [0], Skipped: [0]
- BUILD SUCCESS
- Screenshot: [nama file screenshot sesudah perbaikan]

 4. Aturan lain yang belum teruji

Waktu memeriksa ulang daftar test, saya juga menemukan beberapa aturan
di Kupon.java yang belum punya test sendiri:

1. Konstruktor menolak kuota negatif (kuota < 0). Aturan ini ada di
   kode, tetapi belum ada test yang mengirim kuota -1.
2. Konstruktor menolak minimal belanja negatif (minBelanja < 0).
   Belum ada test yang menguji aturan ini.
3. Penambahan kuota yang valid. Saya baru menguji tambahKuota(0)
   yang ditolak, tetapi belum menguji kasus normal, misalnya kuota 5
   ditambah 3 harus menjadi 8.
4. Method pakai() pada kuota lebih dari 1. Saya baru menguji kuota
   terakhir (1 menjadi 0) dan kuota yang sudah habis, belum kasus
   kuota 5 menjadi 4.
5. Jumlah negatif pada tambahKuota() (misalnya -3). Saat ini hanya
   angka 0 yang diuji, padahal aturannya mencakup semua nilai di
   bawah atau sama dengan 0.

Kalau ada waktu, kelima kasus ini bisa ditambahkan sebagai test baru
supaya cakupan pengujiannya lebih lengkap.

 5. Yang saya pelajari

Test yang lulus semua belum berarti kodenya benar, karena test hanya
memeriksa kasus yang terpikirkan oleh penulisnya. Kasus batas seperti
nilai maksimum tipe data mudah terlewat, dan cara paling aman
menemukannya adalah dengan menulis test untuk batas itu secara sengaja.