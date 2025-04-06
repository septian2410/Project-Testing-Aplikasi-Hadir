Feature: Admin Authentication (Login)

  Background:
    Given saya membuka halaman login pada Web Admin

  @TC_Admin_Login_Gagal_AkunTidakTerdaftar  @Negative
  Scenario: Pengujian Login dengan Akun yang Tidak Terdaftar
    And saya memasukkan email "khevin@hadir.com" pada Web Admin
    And saya memasukkan password "123" pada Web Admin
    When saya menekan tombol login pada Web Admin
    Then tampil dashboard LOGIN dengan validasi "Akun tidak ditemukan" pada Web Admin


  @TC_Admin_Login_Gagal_KombinasiSalah  @Negative
  Scenario: Pengujian Login dengan Kredensial yang Salah (Password Salah, Username Salah, dll.)
    And saya memasukkan email "admin@hadir.com" pada Web Admin
    And saya memasukkan password "123" pada Web Admin
    When saya menekan tombol login pada Web Admin
    Then tampil dashboard LOGIN dengan validasi "Email atau password salah" pada Web Admin


  @TC_Admin_Login_Sukses  @Positive
  Scenario: Pengujian Login dengan Kredensial valid
    And saya memasukkan email "admin@hadir.com" pada Web Admin
    And saya memasukkan password "admin@hadir" pada Web Admin
    When saya menekan tombol login pada Web Admin
    Then tampil dashboard HADIR dengan copyright "© 2022 Aplikasi Hadir" pada Web Admin
