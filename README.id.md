# Kuis Praktik 2 OOP: Ojek Online

🇬🇧 English version: [README.md](README.md)

Waktu pengerjaan: **120 menit**. Nilai maksimal: **100 poin**, dinilai otomatis setiap kamu melakukan push.

## Studi Kasus

Kamu membangun inti aplikasi **Ojek Online**. Setiap perjalanan punya jenis (**ojek motor** dan **ojek mobil**), dan tiap jenis menghitung tarif dengan aturannya sendiri. Hanya satu jenis yang punya layanan asuransi perjalanan. Sebuah perjalanan hanya valid bila jarak lebih dari 0 dan paling banyak 50 km. Semua perjalanan disimpan di **pengatur perjalanan**, lalu dibayar lewat **metode pembayaran**.

Kuis ini mencakup materi **Pertemuan 9 sampai 11**: kelas abstrak dan interface, polimorfisme dan `instanceof`, exception, `ArrayList` dan `Map`, serta prinsip SOLID.

## Cara Kerja Kuis Ini

Kuis dibagi menjadi **lima tahap yang makin sulit**. Urutannya mengikuti urutan kuliah, jadi kerjakan dari tahap 1.

| Tahap | Isi | Poin |
|---|---|---:|
| 1 | Pemanasan: class dan enkapsulasi | 15 |
| 2 | Kelas abstrak dan interface (Pertemuan 9) | 20 |
| 3 | Polimorfisme dan exception (Pertemuan 10) | 20 |
| 4 | Collections (Pertemuan 11) | 15 |
| 5 | SOLID (Pertemuan 11) | 30 |

- **Tahap 1 sampai 3 bernilai 55 poin.** Bila kamu menyelesaikan ketiganya, kamu sudah lulus dengan nyaman.
- **Tiap tahap berdiri sendiri.** Tes tahap 3 sampai 5 memakai kelas buatan tes, bukan kelas buatanmu. Bila kamu macet di satu tahap, lanjutkan ke tahap berikutnya: poinnya tetap bisa kamu dapat.
- **Semua tes terlihat.** Buka folder `src/test` untuk membaca apa yang diperiksa. Kamu boleh membacanya, tetapi tidak boleh mengubahnya.
- **Tes yang gagal memberi petunjuk.** Pesan gagal menyebut aturan yang dilanggar.

## Diagram Kelas

Diagram kelas adalah **spesifikasi utama**. Semua nama kelas, field, constructor, dan method yang kamu butuhkan ada di sana.

![Diagram Kelas](docs/class-diagram.png)

Warna menunjukkan apa yang harus kamu lakukan:

| Warna | Artinya |
|---|---|
| Abu-abu (given) | Sudah lengkap, jangan diubah. |
| Kuning (complete the methods) | Kelasnya sudah ada. Lengkapi isi method-nya. |
| Hijau (create this class) | Kelasnya belum ada. Buat sendiri. |

## Aturan Bisnis

| Hal | Aturan |
|---|---|
| ojek motor (`BikeRide`) | tarif = jarak x Rp 2.500 per km |
| ojek mobil (`CarRide`) | tarif = jarak x Rp 4.000 per km. Punya layanan asuransi perjalanan (`Insurable`) dengan biaya tetap Rp 3.000. |
| ojek motor | Tidak punya layanan asuransi perjalanan. |
| jarak tidak valid | Valid hanya bila jarak lebih dari 0 dan paling banyak 50 km. Di luar itu, lempar exception dengan pesan `Invalid distance: ` diikuti nilainya, contoh `Invalid distance: 55.0`. |
| Checkout | pengatur perjalanan meminta metode pembayaran mencatat kode dan tarif. |

Gunakan tipe `double` untuk jarak, tarif, dan biaya.

## Contoh Terpandu: Toko Hewan

Sebelum mulai, lihat satu contoh yang sudah dibahas: **toko hewan** (soal yang berbeda dari soalmu). Diagramnya punya bentuk yang sama dengan soalmu.

![Contoh toko hewan](docs/worked-example.png)

Contoh ini dikerjakan tahap demi tahap. Perhatikan polanya, lalu terapkan pada Ojek Online.

