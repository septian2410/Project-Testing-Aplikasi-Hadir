Feature: User Authentication (Login)

  Background:
    Given saya membuka halaman login pada Web User

  @TC_User_Login_Gagal_AkunTidakTerdaftar  @Negative
  Scenario:  Pengujian Login dengan Akun yang Tidak Terdaftar.
    And saya memasukkan email "lazuardi@gmail.com" pada Web User
    And saya memasukkan password "12345" pada Web User
    When saya menekan tombol login pada Web User
    Then tampil dashboard LOGIN dengan teks "Akun tidak ditemukan" pada Web User


  @TC_User_Login_Gagal_KombinasiSalah  @Negative
  Scenario:  Pengujian Login dengan Kredensial yang Salah (Password Salah, Username Salah, dll.).
    And saya memasukkan email "hadirsqa1@gmail.com" pada Web User
    And saya memasukkan password "12345" pada Web User
    When saya menekan tombol login pada Web User
    Then tampil dashboard LOGIN dengan teks "Email atau password salah" pada Web User

 @TC_User_Login_Sukses  @Positive
  Scenario: Pengujian Login dengan Kredensial valid.
    And saya memasukkan email "hadirsqa1@gmail.com" pada Web User
    And saya memasukkan password "SQA@Hadir12345" pada Web User
    When saya menekan tombol login pada Web User
    Then terlihat dashboard HADIR dengan teks "Kehadiranmu" pada Web User



