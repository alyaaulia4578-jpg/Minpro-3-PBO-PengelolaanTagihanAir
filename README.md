# Sistem Pengelolaan Tagihan Air Perumahan Warga

**Nama Repository:** `Minpro-3-PBO-PengelolaanTagihanAir`

Program dikembangkan dengan menerapkan konsep Pemrograman Berorientasi Objek, yaitu **polymorphism, abstraction, inheritance, encapsulation, interface, serta struktur MVC (Model, View, Controller)**.
Program digunakan untuk mengelola data warga, tagihan air, pembayaran, dan data petugas. Program juga dilengkapi validasi input agar data yang dimasukkan tidak kosong, tidak menggunakan ID yang sama, serta tidak menerima nilai yang tidak sesuai dengan aturan program.

---

## Deskripsi Program

Sistem Pengelolaan Tagihan Air Perumahan Warga adalah aplikasi sederhana berbasis Java yang digunakan untuk mengelola administrasi tagihan air warga.

Fitur utama program:

- Menambah data warga
- Melihat data warga
- Mengubah data warga
- Menghapus data warga
- Menambah tagihan air
- Melihat tagihan air
- Mengubah tagihan air
- Menghapus tagihan air
- Menambah pembayaran
- Melihat data pembayaran
- Melihat data petugas
- Menghitung total tagihan berdasarkan pemakaian air
- Mengubah status tagihan menjadi lunas setelah pembayaran berhasil
- Melakukan validasi input

Tarif air yang digunakan dalam program adalah **Rp3.000 per m³**.

---

## Struktur Package

Program menggunakan beberapa package untuk memisahkan tanggung jawab setiap bagian program.

```Struktur
└── Main.java
├── controller
│   └── MenuController.java
│
├── model
│   ├── User.java
│   ├── Warga.java
│   ├── Petugas.java
│   ├── TagihanAir.java
│   ├── Pembayaran.java
│   └── DapatDihitung.java
│
├── service
│   └── PengelolaanService.java
│
├── view
    └── MenuView.java

```

### Dokumentasi Struktur Package

![Tampilan Menu Utama](SistemTagihanAir/docs/struktur-project.png)

### Controller

Package `controller` berisi `MenuController.java`.

Controller mengatur jalannya program, menerima input dari pengguna, memanggil service, dan menentukan proses yang dilakukan berdasarkan menu yang dipilih.

### Model

Package `model` berisi class yang mewakili objek dalam sistem, yaitu:

- `User`
- `Warga`
- `Petugas`
- `TagihanAir`
- `Pembayaran`
- `DapatDihitung`

Bagian model menyimpan data dan perilaku masing-masing objek.

### Service

Package `service` berisi `PengelolaanService.java`.

Class ini menangani penyimpanan data menggunakan `ArrayList`, pencarian data, penambahan data, serta penghapusan data.

### View

Package `view` berisi `MenuView.java`.

Class ini digunakan untuk menampilkan judul dan menu program kepada pengguna.

---

## Alur Program

Program dimulai dari `Main.java`.

Alur umum program:

```text
Main
  ↓
MenuController
  ↓
MenuView menampilkan menu
  ↓
Pengguna memilih menu
  ↓
MenuController memproses pilihan
  ↓
Service mengelola data
  ↓
Model menyimpan dan mengolah data
  ↓
Hasil ditampilkan kembali kepada pengguna
```

Ketika program dijalankan, pengguna akan melihat menu utama.

![Tampilan Menu Utama](SistemTagihanAir/docs/01-menu-utama.png)

Pengguna dapat memilih fitur warga, tagihan, pembayaran, atau data petugas. Setelah suatu proses selesai, program meminta pengguna menekan ENTER untuk kembali ke menu.

---

# Penerapan Konsep PBO

## Encapsulation

Encapsulation diterapkan dengan membatasi akses langsung terhadap atribut class menggunakan access modifier `private`.

Contohnya pada class `Warga`, atribut `alamat` dan `nomorRumah` dibuat `private`. Akses terhadap atribut tersebut dilakukan melalui method getter dan setter.

### Abstract Class

![Abstract Class](SistemTagihanAir/docs/02-abstract-class.png)

Penerapan ini membuat data di dalam object tidak dapat diubah secara langsung dari luar class. Pengelolaan data dilakukan melalui method yang disediakan oleh class.

---

## Inheritance

Inheritance diterapkan dengan membuat `Warga` dan `Petugas` sebagai turunan dari class `User`.

Hubungannya:

```text
User
├── Warga
└── Petugas
```

Class `Warga` mewarisi atribut dan method dari `User`, kemudian menambahkan atribut `alamat` dan `nomorRumah`.

