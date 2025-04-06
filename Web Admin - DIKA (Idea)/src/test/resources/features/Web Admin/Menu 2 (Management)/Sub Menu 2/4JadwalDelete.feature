Feature: Delete Jadwal

  @TC_Jadwal_Delete_Dibatalkan  @Negative
  Scenario: Tidak ada perubahan saat pengguna membatalkan penghapusan jadwal.
    Given keempat kalinya saya membuka halaman jadwal pada Web Admin
    And saya meng-klik tombol option delete pada data Kedua halaman jadwal
    And saya meng-klik tombol Tidak pada form hapus jadwal
    Then saya melihat form hapus jadwal telah menghilang

  @TC_Jadwal_Delete_Sukses  @Positive
  Scenario: Pengguna berhasil menghapus data jadwal dan data tidak lagi tersedia.
    And saya kembali meng-klik tombol option delete pada data kedua
    And saya meng-klik tombol Ya pada form hapus jadwal
    When saya mencari data jadwal yang telah dihapus yaitu "1 (Indolakto)"
    Then tampil data pencarian "0-0 of 0" telah ter-Hapus pada table jadwal


