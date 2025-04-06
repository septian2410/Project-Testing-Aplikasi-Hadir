Feature: Edit Jadwal Featured

  @TC_Jadwal_Edit_Dibatalkan  @Negative
  Scenario: Pengguna Membatalkan pengubahan Data Jadwal.
    Given kedua kalinya saya membuka halaman jadwal pada Web Admin
    When saya menekan tombol option edit pada data pertama halaman jadwal di Web Admin
    When saya menekan tombol Batal pada form edit data jadwal

    Then saya melihat form edit data jadwal telah menghilang

  @TC_Jadwal_Edit_Gagal_Tanpa_Perubahan  @Negative
  Scenario: Gagal mengedit data jadwal tanpa perubahan.
    When saya kembali menekan tombol option edit pada data pertama
    When saya menekan tombol simpan pada form edit data jadwal

    Then tampil validasi "Harap mengedit data hari terdahulu" pada form edit data jadwal

  @TC_Jadwal_Edit_Sukses  @Positive
  Scenario: Pengguna Berhasil Mengubah Data Jadwal.
    When saya kembali menekan tombol option edit pada data pertama
    And saya memilih Tipe jadwal Baru yaitu "Jadwal kerja flexible"
    And saya memilih Tanggal Efective Baru yaitu tanggal "10" April
    And saya memasukkan nama Jadwal kerja baru yaitu "1 (Bukalapak) Update"

    When saya menge-klik tombol hari kerja pada halaman jadwal di Web Admin
    And saya mengubah hari kerja baru pada senin "5 Hari Kerja - Shift Pagi (BukaLapak) Update"
    And saya mengubah hari kerja baru pada selasa "5 Hari Kerja - Shift Pagi (BukaLapak) Update"
    And saya mengubah hari kerja baru pada rabu "5 Hari Kerja - Shift Pagi (BukaLapak) Update"
    And saya mengubah hari kerja baru pada kamis "5 Hari Kerja - Shift Pagi (BukaLapak) Update"
    And saya mengubah hari kerja baru pada jumat "5 Hari Kerja - Shift Pagi (BukaLapak) Update"
    When saya menge-klik tombol terapkan pada form pilih hari kerja

    When saya menekan tombol simpan pada form edit data jadwal
    When saya mencari data jadwal yang telah diubah yaitu "1 (Bukalapak) Update"

    Then tampil data pencarian "1 (Bukalapak) Update" telah ter-Update pada table jadwal