![Inheritance Warga](SistemTagihanAir/docs/04-inheritance-warga.png)

Class `Petugas` juga mewarisi `User` dan menambahkan atribut `jabatan`.

![Inheritance Petugas](SistemTagihanAir/docs/05-inheritance-petugas.png)

Dengan inheritance, bagian yang sama seperti `idUser` dan `nama` tidak perlu dibuat kembali pada setiap class turunan.

---

## Polymorphism

Polymorphism diterapkan melalui **overriding** dan **overloading**.

### Overriding

Method `tampilkanInfo()` didefinisikan pada class induk `User` sebagai abstract method. Method tersebut kemudian diimplementasikan kembali pada class `Warga` dan `Petugas`.

Pada `Warga`, method menampilkan informasi warga.

![Overriding Warga](SistemTagihanAir/docs/06-overriding-warga.png)

Pada `Petugas`, method yang sama digunakan untuk menampilkan informasi petugas.

![Overriding Petugas](SistemTagihanAir/docs/07-overriding-petugas.png)

Nama method tetap sama, yaitu `tampilkanInfo()`, tetapi isi implementasinya berbeda sesuai dengan object yang digunakan.

### Overloading

Overloading diterapkan pada class `TagihanAir` melalui method `hitungTotal()`.

Terdapat method:

```text
hitungTotal()
hitungTotal(int pemakaian)
```

Keduanya memiliki nama yang sama, tetapi parameter berbeda.

![Overloading](SistemTagihanAir/docs/10-overloading.png)

Method `hitungTotal()` digunakan untuk menghitung total tagihan berdasarkan data pemakaian yang tersimpan pada object, sedangkan `hitungTotal(int pemakaian)` dapat menerima nilai pemakaian sebagai parameter.

---

# Abstraction

Abstraction diterapkan menggunakan abstract class dan abstract method.

## Abstract Class

Class `User` dibuat sebagai abstract class.

![Abstract Class](SistemTagihanAir/docs/02-abstract-class.png)

Class `User` menjadi dasar bagi class `Warga` dan `Petugas`. Karena merupakan abstract class, `User` digunakan sebagai konsep umum dan bukan sebagai object yang dibuat secara langsung.

## Abstract Method

Pada class `User` terdapat abstract method:

```text
public abstract void tampilkanInfo();
```

![Abstract Method](SistemTagihanAir/docs/03-abstract-method.png)

Method tersebut tidak memiliki isi pada class `User`. Implementasinya diberikan oleh class turunan `Warga` dan `Petugas`.

Penerapan ini sekaligus mendukung penggunaan overriding karena setiap class turunan memberikan bentuk implementasi `tampilkanInfo()` yang sesuai dengan jenis datanya.

---

# Interface

Program menggunakan interface `DapatDihitung`.

Interface berisi method:

```text
int hitungTotal();
```

![Interface](SistemTagihanAir/docs/08-interface.png)

Interface tersebut kemudian diterapkan oleh class `TagihanAir`.

![Implementasi Interface](SistemTagihanAir/docs/09-implementasi-interface.png)

Dengan interface ini, proses perhitungan total tagihan memiliki aturan method yang harus diterapkan oleh class yang menggunakannya.

---

# Keyword final

Keyword `final` digunakan pada tarif air agar nilai tarif menjadi tetap dan tidak dapat diubah melalui pewarisan atau assignment ulang.

Contohnya:

```text
private static final int TARIF_AIR = 3000;
```

![Keyword final](SistemTagihanAir/docs/12-final.png)

Nilai tersebut digunakan dalam proses perhitungan total tagihan.

---

# Fitur CRUD

## 1. Create

Program dapat menambahkan data warga dan tagihan.

### Tambah Data Warga

![Tambah Warga](SistemTagihanAir/docs/13-tambah-warga.png)

Data warga yang dimasukkan terdiri dari ID warga, nama, alamat, dan nomor rumah.

### Tambah Tagihan Air

![Tambah Tagihan](SistemTagihanAir/docs/14-tambah-tagihan.png)

Pada contoh pengujian, warga `W2` memiliki pemakaian air sebesar `20 m3`.

Dengan tarif Rp3.000/m³, total tagihan dihitung:

```text
20 × Rp3.000 = Rp60.000
```

Program kemudian menampilkan bahwa tagihan berhasil dibuat.

---

## 2. Read

Data yang sudah tersimpan dapat ditampilkan melalui menu lihat data.

Fitur ini digunakan untuk melihat data warga, tagihan air, pembayaran, dan petugas.
![Tampilan Menu Utama](SistemTagihanAir/docs/01-menu-utama.png)

