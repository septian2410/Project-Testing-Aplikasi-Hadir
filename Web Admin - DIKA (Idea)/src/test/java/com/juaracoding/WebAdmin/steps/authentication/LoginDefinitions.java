package com.juaracoding.WebAdmin.steps.authentication;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
import com.juaracoding.WebAdmin.pages.authentication.LoginPage;
import com.juaracoding.WebAdmin.pages.dashboards.DashboardPage;
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
    public void Delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Given("saya membuka halaman login pada Web Admin")
    public void openLoginPage() {
        driver.get("https://magang.dikahadir.com/authentication/login");
    }

        @And("saya memasukkan password {string} pada Web Admin")
        public void enterPassword(String password) throws InterruptedException {
            loginPage.inputPassword(password);
        }

        @And("saya memasukkan email {string} pada Web Admin")
        public void enterUsername(String email) throws InterruptedException {
            loginPage.inputEmail(email);
        }

        @When("saya menekan tombol login pada Web Admin")
        public void clickLoginButton() throws InterruptedException {
            loginPage.clickButtonLogin();
        }

    @Then("tampil dashboard HADIR dengan copyright {string} pada Web Admin")
    public void verifyLoginMessage1(String expectedMessage) {
        if (expectedMessage.equals("© 2022 Aplikasi Hadir")) {
            String actualMessage = dashboardPage.getTextDashboardMenuHeadingElement();
                Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
            Delay();
        }}


    @Then("tampil dashboard LOGIN dengan validasi {string} pada Web Admin")
    public void verifyLoginMessage2(String expectedMessage) {
        if (expectedMessage.equals("Akun tidak ditemukan") || expectedMessage.equals("Email atau password salah")) {
            String actualMessage    = loginPage.getTextErrorNoteElement();
            Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");

        }}



}