| Tahap | Di toko hewan | Di Ojek Online |
|---|---|---|
| 1 | `Owner`: simpan nama pemilik, tolak nama kosong. | `Passenger`: simpan nama penumpang, tolak nama kosong. |
| 2 | `Cat` dan `Dog` mewarisi `Pet`. Hanya `Dog` yang mengimplementasikan `Vaccinatable`. | `BikeRide` dan `CarRide` mewarisi `Ride`. Hanya `CarRide` yang mengimplementasikan `Insurable`. |
| 3 | `CareCalculator` menjumlahkan biaya perawatan semua hewan dalam satu looping, memeriksa vaksin dengan `instanceof Vaccinatable`, dan menolak hewan yang usianya tidak valid dengan `InvalidAgeException`. | `RideCalculator` melakukan hal yang sama untuk perjalanan. |
| 4 | `PetShop` menyimpan hewan di `List` dan mencarinya lewat kode dengan `Map`. | `RideDispatcher` melakukan hal yang sama untuk perjalanan. |
| 5 | `PetShop` menerima `Receipt` dari luar lewat constructor. Tidak membuat pencetak sendiri, dan tidak mencetak sendiri. Jenis hewan baru langsung bekerja tanpa mengubah `PetShop`. | `RideDispatcher` menerima `PaymentMethod` dari luar. Jenis perjalanan baru langsung bekerja tanpa mengubah `RideDispatcher`. |

## Tahap 1: Pemanasan (15 poin)

**Tujuan:** melengkapi `Passenger` agar menyimpan data dan menjaga nama tetap valid.

**Yang kamu kerjakan:**

1. Deklarasikan field untuk kode dan nama. Semua field `private`.
2. Isi constructor dan kedua getter.
3. Isi `setName`: nama `null`, kosong, atau hanya berisi spasi diabaikan, dan nama lama tetap.

<details>
<summary>Petunjuk</summary>

Field dituliskan di bagian atas kelas, masing-masing diawali `private`. Di constructor, nilai parameter dipindahkan ke field dengan kata `this`. Untuk nama yang hanya berisi spasi, ingat bahwa `String` punya method untuk membuang spasi di ujung dan method untuk memeriksa apakah isinya kosong.
</details>

**Cara menguji:** `mvn test -Dtest="PassengerConstructorGetterTest,PassengerEncapsulationTest"`

## Tahap 2: Kelas Abstrak dan Interface (20 poin)

**Tujuan:** membuat dua subclass dari `Ride`, dan memberi kemampuan tambahan hanya pada salah satunya.

**Yang kamu kerjakan:**

1. Buat kelas **`BikeRide`** yang `extends Ride`. Constructor menerima tiga parameter seperti di diagram dan meneruskannya ke `super`. Isi `calculateFare()`: jarak x Rp 2.500 per km.
2. Buat kelas **`CarRide`** yang `extends Ride` dan `implements Insurable`. Isi `calculateFare()`: jarak x Rp 4.000 per km. Isi `insuranceFee()`: Rp 3.000.
3. `BikeRide` **tidak** boleh mengimplementasikan `Insurable`.

<details>
<summary>Petunjuk</summary>

Kelas baru dibuat di folder yang sama dengan kelas lain. Constructor subclass menerima tiga parameter seperti constructor kelas abstrak, lalu memanggil `super` di baris pertamanya. Tanda `@Override` membantu compiler memastikan kamu benar-benar mengisi method abstrak. Interface dipakai dengan kata `implements`, dan kelas yang memakainya wajib mengisi semua method interface itu.
</details>

**Cara menguji:** `mvn test -Dtest="SubclassStructureTest,BikeRidePriceTest,CarRidePriceTest,AbilityInterfaceTest,AbstractAndInterfaceRulesTest"`

## Tahap 3: Polimorfisme dan Exception (20 poin)

**Tujuan:** melengkapi `RideCalculator` agar memproses banyak perjalanan lewat tipe `Ride`, dan menolak data yang tidak valid dengan exception.

**Yang kamu kerjakan:**

1. `totalFare`: jumlahkan tarif semua perjalanan dalam satu looping. Daftar kosong menghasilkan 0.
2. `totalInsurance`: jumlahkan biaya asuransi perjalanan dari perjalanan yang punya kemampuan itu. Periksa dengan `instanceof Insurable`, bukan dengan nama subclass.
3. `validate`: lempar `InvalidDistanceException` bila jarak tidak valid, dengan pesan `Invalid distance: ` diikuti nilainya.
4. `isAcceptable`: panggil `validate` di dalam `try`/`catch`. Kembalikan `true` bila valid dan `false` bila exception terlempar.

<details>
<summary>Petunjuk</summary>

