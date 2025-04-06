package com.juaracoding.WebAdmin.steps.jadwal;

import com.juaracoding.WebAdmin.pages.Management.JadwalPage;
import com.juaracoding.WebAdmin.pages.authentication.LoginPage;
import com.juaracoding.WebAdmin.pages.dashboards.DashboardPage;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.juaracoding.drivers.utils.TimeDuration.TWO;

public class JadwalResetDefinitions {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private JadwalPage jadwalPage;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME); // Initialize the driver here
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        jadwalPage = new JadwalPage(driver);
    }
    private void Delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Delay interrupted: " + e.getMessage());
        }
    }


    @When("saya meng-klik tombol reset")
    public void klikReset() {
        jadwalPage.resetPencarian();
    }

            // Pencarian berhasil
            @Then("tampil kolom input pencarian sudah kosong kembali pada halaman Jadwal")
            public void verifyResetShiftingSuccessMessage() {
                String actualMessage = jadwalPage.getFieldSearch();
                Assert.assertTrue(actualMessage.isEmpty());
                Delay(TWO);
            }


}
