Feature: Auth Functionality

  Scenario Outline: Pengujian Login dengan Berbagai Kredensial
    Given saya membuka halaman login
    And saya memasukkan username "<user>"
    And saya memasukkan password "<pass>"
    When saya menekan tombol login
    Then saya melihat pesan "<result>"

    Examples:
      | user   | pass  | result               |
      | admin  | admin | login sukses         |
      | pandu  | 123   | akun tidak ditemukan |
