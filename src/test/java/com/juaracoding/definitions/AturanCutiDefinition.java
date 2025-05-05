package com.juaracoding.definitions;

import com.juaracoding.pages.AturanCutiPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.juaracoding.drivers.utils.DriverWaitHelper;
import com.juaracoding.drivers.utils.SleepHelper;
import com.juaracoding.drivers.utils.UrlHelper;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AturanCutiDefinition {
    private AturanCutiPage AturanCutiPage;

    @Before("@ManagementAturanCuti")
    public void setup() {
        AturanCutiPage = new AturanCutiPage();
        UrlHelper.goToManajemenManagementUnitLeaveUrl();
    }

    @Given("Nama Cuti {string} di Kolom Pencarian Manajemen Aturan Cuti")
    public void setInputNameManajemenAturanCuti(String name) {
        SleepHelper.SleepLong();
        AturanCutiPage.inputName(name);
    }

    @When("Saya menekan tombol Search Manajemen Aturan Cuti")
    public void executeSearchManajemenAturanCuti() {
        AturanCutiPage.pressSearchButton();
    }

    @Then("Sistem Menampilkan Manajemen Aturan Cuti Berdasarkan Nama Cuti {string}")
    public void verifySearchResultManajemenAturanCuti(String expectedName) {
        SleepHelper.SleepLong();
        Assert.assertTrue(AturanCutiPage.verifySearchResult(expectedName));

    }

    @When("Saya menekan tombol Riset Filter Manajemen Aturan Cuti")
    public void executeResetFilterManajemenAturanCuti() {
        SleepHelper.SleepLong();
        AturanCutiPage.pressFilterResetButton();
    }

    // Sistem Menampilkan Semua Manajemen Aturan Cuti
    @Then("Sistem Menampilkan Semua Manajemen Aturan Cuti")
    public void verifyAllManajemenAturanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(AturanCutiPage.verifyAllManajemenAturanCuti());
    }

    // Aplikasi Menampilkan "0" Hasil Pencarian Manajemen Aturan Cuti
    @Then("Sistem Menampilkan Hasil {int} Pencarian Manajemen Aturan Cuti")
    public void verifyZeroSearchResultManajemenAturanCuti(int expectedRows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(AturanCutiPage.getNumberOfTableRows(), expectedRows);
    }

    // isNoData
    @Then("Sistem Menampilkan Hasil {string} Nama Pencarian Manajemen Aturan Cuti")
    public void verifyNoDataManajemenAturanCuti(String expectedText) {
        SleepHelper.SleepLong(); // Tunggu elemen muncul
        String actualText = com.juaracoding.pages.AturanCutiPage.getNoDataText();

        // Validasi teks
        Assert.assertEquals(actualText, expectedText, "Pesan 'Tidak Ada Data' tidak sesuai!");
    }

    // When Saya Mengubah Jumlah Tampilan Tabel Manajemen Aturan Cuti Menjadi 5
    @When("Saya Mengubah Jumlah Tampilan Tabel Manajemen Aturan Cuti Menjadi {int}")
    public void changeRowsPerPageManajemenAturanCuti(int rows) {
        AturanCutiPage.changeRowsPerPage(rows);
    }

    // Then Sistem Menampilkan Jumlah Tampilan Tabel Manajemen Aturan Cuti Menjadi 5
    @Then("Sistem Menampilkan Jumlah Tampilan Tabel Manajemen Aturan Cuti Menjadi {int}")
    public void verifyRowsPerPageManajemenAturanCuti(int rows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(AturanCutiPage.getNumberOfTableRows(), rows);
    }

    // Then Aplikasi Menampilkan 5 Manajemen Aturan Cuti Teratas
    @Then("Aplikasi Menampilkan {int} Manajemen Aturan Cuti Teratas")
    public void verifyTopManajemenAturanCuti(int rows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(AturanCutiPage.getNumberOfTableRows(), rows);
    }

    // Saya Berpindah Ke Manajemen Aturan Cuti Halaman Selanjutnya
    @When("Saya Berpindah Ke Manajemen Aturan Cuti Halaman Selanjutnya")
    public void goToNextPageManajemenAturanCuti() {
        AturanCutiPage.pressNextPageButton();
    }

    // Then Aplikasi Menampilkan Manajemen Aturan Cuti Halaman
    @Then("Aplikasi Menampilkan Manajemen Aturan Cuti Halaman Kedua")
    public void verifyCurrentPageNumberManajemenAturanCuti() {
        SleepHelper.SleepLong();
        SleepHelper.SleepLong();
        Assert.assertTrue(AturanCutiPage.isSecondPage());
        SleepHelper.SleepLong();
    }

    // Saya Berpindah Ke Manajemen Aturan Cuti Halaman Sebelumnya
    @When("Saya Berpindah Ke Manajemen Aturan Cuti Halaman Sebelumnya")
    public void goToPreviousPageManajemenAturanCuti() {
        AturanCutiPage.pressPreviousPageButton();
    }

    // Aplikasi Menampilkan Manajemen Aturan Cuti Halaman Pertama
    @Then("Aplikasi Menampilkan Manajemen Aturan Cuti Halaman Pertama")
    public void verifyFirstPageManajemenAturanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(AturanCutiPage.isFirstPage());
    }

    // Saya Berpindah Ke Manajemen Aturan Cuti Halaman Terakhir
    @When("Saya Berpindah Ke Manajemen Aturan Cuti Halaman Terakhir")
    public void goToLastPageManajemenAturanCuti() {
        AturanCutiPage.pressLastPageButton();
    }

    // Aplikasi Menampilkan Manajemen Aturan Cuti Halaman Terakhir
    @Then("Aplikasi Menampilkan Manajemen Aturan Cuti Halaman Terakhir")
    public void verifyLastPageManajemenAturanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(AturanCutiPage.isLastPage());
        SleepHelper.SleepLong();
    }

    // And Saya Berpindah Ke Manajemen Aturan Cuti Halaman Pertama
    @And("Saya Berpindah Ke Manajemen Aturan Cuti Halaman Pertama")
    public void goToFirstPageManajemenAturanCuti() {
        SleepHelper.SleepLong();
        AturanCutiPage.pressFirstPageButton();
        SleepHelper.SleepLong();
    }

    // Saya Membuka Manajemen Aturan Cuti
    @When("Saya Membuka Manajemen Aturan Cuti")
    public void openManajemenAturanCuti() {
        AturanCutiPage.open();
    }

    // Then Aplikasi Menampilkan Semua Manajemen Aturan Cuti Teratas
    @Then("Aplikasi Menampilkan Semua Manajemen Aturan Cuti Teratas")
    public void verifyDataShowedManajemenAturanCuti() {

        Assert.assertTrue(AturanCutiPage.isDataShowed());

    }

    // Given Saya Mencari Cuti Dengan Nama "Test Bug Cuti Maksimal"
    @Given("Saya Mencari Cuti Dengan Nama {string}")
    public void searchCuti(String name) {
        SleepHelper.SleepLong();
        AturanCutiPage.inputName(name);
        // click search button
        AturanCutiPage.pressSearchButton();
    }

    // When Saya Menekan Tombol Seting Cuti
    @When("Saya Menekan Tombol Seting Cuti")
    public void clickSettingCuti() {
        AturanCutiPage.clickSetingButton();
    }

    // Saya Menghapus Cuti
    @And("Saya Menghapus Cuti")
    public void deleteCuti() {
        AturanCutiPage.clickDeleteButton();
    }

    // And Saya Menekan Tombol Edit
    @And("Saya Menekan Tombol Edit")
    public void clickEditCuti() {
        AturanCutiPage.clickEditButton();
    }
    //clickViewButton
    @And("Saya Menekan Tombol Lihat")
    public void clickViewCuti() { AturanCutiPage.clickViewButton();

    }

    // Saya Mengubah Nama Cuti
    @And("Saya Mengubah Nama Cuti {string}")
    public void editCutiName(String name) {
        // AturanCutiPage.inputCutiName(name); dihapus isi sebelumnya
        AturanCutiPage.editCutiName(name);

    }
    //Saya Menghapus Nama
    @And("Saya Menghapus Nama")
    public void deleteCutiName() {
        AturanCutiPage.deleteCutiName();
    }
    //Saya Melihat Notifikasi Gagal Edit "Nama aturan cuti harus diisi!"
    @Then("Saya Melihat Notifikasi Gagal Edit {string}")
    public void verifyEditCutiFailed(String expectedMessage) {
        String actualMessage = AturanCutiPage.getErrorMessageEdit();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    // And Saya Menekan Tombol Konfirmasi Hapus Cuti
    @And("Saya Menekan Tombol Konfirmasi Hapus Cuti")
    public void confirmDeleteCuti() {
        AturanCutiPage.confirmDelete();
    }

    // Then Cuti Berhasil Dihapus
    @Then("Cuti Berhasil Dihapus")
    public void verifyDeleteCuti() {
        Assert.assertTrue(AturanCutiPage.isSuccessMessageDisplayed());
    }

    // Given Saya Menekan Tombol Tambah Cuti
    // And Saya Mengisi Nama Cuti "Test Cuti Baru"
    // And Saya Mengisi Jumlah Cuti "10"
    // And Saya Menekan Tombol Simpan Cuti
    // Then Saya Melihat Notifikasi "Data Berhasil Disimpan"
    @Given("Saya Menekan Tombol Tambah Cuti")
    public void clickAddCuti() {
        SleepHelper.SleepLong();
        AturanCutiPage.clickAddButton();
    }

    @And("Saya Mengisi Nama Cuti {string}")
    public void inputCutiName(String name) {
        AturanCutiPage.inputCutiName(name);
    }

    // inputEligibleLeaveTotalMonth
    @And("Saya Mengisi Jumlah Cuti {string}")
    public void inputEligibleLeaveTotalMonth(String total) {
        AturanCutiPage.inputEligibleLeaveTotalMonth(total);
    }

    @And("Saya Menekan Tombol Simpan Cuti")
    public void clickSaveCuti() {
        AturanCutiPage.BUTTON_TAMBAHKAN();
    }
    //BUTTON_SIMPAN
    //Saya Menekan Tombol Edit Simpan Cuti
    @And("Saya Menekan Tombol Edit Simpan Cuti")
    public void clickEditSaveCuti() {
        AturanCutiPage.BUTTON_SIMPAN();
    }

    @And("Saya Mengisi Tanggal Cuti Dengan Tanggal {string}")
    public void isiTanggalCuti(String tanggalCuti) {
        AturanCutiPage.isiTanggalCuti(tanggalCuti);
    }

    // inputCarryForwardTotalMonth
    @And("Saya Mengisi Jumlah Bulan Kerja Sisa Cuti {string}")
    public void inputCarryForwardTotalMonth(String total) {
        AturanCutiPage.inputCarryForwardTotalMonth(total);
    }

    // inputEligibleLeaveTotalMonth Maksimal Sisa Cuti
    @And("Saya Mengisi Maksimal Sisa Cuti {string}")
    public void inputMaksimalSisaCuti(String total) {
        AturanCutiPage.inputMaxCarryForward(total);
    }

    @Then("Saya Melihat Notifikasi Gagal {string}")
    public void sayaMelihatNotifikasiGagal(String expectedMessage) {
        String actualMessage = AturanCutiPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    // clickButtonDate
    @And("Saya Menekan Tombol Tanggal")
    public void clickButtonDate() {
        AturanCutiPage.clickButtonDate();
    }

    @Then("Saya Melihat Notifikasi {string}")
    public void verifySuccessMessage(String message) {
        Assert.assertTrue(AturanCutiPage.isSuccessMessageDisplayed());
    }

    @Then("Saya Melihat Notifikasi Sukses Ini Berarti Gagal {string}")
    public void verifyPopupMessage(String expectedMessage) {
        String actualMessage = AturanCutiPage.getPopupMessage();

        if (actualMessage.contains("Sukses")) {
            Assert.fail("Seharusnya gagal, tetapi malah muncul notifikasi sukses: " + actualMessage);
        } else {
            Assert.assertEquals(expectedMessage, actualMessage);
        }
    }

    @Then("Pembuatan Data Aturan Cuti Gagal")
    public void verifyPopupMessage() {
        Assert.assertFalse(AturanCutiPage.isPembuatanAturanCutiSukes());
    }
    //Saya Melihat Rincian Data Cuti
    @Then("Saya Melihat Rincian Data Cuti")
    public void verifyDetailCuti() {
        Assert.assertTrue(AturanCutiPage.isDetailCutiShowed());
    }

}
