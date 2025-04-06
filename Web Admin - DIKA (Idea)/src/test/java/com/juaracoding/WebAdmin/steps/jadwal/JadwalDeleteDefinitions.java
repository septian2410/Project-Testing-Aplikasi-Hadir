package com.juaracoding.WebAdmin.steps.jadwal;

import com.juaracoding.WebAdmin.pages.Management.JadwalPage;
import com.juaracoding.WebAdmin.pages.authentication.LoginPage;
import com.juaracoding.WebAdmin.pages.dashboards.DashboardPage;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class JadwalDeleteDefinitions {


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
    public void Delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Universal
    @Given("keempat kalinya saya membuka halaman jadwal pada Web Admin")
    public void openLoginPage() {
        dashboardPage.menuHome();
        dashboardPage.menuManagement();
        dashboardPage.menuJadwal();
    }

            // case negatif
            @And("saya meng-klik tombol option delete pada data Kedua halaman jadwal")
            public void klikOptionData1() {
                jadwalPage.option2DeleteActivity();
            }

        @And("saya meng-klik tombol Tidak pada form hapus jadwal")
        public void klikBatal() {
                jadwalPage.klikTidak();
            }

                    @Then("saya melihat form hapus jadwal telah menghilang")
                    public void missingFormEdit() {
                        // Tunggu sampai elemen (dialog/form) menghilang
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                        boolean isElementGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(
                                By.xpath("/html/body/div[13]/div[3]/div/form")));

                        // Verifikasi apakah elemen telah menghilang
                        if (isElementGone) {
                            System.out.println("Dialog box/form delete jadwal telah menghilang");
                        } else {
                            System.out.println("Popup masih ada.");
                        }

                    }


            // case positif
            @And("saya kembali meng-klik tombol option delete pada data kedua")
            public void klikOptionData2() {
                jadwalPage.klikDeleteData2();
            }

    @And("saya meng-klik tombol Ya pada form hapus jadwal")
    public void klikSimpan() {
    jadwalPage.klikYa();
    }

    @When("saya mencari data jadwal yang telah dihapus yaitu {string}")
    public void cariData(String data) {jadwalPage.cariData(data);}

                @Then("tampil data pencarian {string} telah ter-Hapus pada table jadwal")
                public void verifyDeleteSuksesMessage(String expectedMessage) {
                if (expectedMessage.equals("0-0 of 0")) {
                    String actualMessage = jadwalPage.getPage();
                    Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
                Delay();
                }
            }



}
