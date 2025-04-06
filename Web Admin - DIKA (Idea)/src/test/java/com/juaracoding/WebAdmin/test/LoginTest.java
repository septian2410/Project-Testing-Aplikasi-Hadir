package com.juaracoding.WebAdmin.test;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
import com.juaracoding.WebAdmin.pages.authentication.LoginPage;
import com.juaracoding.WebAdmin.pages.dashboards.DashboardPage;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest  {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME); // Initialize the driver here
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    //    Test Positive ++ (Button Login)
    @Test(priority = -1)
    public void loginTest1() throws InterruptedException    {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir") ;

        String expected = "Dashboard Menu";
        String actual = dashboardPage.getTextDashboardMenuHeadingElement();
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());
    }

    //    Test Negative -- (Button Login, Akun tidak ditemukan)
    @Test
    public void loginTest2() throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("pandu@mail.com", "123");

        String expected = "Akun tidak ditemukan";
        String actual = loginPage.getTextErrorNoteElement();
        Assert.assertEquals(actual, expected);
    }

    //    Test Negative -- (Button Login, Email atau password salah)
    @Test
    public void loginTest3() throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "123");

        String expected = "Email atau password salah";
        String actual = loginPage.getTextErrorNoteElement();
        Assert.assertEquals(actual, expected);
    }
}


