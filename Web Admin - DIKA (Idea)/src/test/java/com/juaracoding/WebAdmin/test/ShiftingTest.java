package com.juaracoding.WebAdmin.test;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.WebAdmin.pages.Management.ShiftingPage;
import com.juaracoding.WebAdmin.pages.authentication.LoginPage;
import com.juaracoding.WebAdmin.pages.dashboards.DashboardPage;
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

    //  Test Positive ++ (Search Data Shifting (Data ditemukan))
    @Test(enabled = false)
    public void searchTest() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuShifting();
        shiftingPage.cariData("Bank KB Bukopin");


        String expected = "Bank KB Bukopin";
        String actual = shiftingPage.getTextTableDataElement();
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());

        shiftingPage.resetPencarian();

    }

    //  Test Negative -- (Search Data Shifting (Data tidak ditemukan))
    @Test(enabled = false)
    public void searchTest2() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuShifting();
        shiftingPage.cariData("BRI");

        String expected = "0-0 of 0";
        String actual = shiftingPage.getPage();
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());

        shiftingPage.resetPencarian();

    }


    //  Test Positive ++ (Reset Pencarian Data Shifting (Success))
    @Test(enabled = false)
    public void resetTest() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuShifting();
        shiftingPage.cariData("Bank KB Bukopin");
        shiftingPage.resetPencarian();

        String actualField = shiftingPage.getFieldSearch();
        Assert.assertTrue(actualField.isEmpty());

    }

    //  Test Negative -- (Edit Shifting Dibatalkan)
    @Test(enabled = false)
    public void editTest2() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuShifting();

        shiftingPage.option1EditActivity();

        shiftingPage.klikBatal();

        String expectedDashboard = "Shifting";
        String actualDashboard = shiftingPage.getHeadingElement();
        Assert.assertEquals(actualDashboard, expectedDashboard);

    }

    //  Test Positive ++ (Edit Data Shifting (Success))
    @Test(enabled = false)
    public void editTest() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuShifting();

        shiftingPage.option1EditActivity();
        shiftingPage.inputNamaJamKerja  ("5 Hari Kerja - Shift Pagi (BukaLapak) Update");
        shiftingPage.pilihUnit          ("3D");
        shiftingPage.setJamMasuk        ("9","30");
        shiftingPage.setJamKeluar       ("18","30");
        shiftingPage.setBreakStart      ("13","00");
        shiftingPage.setBreakEnd        ("14","00");

        shiftingPage.klikSimpan();
        shiftingPage.cariData("5 Hari Kerja - Shift Pagi (BukaLapak) Update");

        String expected = "5 Hari Kerja - Shift Pagi (BukaLapak) Update";
        String actual = shiftingPage.getTextTableDataElement();
        Assert.assertEquals(actual, expected);

        shiftingPage.resetPencarian();

    }

    //  Test Negative -- (Delete Data Shifting (Dibatalkan))
    @Test(enabled = false)
    public void deleteTest2() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuShifting();

        shiftingPage.option1DeleteActivity();

        shiftingPage.klikTidak();

        String expectedDashboard = "Shifting";
        String actualDashboard = shiftingPage.getHeadingElement();
        Assert.assertEquals(actualDashboard, expectedDashboard);

    }


    //  Test Positive ++ (Delete Data Shifting (Success))
    @Test(enabled = false)
    public void deleteTest() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuShifting();

        shiftingPage.option2DeleteActivity();

        shiftingPage.klikYa();
        shiftingPage.cariData("5 Hari Kerja - Shift Pagi (Indolakto)");

        String expectedPage = "0-0 of 0";
        String actualPage = shiftingPage.getPage();
        Assert.assertEquals(actualPage, expectedPage);

        shiftingPage.resetPencarian();

    }

    //  Test Negative -- (Tambahkan Data Shifting (Dibatalkan))
    @Test(enabled = false)
    public void addTest2() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");
        dashboardPage.menuManagement();
        dashboardPage.menuShifting();
        shiftingPage.klikTambahkan();

        shiftingPage.klikBatal();

        String expectedDashboard = "Shifting";
        String actualDashboard = shiftingPage.getHeadingElement();
        Assert.assertEquals(actualDashboard, expectedDashboard);

    }


    //  Test Positive ++ (Tambahkan Data Shifting (Success))
    @Test(priority = -1, enabled = false)
    public void addTest() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");
        dashboardPage.menuManagement();
        dashboardPage.menuShifting();
        shiftingPage.klikTambahkan();

        shiftingPage.inputNamaJamKerja("5 Hari Kerja - Shift Pagi (True Money BSNI)");
        shiftingPage.pilihUnit("APP Luar Kota");
        shiftingPage.setJamMasuk("8", "30");
        shiftingPage.setJamKeluar("17", "30");
        shiftingPage.inputCodeShifting("0029");
        shiftingPage.setBreakStart("12", "00");
        shiftingPage.setBreakEnd("13", "00");

        shiftingPage.klikTambah();
        shiftingPage.cariData("5 Hari Kerja - Shift Pagi (True Money BSNI)");

        String expected = "5 Hari Kerja - Shift Pagi (True Money BSNI)";
        String actual = shiftingPage.getTextTableDataElement();
        Assert.assertEquals(actual, expected);

        shiftingPage.resetPencarian();
    }












}































































































//            Assert.assertFalse(actual.isEmpty(), "Data tidak ditemukan di tabel padahal seharusnya ada!");


