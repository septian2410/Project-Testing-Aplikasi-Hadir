package com.juaracoding.WebAdmin.pages.Management;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.juaracoding.drivers.DriverSingleton.driver;
import static com.juaracoding.drivers.utils.TimeDuration.TWO;

public class JadwalPage {

    private WebDriverWait wait;

    public JadwalPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    private void Delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Delay interrupted: " + e.getMessage());
        }
    }

    // Locator OUTSIDE
    @FindBy(xpath = "//button[normalize-space()='Tambahkan']")
    private WebElement tambahkanButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchElement;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement headingElement;

    // Locator INSIDE
    @FindBy(xpath = "(//button[@type='button'])[28]")
    private WebElement nextMonthElement;

    @FindBy(xpath = "//div[@id='typeJadwal']")
    private WebElement jadwalDropdown;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement hariKerjaButton;

    @FindBy(xpath = "(//button[@type='button'])[22]")
    private WebElement tanggalDropdown;

    @FindBy(xpath = "//button[@aria-label='calendar view is open, switch to year view']")
    private WebElement tahunDropdown;

    @FindBy(xpath = "//input[@id='nameJadwal']")
    private WebElement jadwalField;

    @FindBy(xpath = "//button[normalize-space()='Terapkan']")
    private WebElement buttonTerapkan;

    @FindBy(xpath = "//input[@id='t_keterlambatan']")
    private WebElement toleransiKeterlambatanField;

    @FindBy(xpath = "(//button[@type='button'])[22]")
    private WebElement tidakButton;

    @FindBy(xpath = "//button[normalize-space()='Ya']")
    private WebElement yaButton;

    @FindBy(xpath = "//button[normalize-space()='Tambah']")
    private WebElement tambahButton;

    @FindBy(xpath = "//button[normalize-space()='Batal']")
    private WebElement batalButton;

    @FindBy(xpath = "//button[normalize-space()='Simpan']")
    private WebElement simpanButton;

    // Data Table Option
    @FindBy(xpath = "//tbody/tr[1]/td[4]/div[1]/div[1]/button[1]")
    private WebElement optionData1;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[3]/ul[1]/li[2]")
    private WebElement editOption1;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[3]/ul[1]/li[3]")
    private WebElement deleteOption1;

    @FindBy(xpath = "//tbody/tr[2]/td[4]/div[1]/div[1]/button[1]")
    private WebElement optionData2;
    @FindBy(xpath = "//body/div[4]/div[3]/ul[1]/li[2]")
    private WebElement editOption2;
    @FindBy(xpath = "//body/div[4]/div[3]/ul[1]/li[3]")
    private WebElement deleteOption2;

    // Data Table Pencarian
    @FindBy(xpath = "//div[@id='__next']/div/div[2]/div/div/div/div/div/div[2]/div/table/tbody/tr/td")
    private WebElement tableData1;

    // Page
    @FindBy(xpath = "//div[@id='__next']/div/div[2]/div/div/div/div/div/div[3]/div/div/p[2]")
    private WebElement totalPage;

    // HEAD Table Data
    @FindBy(css = ".MuiTable-root.MuiTable-stickyHeader")
    private List<WebElement> headTableData;

    // element lain
    @FindBy(xpath = "/html[1]/body[1]/div[14]/div[3]/div[1]/div[1]/div[1]/div[1]/div[6]")
    private WebElement sabtuElement;

    @FindBy(xpath = "/html[1]/body[1]/div[14]/div[3]/div[1]/div[1]/div[1]/div[1]/div[7]")
    private WebElement mingguElement;

    // element validation
    @FindBy(xpath = "//div[@class='MuiSnackbarContent-message css-1w0ym84']")
    private WebElement ValidationHarapMengeditDataHariTerdahulu;


    // Actions
    public void fillJadwal(String jadwal) {
        jadwalField.sendKeys(jadwal);
    }
    public void fillSearch(String nama) {
        searchElement.sendKeys(nama);
    }
    public void fillToleransi(String waktu) {
        toleransiKeterlambatanField.sendKeys(waktu);
    }
    public void clickDropdownTipeJadwal() {jadwalDropdown.click();}
    public void clickDropdownTanggal() {tanggalDropdown.click();}
    public void clickDropdownTahun() {tahunDropdown.click();}
    public void clickTanggal(String tanggal) {
        //button[normalize-space()='14']
        Actions actions = new Actions(driver);
        String xpath = "//button[normalize-space()='"+tanggal+"']";
        WebElement element = driver.findElement(By.xpath(xpath));
        waitRendertanggal();
        actions.moveToElement(element).click().perform();
        }
    public void clickTahun(String tahun) {
        clickDropdownTahun();
        String xpath = "//button[normalize-space()='"+tahun+"']";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }
    public void clickHariKerjaButton() {
        hariKerjaButton.click();
    }

    public void clickButtonTambahkan() {
        tambahkanButton.click();
    }
    public void clickButtonTambah() {
        tambahButton.click();
    }
    public void clickButtonBatal() {
        batalButton.click();
    }
    public void clickButtonSearch() {searchButton.click();}
    public void clickButtonReset() {resetButton.click();}
    public void clickButtonDelete() {yaButton.click(); }
    public void clickButtonCancelDelete()  {tidakButton.click(); }
    public void clickButtonSaveEdit() {simpanButton.click(); }


    public void clickOptionData1() {optionData1.click();}
    public void clickEdit1() {editOption1.click();}
    public void clickDelete1() {deleteOption1.click();}
    public void clickOptionData2() { waitOptionData2(); optionData2.click();}
    public void clickDelete2() {deleteOption2.click();}

    public void clickHariSenin  (String jamKerja) {
        String xpath = "/html[1]/body[1]/div[14]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
            Delay(TWO);
        String xpath2 = "//li[normalize-space()='"+jamKerja+"']";
        WebElement element2 = driver.findElement(By.xpath(xpath2));
        element2.click();
            Delay(TWO);
    }
    public void clickHariSelasa (String jamKerja) {
        String xpath = "/html[1]/body[1]/div[14]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
            Delay(TWO);
        String xpath2 = "//li[normalize-space()='"+jamKerja+"']";
        WebElement element2 = driver.findElement(By.xpath(xpath2));
        element2.click();
            Delay(TWO);
    }
    public void clickHariRabu   (String jamKerja) {
        String xpath = "/html[1]/body[1]/div[14]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
            Delay(TWO);
        String xpath2 = "//li[normalize-space()='"+jamKerja+"']";
        WebElement element2 = driver.findElement(By.xpath(xpath2));
        element2.click();
            Delay(TWO);
    }
    public void clickHariKamis  (String jamKerja) {
        String xpath = "/html[1]/body[1]/div[14]/div[3]/div[1]/div[1]/div[1]/div[1]/div[4]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
            Delay(TWO);
        String xpath2 = "//li[normalize-space()='"+jamKerja+"']";
        WebElement element2 = driver.findElement(By.xpath(xpath2));
        element2.click();
            Delay(TWO);
    }
    public void clickHariJumat  (String jamKerja) {
        String xpath = "/html[1]/body[1]/div[14]/div[3]/div[1]/div[1]/div[1]/div[1]/div[5]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
            Delay(TWO);
        String xpath2 = "//li[normalize-space()='"+jamKerja+"']";
        WebElement element2 = driver.findElement(By.xpath(xpath2));
        element2.click();
            Delay(TWO);
    }
    public void clickHariSabtu  (String jamKerja) {
        String xpath = "/html[1]/body[1]/div[14]/div[3]/div[1]/div[1]/div[1]/div[1]/div[6]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
            Delay(TWO);
        String xpath2 = "//li[normalize-space()='"+jamKerja+"']";
        WebElement element2 = driver.findElement(By.xpath(xpath2));
        element2.click();
            Delay(TWO);
    }
    public void clickHariMinggu (String jamKerja) {
        String xpath = "/html[1]/body[1]/div[14]/div[3]/div[1]/div[1]/div[1]/div[1]/div[7]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
            Delay(TWO);
        String xpath2 = "//li[normalize-space()='"+jamKerja+"']";
        WebElement element2 = driver.findElement(By.xpath(xpath2));
        element2.click();
            Delay(TWO);
    }
    public void clickButtonTerapkan() {buttonTerapkan.click();
    }
    public void clickNextMonth() {nextMonthElement.click();}

