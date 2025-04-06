package com.juaracoding.WebAdmin.steps.jadwal;

import com.juaracoding.WebAdmin.pages.Management.JadwalPage;
import com.juaracoding.WebAdmin.pages.authentication.LoginPage;
import com.juaracoding.WebAdmin.pages.dashboards.DashboardPage;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.juaracoding.drivers.utils.TimeDuration.TWO;

public class JadwalSearchNegatifAndPositifDefinitions {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private JadwalPage jadwalPage;
    private WebDriver driver;



    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME); // Initialize the driver here
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        jadwalPage = new JadwalPage(driver);
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
    @Given("saya membuka halaman jadwal pada Web Admin")
    public void openLoginPage() {
        dashboardPage.menuManagement();
        dashboardPage.menuJadwal();
    }

    @And("saya memasukkan data pencarian {string} pada kolom input pencarian")
    public void inputDataPencarian(String data) {
        jadwalPage.inputDataPencarian(data);
    }

    @When("saya menekan tombol search pada halaman jadwal")
    public void klikSearch() {
        jadwalPage.klikSearch();
    }

    // Pencarian tidak berhasil
    @Then("tampil data pencarian {string} terlihat pada table jadwal")
    public void verifySearchNotFoundMessage(String expectedMessage) {
        if (expectedMessage.equals("0-0 of 0")) {
            String actualMessage = jadwalPage.getPage();
            Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
            Delay(TWO);
            jadwalPage.resetPencarian();
            Delay(TWO);
        }
    }

    // Pencarian berhasil
    @Then("tampil data pencarian {string} berhasil tampil pada table jadwal")
    public void verifySearchSuccessMessage(String expectedMessage) {
        if (expectedMessage.equals("BCA Life")) {
            String actualMessage = jadwalPage.getTextTableDataElement();
            Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
            Delay(TWO);
        }
    }

}
