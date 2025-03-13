package com.juaracoding.steps;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
import com.juaracoding.pages.authentication.LoginPage;
import com.juaracoding.pages.dashboards.DashboardPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class LoginDefinitions {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME); // Initialize the driver here
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Given("saya membuka halaman login")
    public void openLoginPage() {
        driver.get("https://magang.dikahadir.com/authentication/login");
    }

    @And("saya memasukkan username {string}")
    public void enterUsername(String username) throws InterruptedException {
        loginPage.inputUsername(username);
    }

    @And("saya memasukkan password {string}")
    public void enterPassword(String password) throws InterruptedException {
        loginPage.inputPassword(password);
    }

    @When("saya menekan tombol login")
    public void clickLoginButton() throws InterruptedException {
        loginPage.clickButtonLogin();
    }

    @Then("saya melihat dashboard {string} dengan teks {string}")
    public void verifyLoginMessage(String expectedDashboard, String expectedMessage) {

        String actualDashboard;
        if (expectedMessage.equals("Dashboard Menu")) {
            String actualMessage = dashboardPage.getTextDashboardMenuHeadingElement();
                Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
                actualDashboard = "HADIR";

        } else if (expectedMessage.equals("Akun tidak ditemukan") || expectedMessage.equals("Email atau password salah")) {
            String actualMessage    = loginPage.getTextErrorNoteElement();
                Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
                actualDashboard    ="LOGIN";

        } else {
            actualDashboard = "Halaman tidak ditemukan";
        }
        Assert.assertEquals(actualDashboard, expectedDashboard, "Dashboard yang tampil tidak sesuai!");
    }


}




