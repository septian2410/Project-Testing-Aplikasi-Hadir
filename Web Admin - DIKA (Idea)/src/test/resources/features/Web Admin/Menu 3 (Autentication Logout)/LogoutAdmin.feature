Feature: Admin Authentication (Logout)

  @TC_Admin_Logout_Sukses  @Positive
  Scenario: Pengujian Berhasil LogOut
    And saya menekan tombol profil
    When saya menekan tombol logout
    Then Tampil kembali dashboard LOGIN dengan logo teks "Login"
