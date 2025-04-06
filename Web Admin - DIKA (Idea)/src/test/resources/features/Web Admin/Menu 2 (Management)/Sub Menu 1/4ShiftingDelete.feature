Feature: Delete Shifting

  @TC_Shifting_Delete_Dibatalkan  @Negative
  Scenario: Tidak ada perubahan saat pengguna membatalkan penghapusan jadwal.
    Given ketiga kalinya saya membuka halaman shifting pada Web Admin
    And saya menekan tombol option delete pada data Kedua halaman shifting
    And saya menekan tombol Tidak pada form delete shifting
    Then saya melihat form hapus shifting telah menghilang

  @TC_Shifting_Delete_Sukses  @Positive
  Scenario: Pengguna berhasil menghapus data jadwal dan data tidak lagi tersedia.
    And saya menekan tombol option delete kembali pada data kedua
    And saya menekan tombol Ya pada form delete shifting
    When saya mencari data shifting yang telah dihapus yaitu "5 Hari Kerja - Shift Pagi (Indolakto)"
    Then tampil data pencarian "0-0 of 0" telah ter-Hapus pada table shifting
