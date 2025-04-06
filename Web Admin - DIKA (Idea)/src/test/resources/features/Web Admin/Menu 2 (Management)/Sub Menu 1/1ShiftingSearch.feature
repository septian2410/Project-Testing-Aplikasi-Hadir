Feature: Search Shifting

  @TC_Shifting_Search_Data_Tidak_Ditemukan  @Negative
  Scenario: Sistem menampilkan tabel kosong jika pencarian shifting tidak ditemukan.
    Given saya membuka halaman shifting pada Web Admin
    And saya memasukkan data pencarian "BRI" pada kolom input pencarian nama
    When saya menekan tombol search
    Then tampil data pencarian "0-0 of 0" terlihat pada table shifting

  @TC_Shifting_Search_Data_Ditemukan  @Positive
  Scenario: Sistem menampilkan hasil pencarian jika data shifting tersedia.
    And saya memasukkan data pencarian "BCA Life" pada kolom input pencarian nama
    When saya menekan tombol search
    Then tampil data pencarian "BCA Life" berhasil tampil pada table shifting


