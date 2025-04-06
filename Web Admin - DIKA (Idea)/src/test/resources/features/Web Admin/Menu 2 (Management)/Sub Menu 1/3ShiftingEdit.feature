Feature: Edit Shifting

  @TC_Shifting_Edit_Dibatalkan @Negative
  Scenario: Pengguna Membatalkan pengubahan Data Shifting.
    Given kedua kalinya saya membuka halaman shifting pada Web Admin
    When saya menekan tombol option edit pada data pertama halaman shifting di Web Admin
    When saya menekan tombol Batal pada form edit shifting
    Then saya melihat form edit shifting telah menghilang

  @TC_Shifting_Edit_Sukses  @Positive
  Scenario: Berhasil Mengubah Data Shifting.
    When saya menekan tombol option edit kembali pada data pertama
    And saya mengubah nama jam kerja data pertama menjadi "5 Hari Kerja - Shift Pagi (BukaLapak) Update"
    And saya mengubah unit kerja data pertama menjadi "3D"
    When saya menekan tombol Simpan pada form edit shifting
    When saya mencari data shifting yang telah diubah yaitu "5 Hari Kerja - Shift Pagi (BukaLapak) Update"
    Then tampil data pencarian "5 Hari Kerja - Shift Pagi (BukaLapak) Update" telah ter-Update pada table shifting




