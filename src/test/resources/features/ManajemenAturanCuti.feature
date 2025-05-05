@ManagementAturanCuti
Feature: Manajemen Aturan Cuti

  Scenario: Menampilkan Semua Manajemen Aturan Cuti Teratas
    When Saya Membuka Manajemen Aturan Cuti
    Then Aplikasi Menampilkan Semua Manajemen Aturan Cuti Teratas

  Scenario: Menambahkan data cuti baru tanpa nama cuti
    Given Saya Menekan Tombol Tambah Cuti
    And Saya Mengisi Nama Cuti ""
    And Saya Mengisi Jumlah Cuti "9"
    And Saya Mengisi Jumlah Bulan Kerja Sisa Cuti "6"
    And Saya Mengisi Maksimal Sisa Cuti "4"
    And Saya Menekan Tombol Simpan Cuti
    Then Saya Melihat Notifikasi Gagal "Nama aturan cuti harus diisi!"

  Scenario: Mencari Manajemen Aturan Cuti Berdasarkan Nama Cuti "Cuti Hamil"
    Given Nama Cuti "Cuti Hamil" di Kolom Pencarian Manajemen Aturan Cuti
    When Saya menekan tombol Search Manajemen Aturan Cuti
    Then Sistem Menampilkan Manajemen Aturan Cuti Berdasarkan Nama Cuti "Cuti Hamil"

  Scenario: Mencari Manajemen Aturan Cuti Yang Tidak Ada Berdasarkan Nama Cuti "Hari Kiamat"
    Given Nama Cuti "Hari Kiamat" di Kolom Pencarian Manajemen Aturan Cuti
    When Saya menekan tombol Search Manajemen Aturan Cuti
    Then Sistem Menampilkan Hasil "Tidak Ada Data" Nama Pencarian Manajemen Aturan Cuti

  Scenario: Menghilangkan Filter Pencarian Manajemen Aturan Cuti
    Given Nama Cuti "Aturan Cuti New" di Kolom Pencarian Manajemen Aturan Cuti
    When Saya menekan tombol Search Manajemen Aturan Cuti
    When Saya menekan tombol Riset Filter Manajemen Aturan Cuti
    Then Sistem Menampilkan Semua Manajemen Aturan Cuti


  Scenario: Menambahkan data cuti baru
    Given Saya Menekan Tombol Tambah Cuti
    And Saya Mengisi Nama Cuti "Cuti Hamil"
    And Saya Mengisi Jumlah Cuti "9"
    And Saya Mengisi Jumlah Bulan Kerja Sisa Cuti "6"
    And Saya Mengisi Maksimal Sisa Cuti "4"
    And Saya Menekan Tombol Simpan Cuti
    Then Saya Melihat Notifikasi "Sukses Membuat Aturan Cuti"

  Scenario: Menghapus data cuti paling atas
    Given Saya Mencari Cuti Dengan Nama "Cuti Hamil"
    When Saya Menekan Tombol Seting Cuti
    And Saya Menghapus Cuti
    And Saya Menekan Tombol Konfirmasi Hapus Cuti
    Then Cuti Berhasil Dihapus

  Scenario: Mengubah Data Manajemen Aturan Cuti Dengan Menghapus Nama Cuti
    Given Saya Mencari Cuti Dengan Nama "Angka Batas Umum"
    When Saya Menekan Tombol Seting Cuti
    And Saya Menekan Tombol Edit
    And Saya Menghapus Nama
    And Saya Menekan Tombol Edit Simpan Cuti
    Then Saya Melihat Notifikasi Gagal Edit "Nama aturan cuti harus diisi!"

  Scenario: Menampilkan Rincian Data dari Salah Satu Aturan Cuti
    Given Saya Mencari Cuti Dengan Nama "Cuti Hamil"
    When Saya Menekan Tombol Seting Cuti
    And Saya Menekan Tombol Lihat
    Then Saya Melihat Rincian Data Cuti

  Scenario: Menambahkan data cuti baru dengan ankga diluar batas umum
    Given Saya Menekan Tombol Tambah Cuti
    And Saya Mengisi Nama Cuti "Angka Batas Umum"
    And Saya Mengisi Jumlah Cuti "1234"
    And Saya Mengisi Jumlah Bulan Kerja Sisa Cuti "8888"
    And Saya Mengisi Maksimal Sisa Cuti "7890"
    And Saya Menekan Tombol Simpan Cuti
    Then Pembuatan Data Aturan Cuti Gagal

  Scenario: Mengubah Data Manajemen Aturan Cuti
    Given Saya Mencari Cuti Dengan Nama "Angka Batas Umum"
    When Saya Menekan Tombol Seting Cuti
    And Saya Menekan Tombol Edit
    And Saya Mengubah Nama Cuti "Test Ubah Data Nama"
    And Saya Menekan Tombol Edit Simpan Cuti
    Then Saya Melihat Notifikasi "Data Berhasil Disimpan"

  Scenario: Menambahkan data cuti baru dengan ankga minus
    Given Saya Menekan Tombol Tambah Cuti
    And Saya Mengisi Nama Cuti "Angka Batas Umum Minus"
    And Saya Mengisi Jumlah Cuti "-123"
    And Saya Mengisi Jumlah Bulan Kerja Sisa Cuti "-4567"
    And Saya Mengisi Maksimal Sisa Cuti "-7890"
    And Saya Menekan Tombol Simpan Cuti
    Then Pembuatan Data Aturan Cuti Gagal

  Scenario: Menampilkan 5 Manajemen Aturan Cuti Teratas
    When Saya Mengubah Jumlah Tampilan Tabel Manajemen Aturan Cuti Menjadi 5
    Then Aplikasi Menampilkan 5 Manajemen Aturan Cuti Teratas
