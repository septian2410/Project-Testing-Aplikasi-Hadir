package com.juaracoding.WebUser.steps;

import com.juaracoding.WebUser.pages.authentication.LoginPage;
import com.juaracoding.WebUser.pages.dashboards.DashboardPage;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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

    @Given("saya membuka halaman login pada Web User")
    public void openLoginPage() {
        driver.get("https://magang.dikahadir.com/absen/login");
    }

                @And("saya memasukkan email {string} pada Web User")
                public void enterEmail(String email) throws InterruptedException {
                    loginPage.inputEmail(email);
                }

                @And("saya memasukkan password {string} pada Web User")
                public void enterPassword(String password) throws InterruptedException {
                    loginPage.inputPassword(password);
                }

    @When("saya menekan tombol login pada Web User")
    public void clickLoginButton() throws InterruptedException {
        loginPage.clickButtonLogin();
    }

    @Then("tampil dashboard LOGIN dengan teks {string} pada Web User")
    public void verifyLoginMessage(String expectedMessage) throws InterruptedException {
        if (expectedMessage.equals("Akun tidak ditemukan") || expectedMessage.equals("Email atau password salah")) {
            String actualMessage = loginPage.getTextErrorNoteElement();
            Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
        }
    }

    @Then("terlihat dashboard HADIR dengan teks {string} pada Web User")
    public void verifyLoginMessage2(String expectedMessage) throws InterruptedException {
        if (expectedMessage.equals("Kehadiranmu")) {
            String actualMessage = dashboardPage.getTextDashboardMenuHeadingElement();
            Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
        }

}}

