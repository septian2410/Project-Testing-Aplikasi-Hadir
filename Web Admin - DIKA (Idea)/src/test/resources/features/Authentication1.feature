Feature: Auth Functionality

  Scenario: Pengujian Login dengan Kredensial valid
    Given saya membuka halaman login
    And saya memasukkan username "admin@hadir.com"
    And saya memasukkan password "admin@hadir"
    When saya menekan tombol login
    Then saya melihat dashboard "HADIR" dengan teks "Dashboard Menu"


  Scenario: Pengujian Login dengan Akun yang Tidak Terdaftar
    Given saya membuka halaman login
    And saya memasukkan username "pandu@hadir.com"
    And saya memasukkan password "123"
    When saya menekan tombol login
    Then saya melihat dashboard "LOGIN" dengan teks "Akun tidak ditemukan"


  Scenario: Pengujian Login dengan Kredensial yang Salah (Password Salah, Username Salah, dll.)
    Given saya membuka halaman login
    And saya memasukkan username "admin@hadir.com"
    And saya memasukkan password "123"
    When saya menekan tombol login
    Then saya melihat dashboard "LOGIN" dengan teks "Email atau password salah"


  Scenario: Pengujian Berhasil LogOut
    Given diawal saya membuka halaman login
    And saya memasukkan username "admin@hadir.com" pada dashboard LOGIN
    And saya memasukkan password "admin@hadir" pada dashboard LOGIN
    When saya menekan tombol login pada dashboard LOGIN
    Then saya melihat dashboard "HADIR"
    And saya menekan tombol profil
    When saya menekan tombol logout
    Then Tampil kembali dashboard "LOGIN"