//    public void selectJadwal(String expectedJadwal)     {
//        Actions actions = new Actions(driver);
//            clickButtonJadwal();
//                Delay(TWO);
//
//        // Looping aria-activedescendant
//        for (int i = 0; i < 3; i++) {
//            WebElement activeElement = driver.findElement(By.xpath("//input[@id='typeJadwal']"));
//            String dataValue = activeElement.getAttribute("data-value");
//
//            // Jika elemen tidak ditemukan, lanjutkan scrolling ke bawah
//            if (dataValue == null || dataValue.isEmpty()) {
//                actions.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(500)).perform();
//                continue;
//            }
//
//            // Ambil teks dari elemen yang aktif saat ini di dropdown
//            WebElement activeOption = driver.findElement(By.id(dataValue));
//            String activeText = activeOption.getText().trim();
//
//            System.out.println("Current option: " + activeText);
//
//            // Jika teks sesuai dengan yang dicari, tekan Enter dan keluar dari loop
//            if (activeText.equals(expectedJadwal)) {
//                actions.sendKeys(Keys.ENTER).perform();
//                System.out.println("Selected: " + activeText);
//                return;
//            }
//
//            // Jika belum ditemukan, tekan Arrow Down lagi
//            actions.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(500)).perform();
//        }
//
//        System.out.println("Unit not found: " + expectedJadwal);
//    }
    public String getAllText(String keyData)            {
        waitForShowHeadTableDataElement();
            Delay(TWO);
                String actualData = ""; // Inisialisasi nilai default

        for (WebElement parent : headTableData) {
            List<WebElement> allData = parent.findElements(By.cssSelector(".MuiTypography-root"));

            for (WebElement data : allData) {
                String setData = data.getText().trim();

                if (setData.isEmpty()) {
                    setData = data.getAttribute("textContent").trim();
                }

                if (setData.contains(keyData)) {
                    actualData = setData; // Simpan nilai yang ditemukan
                    System.out.println("Cetak data actual = " + actualData);
                        Delay(TWO);
                            return actualData; // Langsung kembalikan jika ditemukan
                }
            }
        }
        return actualData; // Kembalikan nilai default jika tidak ditemukan
    }

    // Tambahkan
    public void klikTambahkan () {
        waitTambahkan();
        clickButtonTambahkan();
            Delay(TWO);
    }
    public void inputJadwalKerja (String jadwal) {
        fillJadwal(jadwal); Delay(TWO);
    }
    public void inputBaruJadwalKerja (String jadwal) {
        Actions actions = new Actions(driver);
        actions.moveToElement(jadwalField).click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
        fillJadwal(jadwal); Delay(TWO);
    }
    public void inputToleransiKeterlambatan (String waktu)  {
        fillToleransi(waktu); Delay(TWO);
    }
    public void pilihTipeJadwal             (String jadwal)  {
        clickDropdownTipeJadwal();
            Delay(TWO);
                String xpath = "//li[contains(@class, 'MuiMenuItem-root') and contains(@class, 'css-1fh5cnl') and normalize-space(text())='" + jadwal + "']";
                WebElement element = driver.findElement(By.xpath(xpath));
                element.click();
            Delay(TWO);

            }
    public void pilihTanggalEfective        (String tahun,String tanggal)  {
        clickDropdownTanggal();
        clickNextMonth();
            Delay(TWO);
        clickTahun(tahun);
            Delay(TWO);
        clickTanggal(tanggal);
            Delay(TWO);
    }
    public void pilihTanggal        (String tanggal)  {
        clickDropdownTanggal();
        clickNextMonth();
            Delay(TWO);
        clickTanggal(tanggal);
            Delay(TWO);
    }


    public void klikHariKerja () {
        clickHariKerjaButton();
            Delay(TWO);
    }
    public void pilihHariSenin  (String jamKerja){
        clickHariSenin(jamKerja);
    }
    public void pilihHariSelasa (String jamKerja){
        clickHariSelasa(jamKerja);
    }
    public void pilihHariRabu   (String jamKerja){
        clickHariRabu(jamKerja);
    }
    public void pilihHariKamis  (String jamKerja){
        clickHariKamis(jamKerja);
    }
    public void pilihHariJumat  (String jamKerja){
        clickHariJumat(jamKerja);
    }
    public void pilihHariSabtu  (String jamKerja){
        Actions actions = new Actions(driver);
        actions.scrollToElement(sabtuElement).perform();
            Delay(TWO);
            clickHariSabtu(jamKerja);
    }
    public void pilihHariMinggu (String jamKerja){
        Actions actions = new Actions(driver);
        actions.scrollToElement(mingguElement).perform();
            Delay(TWO);
                clickHariMinggu(jamKerja);

    }
    public void klikTerapkan() {
        clickButtonTerapkan();
            Delay(TWO);
    }
    public void klikBatal ()  {
        clickButtonBatal();
        Delay(TWO);
    }
    public void klikTambah () {
        clickButtonTambah();
            Delay(TWO);
        waitDisplay();
    }

    // case Delete
    public void klikYa(){
        clickButtonDelete();
        Delay(TWO);
        waitDisplay();
    }
    public void klikTidak(){
        clickButtonCancelDelete();
        Delay(TWO);
        waitDisplay();
    }

    // case edit
    public void klikSimpan(){
        waitSimpan();
        clickButtonSaveEdit();
        Delay(TWO);
        waitDisplay();
        Delay(TWO);
    }

    public void option1EditActivity () {
        Actions actions = new Actions(driver);
        waitOptionData1();
        waitDisplay();
        Delay(TWO);
        clickOptionData1();
        Delay(TWO);
        clickEdit1();
        Delay(TWO);
        actions.moveToElement(jadwalField).click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
        Delay(TWO);
    }
    public void klikEditData1(){
        clickEdit1();
        Delay(TWO);
    }

    public void option1DeleteActivity () {
        waitDisplay();
        Delay(TWO);
        clickOptionData1();
        Delay(TWO);
        clickDelete1();
        Delay(TWO);
    }
    public void option2DeleteActivity () {
        waitDisplay();
        Delay(TWO);
        clickOptionData2();
        Delay(TWO);
        clickDelete2();
        Delay(TWO);
    }
    public void klikDeleteData2(){
        clickDelete2();
        Delay(TWO);
    }

    // Pencarian & Reset
    public void klikSearch(){
        waitDisplay();
        waitSubmit();
        clickButtonSearch();
        Delay(TWO);
        waitDisplay();
    }
    public void inputDataPencarian (String nama){
        waitDisplay();
        waitSearch();
        fillSearch(nama);
        Delay(TWO);
    }
    public void cariData (String nama){
        inputDataPencarian(nama);
        klikSearch();
    }
    public void resetPencarian () {
        clickButtonReset();
        Delay(TWO);
    }

    // Show Elements
    public void waitDisplay(){
        By locator = By.xpath("//*[@id=\"__next\"]/div");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitSearch() {
        By locator = By.xpath("//input[@id='search']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitSubmit() {
        By locator = By.xpath("//button[@type='submit']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitSimpan() {
        By locator = By.xpath("//button[normalize-space()='Simpan']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitOptionData2() {
        By locator = By.xpath("//tbody/tr[2]/td[4]/div[1]/div[1]/button[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitOptionData1() {
        By locator = By.xpath("//tbody/tr[1]/td[4]/div[1]/div[1]/button[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitTambahkan() {
        By locator = By.xpath("//button[normalize-space()='Tambahkan']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForShowHeadTableDataElement () {
        By locator = By.cssSelector(".MuiTable-root.MuiTable-stickyHeader");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitForShowTableDataElement () {
        By locator = By.xpath("//div[@id='__next']/div/div[2]/div/div/div/div/div/div[2]/div/table/tbody/tr/td");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitHeadingElement (){
        By locator = By.xpath("//div[@id='__next']/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[4]/div/div[2]/div/div/div/div[11]/div[2]/p");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitForShowPage() {
        By locator = By.xpath("//div[@id='__next']/div/div[2]/div/div/div/div/div/div[3]/div/div/p[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitRendertanggal(){
        By locator = By.xpath("/html/body/div[14]/div[2]/div/div/div");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitValidationHarapMengeditDataHariTerdahulu(){
        By locator = By.xpath("//div[@class='MuiSnackbarContent-message css-1w0ym84']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

// Validation
    public String getTextTableDataElement() {
        waitForShowTableDataElement();
        Delay(TWO);
        String data = tableData1.getText();
        return data;
    }
    public String getHeadingElement (){
        waitHeadingElement();
        Delay(TWO);
        String teks = headingElement.getText();
        return teks;
    }
    public String getValidation1 (){
        waitValidationHarapMengeditDataHariTerdahulu();
        String validasi = ValidationHarapMengeditDataHariTerdahulu.getText();
        return validasi;
    }
    public String getPage(){
        waitForShowPage();
        Delay(TWO);
        String page = totalPage.getText();
        return page;
    }
    public String getFieldSearch() {
        Delay(TWO);
        String Value = searchElement.getAttribute("value");
        return Value;
    }


}



    /*

    * Mencari nilai value dalam List *
     public void getListUnit(String keyUnit) throws InterruptedException {
        Actions actions = new Actions(driver);
            waitForShowContainerAddShiftingElement();
                TimeUnit.SECONDS.sleep(2);
            waitForShowListUnitElement();

        By locator = By.cssSelector(".MuiButtonBase-root.MuiIconButton-root.MuiIconButton-sizeMedium.MuiAutocomplete-popupIndicator");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> options = driver.findElements(By.id("job_departement"));
        List<String> values = new ArrayList<>();

        for (WebElement option : options) {
            String text = (String) js.executeScript("return arguments[0].textContent.trim();", option);
            if (!text.isEmpty()) {
                values.add(text);
            }
        }
        System.out.println("List Value: " + values);
*/

//        actions.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).perform();
//         TimeUnit.SECONDS.sleep(2);
