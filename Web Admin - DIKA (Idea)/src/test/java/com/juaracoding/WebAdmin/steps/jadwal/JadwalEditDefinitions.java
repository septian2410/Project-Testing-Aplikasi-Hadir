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

import static com.juaracoding.drivers.utils.TimeDuration.TWO;

public class JadwalEditDefinitions {

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

        // Universal
        @Given("kedua kalinya saya membuka halaman jadwal pada Web Admin")
        public void openLoginPage() {
            dashboardPage.menuHome();
            dashboardPage.menuManagement();
            dashboardPage.menuJadwal();
        }

        @When("saya kembali menekan tombol option edit pada data pertama")
        public void klikEditData1() {
            jadwalPage.klikEditData1();
        }

        @When("saya menekan tombol simpan pada form edit data jadwal")
        public void klikSimpan() {
        jadwalPage.klikSimpan();
    }

    // case negatif
        // 1.
        @When("saya menekan tombol option edit pada data pertama halaman jadwal di Web Admin")
        public void klikOptionData1() {
            jadwalPage.option1EditActivity();
        }

        @When("saya menekan tombol Batal pada form edit data jadwal")
        public void klikBatal() {
            jadwalPage.klikBatal();

        }

                @Then("saya melihat form edit data jadwal telah menghilang")
                public void missingFormEdit() {
            // Tunggu sampai elemen (dialog/form) menghilang
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            boolean isElementGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("/html/body/div[13]/div[3]/div/form")));

            // Verifikasi apakah elemen telah menghilang
            if (isElementGone) {
                System.out.println("Dialog box/form edit data jadwal telah menghilang");
            } else {
                System.out.println("Popup masih ada.");
            }

        }

        // 2.
        @Then("tampil validasi {string} pada form edit data jadwal")
        public void validasi1(String expectedMessage){
            if (expectedMessage.equals("Harap mengedit data hari terdahulu")) {
                String actualMessage = jadwalPage.getValidation1();
                Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
            } else {
                System.out.println("error validation");
            }
            jadwalPage.klikBatal();
            Delay(TWO);
        }

    // case positif
            @And("saya memilih Tipe jadwal Baru yaitu {string}")
            public void pilihTipeJadwalBaru(String tipeJadwal) {
                jadwalPage.pilihTipeJadwal(tipeJadwal);
            }

           @And("saya memilih Tanggal Efective Baru yaitu tanggal {string} April")
            public void selectTanggalEfectiveBaru2(String tanggal) {
                jadwalPage.pilihTanggal(tanggal);
         }


            @And("saya memasukkan nama Jadwal kerja baru yaitu {string}")
            public void inputJadwalKerjaBaru(String jadwalKerja) {
                jadwalPage.inputBaruJadwalKerja(jadwalKerja);
            }

    @When("saya menge-klik tombol hari kerja pada halaman jadwal di Web Admin")
    public void klikHariKerjaBaru() {
        jadwalPage.klikHariKerja();
    }

            @And("saya mengubah hari kerja baru pada senin {string}")
            public void selectHariSenin(String jamKerja) {
                jadwalPage.pilihHariSenin(jamKerja);
            }
            @And("saya mengubah hari kerja baru pada selasa {string}")
            public void selectHariSelasa(String jamKerja) {
                jadwalPage.pilihHariSelasa(jamKerja);
            }
            @And("saya mengubah hari kerja baru pada rabu {string}")
            public void selectHariRabu(String jamKerja) {
                jadwalPage.pilihHariRabu(jamKerja);
            }
            @And("saya mengubah hari kerja baru pada kamis {string}")
            public void selectHariKamis(String jamKerja) {
                jadwalPage.pilihHariKamis(jamKerja);
            }
            @And("saya mengubah hari kerja baru pada jumat {string}")
            public void selectHariJumat(String jamKerja) {
                jadwalPage.pilihHariJumat(jamKerja);
            }

    @When("saya menge-klik tombol terapkan pada form pilih hari kerja")
    public void klikTerapkan() {
        jadwalPage.klikTerapkan();
    }

    @When("saya mencari data jadwal yang telah diubah yaitu {string}")
    public void cariData(String data) {jadwalPage.cariData(data);}

            @Then("tampil data pencarian {string} telah ter-Update pada table jadwal")
            public void verifyEditJadwalSuksesMessage(String expectedMessage) {
                if (expectedMessage.equals("1 (BukaLapak) Update")) {
                    String actualMessage = jadwalPage.getTextTableDataElement();
                    Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
                    Delay(TWO);

                }
            }



}






