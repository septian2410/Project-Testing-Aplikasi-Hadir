package com.juaracoding.WebUser.steps;

import com.juaracoding.WebUser.pages.dashboards.DashboardPage;
import com.juaracoding.WebUser.pages.authentication.LoginPage;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
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

    @And("saya menekan tombol menu")
    public void clickMenuButton(){
        dashboardPage.clickMenuButton();
    }

    @When("saya menekan tombol logout pada dashboard HADIR di Web User")
    public void clickLogOutButton(){dashboardPage.clickLogOutButton();}

    @Then("Tampil kembali dashboard LOGIN dengan kolom input email yang masih kosong")
    public void backToLogin() throws InterruptedException {
        String actualField = loginPage.getFieldEmailElement();
        Assert.assertTrue(actualField.isEmpty());

    }

}




