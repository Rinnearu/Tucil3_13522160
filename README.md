# Tucil3_13522160

:sob:**Welcome to Ertiga's Tucil 3 Repository**:sob:

## Deskripsi Program
Program ini menggunakan bahasa pemrograman java dan dibuat untuk memenuhi tugas kecil 3 IF2211 - Strategi Algoritma. Program ini dapat menerima input berupa dua kata dengan panjang yang sama sebagai permasalahan word ladder dengan kamus SOWPODS yang biasa digunakan dalam permainan Scrabble. Kemudian program dapat mencari solusi menggunakan tiga algoritma, yaitu Uniform-Cost Search, Greedy Best First Search, dan A*. Program akan ditunjukkan dalam command line interface

Semoga program ini dapat membantu dalam permasalahan word ladder!!!

## Cara Menjalankan Program
> You need to have java installed to run this program
Terdapat 2 cara untuk memulai program

> Perlu dilakukan pada direktori awal ./Tucil3_13522160/ karena program butuh lokasi sowpods.txt yang benar
### Melalui File Executable .jar
1. Masuk cmd dan set direktori ke ./Tucil3_13522160/
2. Masukkan command berikut pada cmd
```bash
    java -jar .\bin\Tucil3_13522160.jar
```

### Melalui Kompilasi ke Kelas Java
1. Masuk cmd dan set direktori ke ./Tucil3_13522160/
2. Masukkan command berikut pada cmd
```bash
    javac -d bin src/*.java
    java -cp bin wordladder
```

Kemudian lakukan hal berikut dalam program

- Masukkan input kata mulai dan kata tujuan
- Jika kata tidak terdapat dalam kamus atau kedua kata memiliki panjang yang sama, program akan langsung berhenti
- Jika kata diterima, masukkan angka 1-3 untuk memilih algoritma
- Tunggu...
- Program akan menunjukkan solusi jika menemukannya atau mengeluarkan pesan tidak terdapat solusi jika tidak menemukan solusi berdasarkan kamus yang digunakan

## Identitas Pembuat
Nama : Rayhan Ridhar Rahman
NIM : 13522160
Kelas : K-03
