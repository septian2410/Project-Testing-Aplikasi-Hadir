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

public class ShiftingEditDefinitions {

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
    @Given("kedua kalinya saya membuka halaman shifting pada Web Admin")
    public void openLoginPage() {
        dashboardPage.menuHome();
        dashboardPage.menuManagement();
        dashboardPage.menuShifting();
    }


    // case negatif
    @When("saya menekan tombol option edit pada data pertama halaman shifting di Web Admin")
    public void klikOptionData1() {
        shiftingPage.option1EditActivity();
    }

    @When("saya menekan tombol Batal pada form edit shifting")
    public void klikBatal() {
        shiftingPage.klikBatal();
    }

    @Then("saya melihat form edit shifting telah menghilang")
    public void missingFormDelete() {
        // Tunggu sampai elemen (dialog/form) menghilang
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isElementGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("/html/body/div[13]/div[3]/div/form")));

        // Verifikasi apakah elemen telah menghilang
        if (isElementGone) {
            System.out.println("Dialog box/form delete shifting telah menghilang");
        } else {
            System.out.println("Popup masih ada.");
        }
    }


    // case positif
    @When("saya menekan tombol option edit kembali pada data pertama")
    public void klik() {
        shiftingPage.klikEditData1();
    }

    @And("saya mengubah nama jam kerja data pertama menjadi {string}")
    public void inputJamKerja(String jamKerja) {
        shiftingPage.inputNamaJamKerja(jamKerja);
    }

    @And("saya mengubah unit kerja data pertama menjadi {string}")
    public void selectUnitKerja(String unit) {
        shiftingPage.pilihUnit(unit);
    }

    @When("saya menekan tombol Simpan pada form edit shifting")
    public void klikSimpan() {
        shiftingPage.klikSimpan();
    }

    @When("saya mencari data shifting yang telah diubah yaitu {string}")
    public void cariData(String data) {
        shiftingPage.cariData(data);
    }

    @Then("tampil data pencarian {string} telah ter-Update pada table shifting")
    public void verifyEditSuksesMessage(String expectedMessage) {
        if (expectedMessage.equals("5 Hari Kerja - Shift Pagi (BukaLapak) Update")) {
            String actualMessage = shiftingPage.getTextTableDataElement();
            Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
       Delay(TWO);
        }

    }
}
