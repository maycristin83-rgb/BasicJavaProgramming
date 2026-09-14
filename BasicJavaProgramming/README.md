# Basic Java Programming — Week 2 Sesi 1

Kumpulan contoh kode dari materi **"Basic Java Programming"** (Fakultas Vokasi, D4TRPL, Institut Teknologi Del)
diorganisir sebagai satu project **NetBeans (Java SE / Ant)**, siap dibuka, dijalankan, dan di-push ke Git.

## Struktur Project

```
BasicJavaProgramming/
├── build.xml
├── manifest.mf
├── nbproject/
│   ├── project.xml
│   └── project.properties
└── src/
    └── week2/
        ├── structprogram/   -> HelloWorld.java
        ├── variabel/        -> JenisVariabelDemo.java, PenamaanVariabelDemo.java
        ├── nonprimitive/    -> Demo.java, OperasiKalkulator.java
        ├── array/           -> ArrayDemo.java, ArrayMultidimensiDemo.java
        ├── string/          -> StringDemo.java
        ├── casting/         -> KonversiTipeDataDemo.java
        ├── operator/        -> ArithmeticUnaryDemo.java, EqualityRelationalDemo.java, BitwiseDemo.java
        ├── statement/       -> ExpressionStatementBlockDemo.java
        ├── control/         -> IfElseDemo.java, SwitchDemo.java, WhileDoWhileDemo.java,
        │                       ForDemo.java, BranchingDemo.java
        ├── io/              -> ScannerDemo.java
        └── implementation/  -> RataRataMahasiswa.java
```

Setiap file punya method `main()` sendiri, jadi bisa langsung di-run satu per satu
di NetBeans (klik kanan file → **Run File**).

## 1. Cara Membuka di NetBeans

1. Buka **NetBeans IDE**.
2. Pilih **File → Open Project**.
3. Arahkan ke folder `BasicJavaProgramming` (folder yang berisi `build.xml`), lalu **Open Project**.
4. NetBeans akan otomatis meng-generate `nbproject/build-impl.xml` — ini normal, biarkan saja.
5. Untuk menjalankan salah satu contoh, klik kanan file `.java` yang diinginkan → **Run File** (atau `Shift+F6`).

> Jika kamu mau, kamu juga bisa membuat project baru di NetBeans ("Java Application" / "Java with Ant"),
> lalu tinggal copy-paste folder `src/week2` ini ke dalam project barumu.

## 2. Cara Push ke Git / GitHub

Jalankan perintah berikut di terminal, dari dalam folder `BasicJavaProgramming`:

```bash
# 1. Inisialisasi repo git (kalau belum ada)
git init

# 2. Tambahkan semua file
git add .

# 3. Commit pertama
git commit -m "Add Basic Java Programming examples - Week 2 Sesi 1"

# 4. Buat repository baru di GitHub (lewat website github.com), lalu hubungkan:
git remote add origin https://github.com/USERNAME/NAMA-REPO.git

# 5. Push ke branch utama
git branch -M main
git push -u origin main
```

Ganti `USERNAME` dan `NAMA-REPO` dengan akun & nama repository GitHub kamu.

### Kalau setiap topik ingin jadi commit terpisah (opsional, biar histori git lebih rapi)

```bash
git add src/week2/structprogram
git commit -m "Add: Struktur Program Java (HelloWorld)"

git add src/week2/variabel
git commit -m "Add: Variabel & Tipe Data"

git add src/week2/nonprimitive
git commit -m "Add: Tipe Data Non-Primitive (Class, Array, Interface)"

git add src/week2/array
git commit -m "Add: Array 1D & Multidimensi"

git add src/week2/string
git commit -m "Add: String dalam Java"

git add src/week2/casting
git commit -m "Add: Konversi Tipe Data (Casting)"

git add src/week2/operator
git commit -m "Add: Operator (aritmatika, relasi, logika, bitwise)"

git add src/week2/statement
git commit -m "Add: Expression, Statement, Blocks"

git add src/week2/control
git commit -m "Add: Percabangan & Perulangan (if, switch, while, for, break/continue)"

git add src/week2/io
git commit -m "Add: Input/Output dengan Scanner"

git add src/week2/implementation
git commit -m "Add: Implementasi sederhana - rata-rata mahasiswa"

git push -u origin main
```

## Referensi

- Deitel, P. J., & Deitel, H. M. (2018). *Java How to Program* (11th Edition). Pearson.
- Schildt, H. (2019). *Java: The Complete Reference* (11th Edition). McGraw-Hill.
- Oracle. (2023). *The Java™ Tutorials*. Oracle Docs.
