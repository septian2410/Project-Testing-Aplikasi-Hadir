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

public class ShiftingDeleteDefinitions {


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
    @Given("ketiga kalinya saya membuka halaman shifting pada Web Admin")
    public void openLoginPage() {
        dashboardPage.menuHome();
        dashboardPage.menuManagement();
        dashboardPage.menuShifting();
    }


    // case negatif
    @And("saya menekan tombol option delete pada data Kedua halaman shifting")
    public void klikOptionData2() {
        shiftingPage.option2DeleteActivity();
    }

    @And("saya menekan tombol Tidak pada form delete shifting")
    public void klikBatal() {
        shiftingPage.klikTidak();
    }

    @Then("saya melihat form hapus shifting telah menghilang")
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

    // case positive
    @And("saya menekan tombol option delete kembali pada data kedua")
    public void klikEditData2() {
        shiftingPage.klikEditData2();
    }

    @And("saya menekan tombol Ya pada form delete shifting")
    public void klikSimpan() {
        shiftingPage.klikYa();
    }

    @When("saya mencari data shifting yang telah dihapus yaitu {string}")
    public void cariData(String data) {
        shiftingPage.cariData(data);
    }

    @Then("tampil data pencarian {string} telah ter-Hapus pada table shifting")
    public void verifyDeleteSuksesMessage(String expectedMessage) {
        if (expectedMessage.equals("0-0 of 0")) {
            String actualMessage = shiftingPage.getPage();
            Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
       Delay(TWO);
        }


    }

}