---

## 3. Update

Data yang sudah tersimpan dapat diubah.

Pada pengujian, pemakaian tagihan `T2` diubah dari `20 m3` menjadi `30 m3`.

![Ubah Tagihan](SistemTagihanAir/docs/15-ubah-tagihan.png)

Total tagihan kemudian berubah dari:

```text
20 m3 × Rp3.000 = Rp60.000
```

menjadi:

```text
30 m3 × Rp3.000 = Rp90.000
```

Hal ini menunjukkan bahwa total tagihan dihitung kembali ketika pemakaian diubah.


---

## 4. Delete

Program juga menyediakan menu untuk menghapus data warga dan tagihan.

![Tampilan Menu Utama](SistemTagihanAir/docs/01-menu-utama.png)

---

# Pembayaran

Pembayaran dilakukan dengan memilih ID tagihan terlebih dahulu. Program menampilkan data tagihan yang dipilih, kemudian meminta tanggal pembayaran dan jumlah pembayaran.

Pada pengujian:

- Tanggal `7-10-2026` ditolak karena tidak sesuai format.
- Setelah menggunakan format `07-10-2026`, tanggal diterima.
- Pembayaran Rp50.000 ditolak karena kurang dari total tagihan Rp90.000.
- Pembayaran Rp90.000 diterima.
- Status tagihan berubah menjadi `Lunas`.


![Pembayaran dan Validasi](SistemTagihanAir/docs/16-pembayaran-dan-validasi.png)

Alur pembayaran:

```text
Pilih tagihan
    ↓
Tampilkan data tagihan
    ↓
Input tanggal pembayaran
    ↓
Validasi tanggal
    ↓
Input jumlah pembayaran
    ↓
Bandingkan dengan total tagihan
    ↓
Pembayaran valid
    ↓
Status menjadi Lunas
```

---

# Validasi Input

Validasi ditambahkan sebagai perbaikan dari Mini Project 2. Tujuannya agar program tidak menerima input yang kosong, ID yang sudah digunakan, nilai pemakaian negatif, atau data pembayaran yang tidak sesuai.

## Input Tidak Boleh Kosong

Jika pengguna langsung menekan ENTER ketika diminta mengisi data, program menampilkan pesan bahwa input tidak boleh kosong.

![Validasi Input Kosong](SistemTagihanAir/docs/17-validasi-kosong.png)

---

## ID Warga Tidak Boleh Sama

Program mengecek ID warga sebelum data ditambahkan.

Jika ID `W1` sudah digunakan dan dimasukkan kembali, program menolak data tersebut.

![Validasi ID Warga](SistemTagihanAir/docs/18-validasi-id-warga.png)

---

## ID Tagihan Tidak Boleh Sama

Program juga melakukan pengecekan terhadap ID tagihan.

Jika ID tagihan sudah digunakan, data tidak akan ditambahkan.

![Validasi ID Tagihan](SistemTagihanAir/docs/19-validasi-id-tagihan.png)

---

## Pemakaian Air Tidak Boleh Negatif

Nilai pemakaian air tidak boleh kurang dari nol.

Pada pengujian, input `-5` ditolak oleh program.

![Validasi Pemakaian](SistemTagihanAir/docs/20-validasi-pemakaian.png)

---

## Validasi Pembayaran

Jumlah pembayaran harus sesuai dengan total tagihan.

Pembayaran yang lebih kecil dari total tagihan ditolak. Pembayaran yang sesuai dengan total tagihan diterima dan status tagihan berubah menjadi `Lunas`.

Validasi tanggal juga diterapkan sehingga tanggal harus mengikuti format yang ditentukan program.

Dokumentasi pengujian pembayaran dan validasi tanggal dapat dilihat pada:

![Pembayaran dan Validasi](SistemTagihanAir/docs/16-pembayaran-dan-validasi.png)

---

# Kesimpulan

Program Sistem Pengelolaan Tagihan Air Perumahan Warga berhasil dikembangkan untuk mengelola data warga, tagihan air, pembayaran, dan petugas secara terstruktur. Program menerapkan konsep PBO seperti encapsulation, inheritance, polymorphism, abstraction, dan interface, serta menggunakan struktur MVC untuk memisahkan pengelolaan data, tampilan, dan alur program.
Program juga dilengkapi CRUD dan validasi input, seperti pemeriksaan data kosong, ID duplikat, dan nilai pemakaian yang tidak boleh negatif. Dengan penerapan tersebut, program menjadi lebih terorganisasi, mudah dipahami, dan mampu menangani proses pengelolaan tagihan air sesuai kebutuhan sistem.
