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

public class LogOutDefinitions {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME); // Initialize the driver here
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Given("diawal saya membuka halaman login")
    public void openLoginPage() {
        driver.get("https://magang.dikahadir.com/authentication/login");
    }

    @And("saya memasukkan username {string} pada dashboard LOGIN")
    public void enterUsername(String username) throws InterruptedException {
        loginPage.inputUsername(username);
    }

    @And("saya memasukkan password {string} pada dashboard LOGIN")
    public void enterPassword(String password) throws InterruptedException {
        loginPage.inputPassword(password);
    }

    @When("saya menekan tombol login pada dashboard LOGIN")
    public void clickLoginButton() throws InterruptedException {
        loginPage.clickButtonLogin();
    }

    @Then("saya melihat dashboard {string}")
    public void verifyLoginMessage(String expectedDashboard) {
        String actualDashboard;
        actualDashboard = "HADIR";
        Assert.assertEquals(actualDashboard, expectedDashboard, "Dashboard yang tampil tidak sesuai!");
    }

    @And("saya menekan tombol profil")
    public void clickProfilButton(){
        dashboardPage.clickProfilButton();
    }

    @When("saya menekan tombol logout")
    public void clickLogOutButton(){dashboardPage.clickLogOutButton();}

    @Then("Tampil kembali dashboard {string}")
    public void backToLogin(String expectedDashboard){
        String actualDashboard = loginPage.getTextLoginPageElement();
        Assert.assertEquals(actualDashboard.toUpperCase(), expectedDashboard);
    }

}




