package com.juaracoding.WebAdmin.test;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.WebAdmin.pages.Management.JadwalPage;
import com.juaracoding.WebAdmin.pages.Management.ShiftingPage;
import com.juaracoding.WebAdmin.pages.authentication.LoginPage;
import com.juaracoding.WebAdmin.pages.dashboards.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JadwalTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ShiftingPage shiftingPage;
    private JadwalPage jadwalPage;
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
        jadwalPage = new JadwalPage(driver);
    }

    //  Test Positive ++ (Tambahkan Data Jadwal (Success))
    @Test(priority = -1,enabled = false)
    public void addTest() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");
        dashboardPage.menuManagement();
        dashboardPage.menuJadwal();
        jadwalPage.klikTambahkan();

        jadwalPage.inputJadwalKerja("1 (True Money BSNI)");
        jadwalPage.inputToleransiKeterlambatan("30");
        jadwalPage.pilihTipeJadwal("Jadwal kerja flexible");
        jadwalPage.pilihTanggalEfective("2025", "28");
        jadwalPage.klikHariKerja();
        jadwalPage.pilihHariSenin("5 Hari Kerja - Shift Pagi (True Money BSNI)");
        jadwalPage.pilihHariSelasa("5 Hari Kerja - Shift Pagi (True Money BSNI)");
        jadwalPage.pilihHariRabu("5 Hari Kerja - Shift Pagi (True Money BSNI)");
        jadwalPage.pilihHariKamis("5 Hari Kerja - Shift Pagi (True Money BSNI)");
        jadwalPage.pilihHariJumat("5 Hari Kerja - Shift Pagi (True Money BSNI)");
        jadwalPage.klikTerapkan();
        jadwalPage.klikTambah();

        jadwalPage.cariData("1 (True Money BSNI)");

        String expected = "1 (True Money BSNI)";
        String actual = jadwalPage.getTextTableDataElement();
        Assert.assertEquals(actual, expected);

        jadwalPage.resetPencarian();
    }

    //  Test Negative -- (Tambahkan Data Jadwal (Dibatalkan))
    @Test(enabled = false)
    public void addTest2() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");
        dashboardPage.menuManagement();
        dashboardPage.menuJadwal();
        jadwalPage.klikTambahkan();

        jadwalPage.klikBatal();

        String expectedDashboard = "Jadwal";
        String actualDashboard = jadwalPage.getHeadingElement();
        Assert.assertEquals(actualDashboard, expectedDashboard);

    }

    //  Test Positive ++ (Search Data Jadwal (Data ditemukan))
    @Test(enabled = false)
    public void searchTest() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuJadwal();
        jadwalPage.cariData("1 (Bukalapak)");

        String expected = "1 (Bukalapak)";
        String actual = jadwalPage.getTextTableDataElement();
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());

        jadwalPage.resetPencarian();

    }

    //  Test Negative -- (Search Data Jadwal (Data tidak ditemukan))
    @Test(enabled = false)
    public void searchTest2() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuJadwal();
        jadwalPage.cariData("BRI");

        String expected = "0-0 of 0";
        String actual = jadwalPage.getPage();
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());

        jadwalPage.resetPencarian();

    }

    //  Test Positive ++ (Reset Pencarian Data Jadwal (Success))
    @Test(enabled = false)
    public void resetTest() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuJadwal();
        jadwalPage.cariData("1 (Bukalapak)");
        jadwalPage.resetPencarian();

        String actualField = jadwalPage.getFieldSearch();
        Assert.assertTrue(actualField.isEmpty());

    }

    //  Test Positive ++ (Edit Data Jadwal (Success))
    @Test(enabled = false)
    public void editTest() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuJadwal();

        jadwalPage.option1EditActivity();
        jadwalPage.inputJadwalKerja             ("1 (Bukalapak) Update");
        jadwalPage.pilihTipeJadwal              ("Jadwal kerja flexible");
        jadwalPage.pilihTanggalEfective         ("2025", "5");
        jadwalPage.klikHariKerja();
        jadwalPage.pilihHariSenin   ("5 Hari Kerja - Shift Pagi (BukaLapak) Update");
        jadwalPage.pilihHariSelasa  ("5 Hari Kerja - Shift Pagi (BukaLapak) Update");
        jadwalPage.pilihHariRabu    ("5 Hari Kerja - Shift Pagi (BukaLapak) Update");
        jadwalPage.pilihHariKamis   ("5 Hari Kerja - Shift Pagi (BukaLapak) Update");
        jadwalPage.pilihHariJumat   ("5 Hari Kerja - Shift Pagi (BukaLapak) Update");
        jadwalPage.klikTerapkan();
        jadwalPage.klikSimpan();

        jadwalPage.cariData("1 (Bukalapak) Update");
        String expected = "1 (Bukalapak) Update";
        String actual = jadwalPage.getTextTableDataElement();
        Assert.assertEquals(actual, expected);

        jadwalPage.resetPencarian();
    }

    //  Test Negative -- (Edit Jadwal Dibatalkan)
    @Test(enabled = false)
    public void editTest2() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuJadwal();

        jadwalPage.option1EditActivity();

        jadwalPage.klikBatal();

        String expectedDashboard = "Jadwal";
        String actualDashboard = jadwalPage.getHeadingElement();
        Assert.assertEquals(actualDashboard, expectedDashboard);

    }

    //  Test Positive ++ (Delete Data Jadwal (Success))
    @Test(enabled = false)
    public void deleteTest() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuJadwal();

        jadwalPage.option2DeleteActivity();

        jadwalPage.klikYa();
        jadwalPage.cariData("1 (Indolakto)");

        String expectedPage = "0-0 of 0";
        String actualPage = jadwalPage.getPage();
        Assert.assertEquals(actualPage, expectedPage);

        shiftingPage.resetPencarian();

    }

    //  Test Negative -- (Delete Data Jadwal (Dibatalkan))
    @Test(enabled = false)
    public void deleteTest2() {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.loginActivity("admin@hadir.com", "admin@hadir");

        dashboardPage.menuManagement();
        dashboardPage.menuJadwal();

        jadwalPage.option1DeleteActivity();

        jadwalPage.klikTidak();

        String expectedDashboard = "Jadwal";
        String actualDashboard = jadwalPage.getHeadingElement();
        Assert.assertEquals(actualDashboard, expectedDashboard);

    }


}