Satu looping cukup. Di dalamnya, panggil method yang sama pada tiap objek, dan biarkan tiap objek menjawab dengan aturannya sendiri: itulah polimorfisme. Untuk kemampuan tambahan, tanyakan apakah objeknya `Insurable` (bukan apakah objeknya `CarRide`), supaya jenis lain yang punya kemampuan sama ikut terhitung. Method `validate` memakai `throw` untuk melempar exception baru. Method `isAcceptable` menangkapnya dengan `catch` lalu mengembalikan nilai boolean, jadi exception tidak keluar dari method itu.
</details>

**Cara menguji:** `mvn test -Dtest="TotalPriceTest,TotalAbilityTest,ValidateTest,IsAcceptableTest"`

## Tahap 4: Collections (15 poin)

**Tujuan:** melengkapi `RideDispatcher` agar menyimpan perjalanan dan mencarinya dengan cepat.

**Yang kamu kerjakan:**

1. Isi constructor: simpan metode pembayaran yang diberikan, dan siapkan koleksi yang kosong.
2. `add`: simpan perjalanan di `List` **dan** di `Map` (kuncinya kode perjalanan).
3. `findById`: cari lewat `Map`. Bila kodenya tidak ada, kembalikan `null`.
4. `count` dan `getOrders`: jumlah dan daftar menurut urutan penambahan.

Jangan memakai array.

<details>
<summary>Petunjuk</summary>

Dua koleksi bekerja berdampingan: `List` mengingat urutan, `Map` mencari lewat kunci. Method `add` mengisi keduanya. `Map` mengembalikan `null` untuk kunci yang tidak ada, jadi `findById` tidak perlu looping sama sekali. Semua field dibuat `private`.
</details>

**Cara menguji:** `mvn test -Dtest="DeskAddCountTest,DeskFindByIdTest,DeskFindMissingTest,DeskOrderTest,DeskCollectionsTest"`

## Tahap 5: SOLID (30 poin)

**Tujuan:** menerapkan prinsip SOLID pada `RideDispatcher` lewat satu method, `checkout`.

**Yang kamu kerjakan:**

1. Simpan metode pembayaran dari constructor di field bertipe **interface** `PaymentMethod`.
2. `checkout`: cari perjalanan lewat kodenya, lalu minta metode pembayaran itu mencatat kode dan tarif-nya. Bila kodenya tidak ada, tidak melakukan apa-apa.
3. `RideDispatcher` **tidak** mencatat apa pun sendiri, dan **tidak** membuat `CashPayment` di dalam dirinya.
4. Jangan mengecek nama subclass. Jenis perjalanan baru harus langsung bekerja tanpa mengubah `RideDispatcher` maupun `RideCalculator`.

Tes tahap ini membuat jenis perjalanan baru **di dalam tes** untuk membuktikan kodemu tidak perlu diubah.

| Prinsip | Cara tes memeriksanya |
|---|---|
| Dependency Inversion (DIP) | `RideDispatcher` memegang `PaymentMethod` (interface), bukan kelas konkretnya. Objek pencetak palsu dari tes harus menerima panggilan. |
| Single Responsibility (SRP) | `RideDispatcher` tidak memakai `System.out`. Tugas mencatat milik metode pembayaran. |
| Open/Closed (OCP) | Jenis baru buatan tes diterima dan dihitung tanpa perubahan apa pun pada kodemu. |
| Liskov Substitution (LSP) | Semua subclass `Ride`, termasuk yang tarif-nya 0, diperlakukan sama. |

<details>
<summary>Petunjuk</summary>

Constructor menerima objek bertipe interface dan menyimpannya di field bertipe interface. Di `checkout`, cukup cari perjalanan lalu serahkan kode dan tarif-nya ke pencetak. Kamu tidak perlu tahu pencetaknya mencetak ke layar, ke berkas, atau ke tempat lain: itu urusan pencetaknya. Untuk tarif, panggil `calculateFare()` pada objeknya, apa pun jenisnya.
</details>

**Cara menguji:** `mvn test -Dtest="DeskInterfaceTest,CheckoutUsesPrinterTest,DeskPrintsNothingTest,NewSubclassNoChangeTest,SubstitutionTest,NoConcretePrinterTest"`

## Mencoba Secara Manual

`Main.java` adalah tempat bebas untuk mencoba programmu (tidak dinilai). Setelah tahap 2 sampai 5 selesai, kamu bisa menulis percobaan di sana. Sebagai pegangan, hasil yang benar untuk 5 km:

- ojek motor: tarif `12500.0`.
- ojek mobil: tarif `20000.0` dan biaya asuransi perjalanan `3000.0`.
- Jumlah tarif keduanya: `32500.0`.
- Checkout perjalanan bernomor `L1` (ojek motor) menghasilkan baris: `Payment L1: Rp 12500.0`.

