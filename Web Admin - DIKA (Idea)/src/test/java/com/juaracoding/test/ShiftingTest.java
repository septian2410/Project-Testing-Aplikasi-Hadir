package com.juaracoding.test;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
import com.juaracoding.pages.Management.ShiftingPage;
import com.juaracoding.pages.authentication.LoginPage;
import com.juaracoding.pages.dashboards.DashboardPage;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShiftingTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ShiftingPage shiftingPage;
    private WebDriver driver;


    @BeforeClass
    public void setup() {
        driver = DriverSingleton.driver;
    }

    @BeforeMethod
    public void createObj() {
    loginPage = new LoginPage(driver);
    dashboardPage = new DashboardPage(driver);
    shiftingPage = new ShiftingPage(driver);
    }


    //    Test Positive ++ (Add Shifting)
    @Test(priority = -1)
    public void loginTest1() throws InterruptedException    {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir") ;

        String expected = "Dashboard Menu";
        String actual = dashboardPage.getTextDashboardMenuHeadingElement();
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());

        dashboardPage.shiftingActivity();
        shiftingPage.addActivity();
            shiftingPage.inputNamaJamKerja("Shift Pagi (BCA Kalimalang)");
//            shiftingPage.inputUnit("BCA");
        shiftingPage.clickButtonComboBoxUnit("BCA");
//            shiftingPage.selectUnit("BCA");
            shiftingPage.inputCodeShifting("004");
        shiftingPage.jamMasukActivity();
            shiftingPage.setTime("9","30");
        shiftingPage.jamKeluarActivity();
            shiftingPage.setTime("17","30");
        shiftingPage.jamBreakStartActivity( );
            shiftingPage.setTime("12","00");
        shiftingPage.JamBreakEndActivity();
            shiftingPage.setTime("13","00");
        shiftingPage.addShiftingActivity();
//        shiftingPage.cancelShiftingActivity();

    }

}
