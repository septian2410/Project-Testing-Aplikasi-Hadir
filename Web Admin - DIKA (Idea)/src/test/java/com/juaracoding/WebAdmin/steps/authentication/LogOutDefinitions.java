package com.juaracoding.WebAdmin.steps.authentication;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
import com.juaracoding.WebAdmin.pages.authentication.LoginPage;
import com.juaracoding.WebAdmin.pages.dashboards.DashboardPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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
    public void Delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @And("saya menekan tombol profil")
    public void clickProfilButton(){
        dashboardPage.menuHome();
        dashboardPage.menuPending();
        dashboardPage.clickProfilButton();
        Delay();
    }

    @When("saya menekan tombol logout")
    public void clickLogOutButton(){dashboardPage.clickLogOutButton();}

    @Then("Tampil kembali dashboard LOGIN dengan logo teks {string}")
    public void backToLogin(String expectedLogo){

        String actualLogo = loginPage.getTextLoginPageElement();
        Assert.assertEquals(actualLogo, expectedLogo);      // login login
        Delay();
    }

}