Jalankan lewat NetBeans (**Run Project**), VS Code (**Run** di atas `main`), atau terminal:

```bash
mvn -q compile exec:java
```

## Memulai

Repositori ini adalah **template**:

1. Klik tombol hijau **Use this template**, lalu **Create a new repository**. Atur visibilitas menjadi **Private**, dan beri nama, misalnya `oop-quiz2-ride-<nama-kamu>`.
2. Clone repositori **milikmu**:
   ```bash
   git clone git@github.com:<username-kamu>/oop-quiz2-ride-<nama-kamu>.git
   ```
3. Buka proyek di editor, kerjakan tahap demi tahap, lalu commit dan push.
4. Setiap push menjalankan autograder. Buka tab **Actions** di repositorimu untuk melihat skormu. Bila GitHub meminta mengaktifkan workflow, klik **I understand my workflows, enable them**.

## Membuka Proyek

Ini proyek Maven biasa, tanpa konfigurasi tambahan.

**NetBeans**
1. **File, Open Project...**
2. Pilih folder `oop-quiz2-ride-...` (NetBeans mengenalinya sebagai proyek Maven), lalu **Open Project**.
3. Klik kanan proyek, lalu **Test** untuk menjalankan semua tes. Satu tes dijalankan dari node `Test Packages`.

**Visual Studio Code**
1. Pasang **Extension Pack for Java** (Microsoft).
2. **File, Open Folder...** lalu pilih folder hasil clone.
3. Jalankan tes dari sidebar **Testing** (ikon labu), atau lewat terminal: `mvn test`.

## Membaca Hasil Tes

Jalankan `mvn test` di terminal, atau lihat tab **Actions**. Tiap tes yang gagal menulis satu kalimat yang menyebut **aturan yang dilanggar**. Perbaiki satu kelompok tes pada satu waktu, lalu jalankan kelompok itu lagi. Bila muncul error `Not implemented yet`, method itu masih kosong.

## Penilaian

Total **100 poin**, terbagi dalam 22 kelompok tes. Sebuah kelompok mendapat poinnya bila semua tes di dalamnya lulus. Jalankan semuanya dengan `mvn test`, atau satu kelompok dengan `mvn test -Dtest=NamaKelasTes`.

| # | Kelompok tes | Tahap | Poin |
|---|---|---|---:|
| 1 | Passenger Constructor and Getter Test | 1 | 5 |
| 2 | Passenger Encapsulation Test | 1 | 10 |
| 3 | Subclass Structure Test | 2 | 4 |
| 4 | BikeRide Price Test | 2 | 4 |
| 5 | CarRide Price Test | 2 | 4 |
| 6 | Insurable Interface Test | 2 | 4 |
| 7 | Abstract Class and Interface Rules Test | 2 | 4 |
| 8 | RideCalculator Total Price (Polymorphism) Test | 3 | 5 |
| 9 | RideCalculator Insurable Total (instanceof) Test | 3 | 5 |
| 10 | RideCalculator Validate (Exception) Test | 3 | 5 |
| 11 | RideCalculator isAcceptable (try/catch) Test | 3 | 5 |
| 12 | RideDispatcher Add and Count Test | 4 | 3 |
| 13 | RideDispatcher Find By Id Test | 4 | 3 |
| 14 | RideDispatcher Find Missing Returns Null Test | 4 | 3 |
| 15 | RideDispatcher Keeps Insertion Order Test | 4 | 3 |
| 16 | RideDispatcher Uses List and Map Test | 4 | 3 |
| 17 | RideDispatcher Depends on PaymentMethod Interface Test (DIP) | 5 | 5 |
| 18 | Checkout Uses Injected PaymentMethod Test (DIP) | 5 | 7 |
| 19 | RideDispatcher Prints Nothing Itself Test (SRP) | 5 | 4 |
| 20 | New Subclass Needs No Change Test (OCP) | 5 | 8 |
| 21 | Any Subclass Substitutes Test (LSP) | 5 | 3 |
| 22 | No Concrete PaymentMethod Inside RideDispatcher Test (DIP) | 5 | 3 |
| | **Total** | | **100** |

## Aturan

- **Jangan mengubah** berkas di `src/test/**` dan `.github/**`.
- Ikuti diagram kelas persis: nama kelas, field, method, dan signature dipakai oleh autograder.
- Semua field harus `private`.
- Di `RideDispatcher`, pakai `List` dan `Map`. Jangan memakai array.
- Kelas abu-abu sudah lengkap dan tidak boleh diubah.
- Kerjakan sendiri. Repositori yang mirip akan diperiksa.
