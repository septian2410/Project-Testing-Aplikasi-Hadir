package com.juaracoding.WebAdmin.steps.shifting;

import com.juaracoding.WebAdmin.pages.Management.ShiftingPage;
import com.juaracoding.WebAdmin.pages.authentication.LoginPage;
import com.juaracoding.WebAdmin.pages.dashboards.DashboardPage;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.juaracoding.drivers.utils.TimeDuration.TWO;

public class ShiftingTambahDefinitions {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ShiftingPage shiftingPage;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME); // Initialize the driver here
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        shiftingPage = new ShiftingPage(driver);
    }
    private void Delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Delay interrupted: " + e.getMessage());
        }
    }

    // Universal
    @Given("keempat kalinya saya membuka halaman shifting pada Web Admin")
    public void openLoginPage() {
        dashboardPage.menuHome();
        dashboardPage.menuManagement();
        dashboardPage.menuShifting();
    }

    @When("saya menekan tombol Tambahkan pada halaman shifting")
    public void klikTambahkan() {
        shiftingPage.klikTambahkan();
    }

    @When("saya menekan tombol Tambah pada form tambah shifting")
    public void klikTambah() {
        shiftingPage.klikTambah();
    }


    // case negatif 1
    @When("saya menekan tombol Batal pada form tambah shifting")
    public void klikBatal() {
        shiftingPage.klikBatal();
    }

    @Then("saya melihat form tambah shifting telah menghilang")
    public void missingFormTambah() {
        // Tunggu sampai elemen (dialog/form) menghilang
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isElementGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("/html/body/div[13]/div[3]/div/form")));

        // Verifikasi apakah elemen telah menghilang
        if (isElementGone) {
            System.out.println("Dialog box/form tambah shifting telah menghilang");
        } else {
            System.out.println("Popup masih ada.");
        }
        Delay(TWO);
}

    // case negatif 2 & 3
    @Then("saya melihat validasi {string}")
    public void validasi1(String expectedMessage) {
        if (expectedMessage.equals("Nama shifting harus diisi!")) {
            String actualMessage = shiftingPage.getValidation1();
            Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
        } else {
            String actualMessage = shiftingPage.getValidation2();
            Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
        }
        shiftingPage.klikBatal();
        Delay(TWO);
    }


    // case negatif 3
    @And("saya memasukkan nama jam kerja {string}")
    public void inputJamKerja(String jamKerja) {
        shiftingPage.inputNamaJamKerja(jamKerja);
    }

    @And("saya memasukkan kode shifting {string}")
    public void inputCodeShifting(String code) {
        shiftingPage.inputCodeShifting(code);
    }

    @And("saya memilih jam masuk {string} dan menit {string}")
    public void selectJamMasuk(String jam, String menit) {
        shiftingPage.setJamMasuk(jam, menit);
    }

    @And("saya memilih jam keluar {string} dan menit {string}")
    public void selectJamKeluar(String jam, String menit) {
        shiftingPage.setJamKeluar(jam, menit);
    }

    // case positif
    @And("saya memilih unit kerja {string}")
    public void selectUnitKerja(String unit) {
        shiftingPage.pilihUnit(unit);
    }

    @And("saya memilih Break Start atau awal jam istirahat {string} dan menit {string}")
    public void selectBreakStart(String jam, String menit) {
        shiftingPage.setBreakStart(jam, menit);
    }

    @And("saya memilih Break End atau akhir jam istirahat {string} dan menit {string}")
    public void selectBreakEnd(String jam, String menit) {
        shiftingPage.setBreakEnd(jam, menit);
    }

    @When("saya mencari data shifting yang telah ditambahkan yaitu {string}")
    public void cariData(String data) {
        shiftingPage.cariData(data);
    }

    @Then("tampil data pencarian baru {string} pada table shifting")
    public void verifyTambahMessage(String expectedMessage) {
        if (expectedMessage.equals("5 Hari Kerja - Shift Pagi (True Money BSNI)")) {
            String actualMessage = shiftingPage.getTextTableDataElement();
            Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
            Delay(TWO);
        }
    }
}



