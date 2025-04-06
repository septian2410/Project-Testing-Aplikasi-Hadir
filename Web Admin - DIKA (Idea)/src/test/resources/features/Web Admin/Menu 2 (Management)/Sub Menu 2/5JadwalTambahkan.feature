Feature: Tambahkan Jadwal

  @TC_Jadwal_Tambahkan_Dibatalkan  @Negative
  Scenario: Tidak ada perubahan saat pengguna membatalkan penambahan jadwal.
    Given kelima kalinya saya membuka halaman jadwal pada Web Admin
    When saya menge-klik tombol Tambahkan pada halaman jadwal di Web Admin
    And saya menge-klik tombol Batal pada form tambah data jadwal

    Then saya melihat form tambah data jadwal telah menghilang

  @TC_Jadwal_Tambah_Gagal_KolomKosong  @Negative
  Scenario: Gagal Tambah Jadwal - Semua kolom kosong
    When saya menge-klik tombol Tambahkan pada halaman jadwal di Web Admin
    When saya menge-klik tombol Tambah pada form tambah data jadwal

    Then terlihat validasi Please fill out this field pada kolom tipe jadwal


  @TC_Jadwal_Tambahkan_Sukses  @Positive
  Scenario: Pengguna berhasil menambahkan data jadwal dengan input valid.
    When saya menge-klik tombol Tambahkan pada halaman jadwal di Web Admin

    And saya memilih Tipe jadwal yaitu "Jadwal kerja flexible"
    And saya memilih Tanggal Efective Baru yaitu tanggal "12" April 2025
    And saya memasukkan nama Jadwal kerja yaitu "1 (True Money BSNI)"

    When saya menekan tombol hari kerja pada halaman jadwal di Web Admin
    And saya memilih hari kerja pada senin "5 Hari Kerja - Shift Pagi (True Money BSNI)"
    And saya memilih hari kerja pada selasa "5 Hari Kerja - Shift Pagi (True Money BSNI)"
    And saya memilih hari kerja pada rabu "5 Hari Kerja - Shift Pagi (True Money BSNI)"
    And saya memilih hari kerja pada kamis "5 Hari Kerja - Shift Pagi (True Money BSNI)"
    And saya memilih hari kerja pada jumat "5 Hari Kerja - Shift Pagi (True Money BSNI)"
    When saya menekan tombol terapkan pada form Jumlah Hari Kerja

    And saya memasukkan waktu toleransi keterlambatan yaitu "30" menit

    When saya menge-klik tombol Tambah pada form tambah data jadwal
    When saya mencari data jadwal yang telah ditambah yaitu "1 (True Money BSNI)"

    Then tampil data pencarian "1 (True Money BSNI)" telah terlihat pada table jadwal


