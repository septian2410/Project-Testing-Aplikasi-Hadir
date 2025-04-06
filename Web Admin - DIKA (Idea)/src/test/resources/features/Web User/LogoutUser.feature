Feature: User Authentication (Logout)

  @TC_User_Logout_Sukses  @Positive
  Scenario: Pengujian Berhasil LogOut.
      And saya menekan tombol menu
      When saya menekan tombol logout pada dashboard HADIR di Web User
      Then Tampil kembali dashboard LOGIN dengan kolom input email yang masih kosong
