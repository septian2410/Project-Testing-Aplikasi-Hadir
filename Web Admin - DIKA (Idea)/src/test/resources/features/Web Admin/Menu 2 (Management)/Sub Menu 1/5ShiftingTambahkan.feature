Feature: Tambahkan Shifting

  @TC_Shifting_Tambahkan_Dibatalkan  @Negative
  Scenario: Pengguna Membatalkan Penambahan Data Shifting.
    Given keempat kalinya saya membuka halaman shifting pada Web Admin
    When saya menekan tombol Tambahkan pada halaman shifting
    When saya menekan tombol Batal pada form tambah shifting
    Then saya melihat form tambah shifting telah menghilang

  @TC_Shifting_Tambah_Gagal_KolomKosong  @Negative
  Scenario: pengguna mencoba menambahkan shifting tanpa mengisi satu pun kolom input.
    When saya menekan tombol Tambahkan pada halaman shifting
    When saya menekan tombol Tambah pada form tambah shifting
    Then saya melihat validasi "Nama shifting harus diisi!"

  @TC_Shifting_Tambah_Gagal_KodeTerpakai  @Negative
  Scenario: Pengguna mencoba menambahkan shifting dengan kode yang sudah digunakan.
    When saya menekan tombol Tambahkan pada halaman shifting
    And saya memasukkan nama jam kerja "5 Hari Kerja - Shift Pagi (BCA)"
    And saya memasukkan kode shifting "0032"
    And saya memilih jam masuk "8" dan menit "30"
    And saya memilih jam keluar "17" dan menit "30"
    When saya menekan tombol Tambah pada form tambah shifting
    Then saya melihat validasi "Kode shifting sudah digunakan"

  @TC_Shifting_Tambahkan_Sukses  @Positive
  Scenario: Berhasil Menambahkan Data Shifting.
    When saya menekan tombol Tambahkan pada halaman shifting
    And saya memasukkan nama jam kerja "5 Hari Kerja - Shift Pagi (True Money BSNI)"
    And saya memilih unit kerja "APP Luar Kota"
    And saya memasukkan kode shifting "0050"
    And saya memilih jam masuk "8" dan menit "30"
    And saya memilih jam keluar "17" dan menit "30"
    And saya memilih Break Start atau awal jam istirahat "12" dan menit "00"
    And saya memilih Break End atau akhir jam istirahat "13" dan menit "00"
    When saya menekan tombol Tambah pada form tambah shifting
    When saya mencari data shifting yang telah ditambahkan yaitu "5 Hari Kerja - Shift Pagi (True Money BSNI)"
    Then tampil data pencarian baru "5 Hari Kerja - Shift Pagi (True Money BSNI)" pada table shifting


