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
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.juaracoding.drivers.utils.TimeDuration.TWO;

public class ShiftingSearchNegatifAndPositifDefinitions {

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
    @Given("saya membuka halaman shifting pada Web Admin")
    public void openLoginPage() {
//        dashboardPage.menuHome();
        Delay(TWO);
        dashboardPage.menuManagement();
        dashboardPage.menuShifting();
    }

    @And("saya memasukkan data pencarian {string} pada kolom input pencarian nama")
    public void inputDataPencarian(String data) {shiftingPage.inputDataPencarian(data);}

    @When("saya menekan tombol search")
    public void klikSearch() {shiftingPage.klikSearch();}

    // Pencarian tidak berhasil
    @Then("tampil data pencarian {string} terlihat pada table shifting")
    public void verifySearchNotFoundMessage(String expectedMessage) {
        if (expectedMessage.equals("0-0 of 0")) {
            String actualMessage = shiftingPage.getPage();
            Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
        Delay(TWO);
        shiftingPage.resetPencarian();
        Delay(TWO);
        }
    }

    // Pencarian berhasil
    @Then("tampil data pencarian {string} berhasil tampil pada table shifting")
    public void verifySearchSuccessMessage(String expectedMessage) {
        if (expectedMessage.equals("BCA Life")) {
            String actualMessage = shiftingPage.getTextTableDataElement();
            Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
        Delay(TWO);
        }}


}
