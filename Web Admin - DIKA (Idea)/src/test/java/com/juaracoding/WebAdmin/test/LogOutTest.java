package com.juaracoding.WebAdmin.test;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
import com.juaracoding.WebAdmin.pages.authentication.LoginPage;
import com.juaracoding.WebAdmin.pages.dashboards.DashboardPage;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME); // Initialize the driver here
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    //    Test Positive ++ (Button logOut)
    @Test(priority = -1)
    public void loginTest1() throws InterruptedException    {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir") ;

        String expected1 = "Dashboard Menu";
        String actual1 = dashboardPage.getTextDashboardMenuHeadingElement();
        Assert.assertEquals(actual1.toLowerCase(), expected1.toLowerCase());

        dashboardPage.clickLogOutButton();

        String expected2 = "Login";
        String actual2 = loginPage.getTextLoginPageElement();
        Assert.assertEquals(actual2.toLowerCase(), expected2.toLowerCase());
    }


}
