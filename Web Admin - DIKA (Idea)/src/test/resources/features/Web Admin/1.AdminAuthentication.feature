Feature: Admin Authentication Functionality

  Background:
    Given saya membuka halaman login pada Web Admin

#  Scenario: Pengujian Login dengan Akun yang Tidak Terdaftar
#    And saya memasukkan email "khevin@hadir.com" pada Web Admin
#    And saya memasukkan password "123" pada Web Admin
#    When saya menekan tombol login pada Web Admin
#    Then saya melihat dashboard "LOGIN" dengan teks "Akun tidak ditemukan" pada Web Admin
#
#  Scenario: Pengujian Login dengan Kredensial yang Salah (Password Salah, Username Salah, dll.)
#    And saya memasukkan email "admin@hadir.com" pada Web Admin
#    And saya memasukkan password "123" pada Web Admin
#    When saya menekan tombol login pada Web Admin
#    Then saya melihat dashboard "LOGIN" dengan teks "Email atau password salah" pada Web Admin

  Scenario: Pengujian Login dengan Kredensial valid
    And saya memasukkan email "admin@hadir.com" pada Web Admin
    And saya memasukkan password "admin@hadir" pada Web Admin
    When saya menekan tombol login pada Web Admin
    Then saya melihat dashboard "HADIR" dengan teks "© 2022 Aplikasi Hadir" pada Web Admin

















#  Feature: Admin Authentication Functionality
#
#    Background:
#      Given saya membuka halaman login pada Web Admin
#
#    Scenario: Pengujian Login dengan Akun yang Tidak Terdaftar
#      And saya memasukkan email "khevin@hadir.com" pada Web Admin
#      And saya memasukkan password "123" pada Web Admin
#      When saya menekan tombol login pada Web Admin
#      Then saya melihat dashboard "LOGIN" dengan teks "Akun tidak ditemukan" pada Web Admin
#
#  Scenario: Pengujian Login dengan Kredensial yang Salah (Password Salah, Username Salah, dll.)
#      And saya memasukkan email "admin@hadir.com" pada Web Admin
#      And saya memasukkan password "123" pada Web Admin
#      When saya menekan tombol login pada Web Admin
#      Then saya melihat dashboard "LOGIN" dengan teks "Email atau password salah" pada Web Admin
#
#    Scenario: Pengujian Login dengan Kredensial valid
#        And saya memasukkan email "admin@hadir.com" pada Web Admin
#        And saya memasukkan password "admin@hadir" pada Web Admin
#        When saya menekan tombol login pada Web Admin
#        Then saya melihat dashboard "HADIR" dengan teks "© 2022 Aplikasi Hadir" pada Web Admin
#
