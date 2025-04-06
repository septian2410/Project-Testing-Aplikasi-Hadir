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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.juaracoding.drivers.utils.TimeDuration.TWO;

public class JadwalTambahDefinitions {

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
    @Given("kelima kalinya saya membuka halaman jadwal pada Web Admin")
    public void openLoginPage() {
        dashboardPage.menuHome();
        dashboardPage.menuManagement();
        dashboardPage.menuJadwal();
    }

    @When("saya menge-klik tombol Tambahkan pada halaman jadwal di Web Admin")
    public void klikTambahkan() {
        jadwalPage.klikTambahkan();
    }

    // case negatif 1

            @And("saya menge-klik tombol Batal pada form tambah data jadwal")
            public void klikBatal() {
                jadwalPage.klikBatal();
            }

    @Then("saya melihat form tambah data jadwal telah menghilang")
    public void missingFormEdit() {
        // Tunggu sampai elemen (dialog/form) menghilang
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isElementGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("/html/body/div[13]/div[3]/div/form")));

        // Verifikasi apakah elemen telah menghilang
        if (isElementGone) {
            System.out.println("Dialog box/form tambah jadwal telah menghilang");
        } else {
            System.out.println("Popup masih ada.");
        }
    }

    // case negatif 2

    @When("saya menge-klik tombol Tambah pada form tambah data jadwal")
    public void klikTambah() {jadwalPage.klikTambah();}

            @Then("terlihat validasi Please fill out this field pada kolom tipe jadwal")
            public void verifyValidationMessage() {
                String expectedMessage = "Silahkan pilih jadwal";
                // Menggunakan JavascriptExecutor untuk mengambil teks validasi dari elemen dengan ID 'typeJadwal-helper-text'
                JavascriptExecutor js = (JavascriptExecutor) driver;
                String actualMessage = (String) js.executeScript(
                        "var errorElement = document.querySelector('#typeJadwal-helper-text');" +
                                "return errorElement ? errorElement.innerText : 'No validation message found';"
                );
//                        "var errorElement = document.querySelector('#typeJadwal');" +

                System.out.println("Validation Message: " + actualMessage);
                // Bandingkan pesan aktual dengan expected message
                Assert.assertEquals(actualMessage, expectedMessage, "Validation message tidak sesuai!");
                    Delay(TWO);
                    jadwalPage.klikBatal();
            }


    // case positif 1

            @And("saya memilih Tipe jadwal yaitu {string}")
            public void selectTipeJadwal(String tipeJadwal) {
                jadwalPage.pilihTipeJadwal(tipeJadwal);
            }

            @And("saya memilih Tanggal Efective Baru yaitu tanggal {string} April 2025")
            public void selectTanggalEfectiveBaru2(String tanggal) {
                jadwalPage.pilihTanggal(tanggal);
            }


            @And("saya memasukkan nama Jadwal kerja yaitu {string}")
            public void inputJadwalKerja(String jadwalKerja) {
                jadwalPage.inputJadwalKerja(jadwalKerja);
            }

    @When("saya menekan tombol hari kerja pada halaman jadwal di Web Admin")
    public void klikHariKerja() {
        jadwalPage.klikHariKerja();
    }
                @And("saya memilih hari kerja pada senin {string}")
                public void selectHariSenin(String hariKerja) {
                    jadwalPage.pilihHariSenin(hariKerja);
                }
                @And("saya memilih hari kerja pada selasa {string}")
                public void selectHariSelasa(String hariKerja) {
                    jadwalPage.pilihHariSelasa(hariKerja);
                }
                @And("saya memilih hari kerja pada rabu {string}")
                public void selectHariRabu(String hariKerja) {
                    jadwalPage.pilihHariRabu(hariKerja);
                }
                @And("saya memilih hari kerja pada kamis {string}")
                public void selectHariKamis(String hariKerja) {
                    jadwalPage.pilihHariKamis(hariKerja);
                }
                @And("saya memilih hari kerja pada jumat {string}")
                public void selectHariJumat(String hariKerja) {
                    jadwalPage.pilihHariJumat(hariKerja);
                }

    @When("saya menekan tombol terapkan pada form Jumlah Hari Kerja")
    public void klikTerapkan() {jadwalPage.klikTerapkan();}

                @And("saya memasukkan waktu toleransi keterlambatan yaitu {string} menit")
                public void inputToleransi(String menit) {
                    jadwalPage.inputToleransiKeterlambatan(menit);
                }

    @When("saya mencari data jadwal yang telah ditambah yaitu {string}")
    public void cariData(String data) {jadwalPage.cariData(data);}

            @Then("tampil data pencarian {string} telah terlihat pada table jadwal")
            public void verifyTambahMessage(String expectedMessage) {
                if (expectedMessage.equals("1 (True Money BSNI)")) {
                    String actualMessage = jadwalPage.getTextTableDataElement();
                    Assert.assertEquals(actualMessage, expectedMessage, "Pesan error tidak sesuai!");
                    Delay(TWO);
                }
            }


}