package com.juaracoding.WebAdmin.pages.Management;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.juaracoding.drivers.DriverSingleton.driver;
import static com.juaracoding.drivers.utils.TimeDuration.TWO;

public class ShiftingPage {

    private WebDriverWait wait;

    // Driver
    public ShiftingPage(WebDriver driver) {
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

    //  Locator OUTSIDE
    @FindBy(xpath = "//button[normalize-space()='Tambahkan']")
    private WebElement addButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchElement;

    @FindBy(xpath = "//div[@id='__next']/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[4]/div/div[2]/div/div/div/div[11]/div[2]/p")
    private WebElement headingElement;

    // HEAD Table Data
    @FindBy(css = ".MuiTable-root.MuiTable-stickyHeader")
    private List<WebElement> headTableData;

    @FindBy(css = ".MuiList-root.MuiList-padding.MuiMenu-list")
    private List<WebElement> HeadOption;

    @FindBy(xpath = "//div[@id='__next']/div/div[2]/div/div/div/div/div/div[2]/div/table/tbody/tr/td")
    private WebElement tableData1;

    // Data Table Option
    @FindBy(xpath = "(//button[@type='button'])[6]")
    private WebElement optionData1;

    @FindBy(xpath = "//*[@id=\"card-actions-menu\"]/div[3]/ul/li[1]")
    private WebElement editOption1;

    @FindBy(xpath = "//div[@id='card-actions-menu']/div[3]/ul/li[2]")
    private WebElement deleteOption1;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    private WebElement optionData2;

    @FindBy(xpath = "(//div[@id='card-actions-menu']/div[3]/ul/li[2])[2]")
    private WebElement deleteOption2;


    // Page
    @FindBy(xpath = "//div[@id='__next']/div/div[2]/div/div/div/div/div/div[3]/div/div/p[2]")
    private WebElement totalPage;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div/div/div[3]/div/div/div[2]")
    private WebElement rowsPerPageButton;

    @FindBy(xpath = "//li[@role='option' and text()='5']")
    private WebElement page5;

    @FindBy(xpath = "//li[@role='option' and text()='10']")
    private WebElement page10;

    @FindBy(xpath = "//li[@role='option' and text()='25']")
    private WebElement page15;

    // Locator INSIDE
    @FindBy(xpath = "//input[@id='name']")
    private WebElement jamKerjaElement;

    @FindBy(xpath = "//input[@id='job_departement']")
    private WebElement UnitButton;

    @FindBy(xpath = "//button[normalize-space()='Ya']")
    private WebElement ButtonDeleteInside;

    @FindBy(xpath = "(//button[@type='button'])[22]")
    private WebElement buttonCancelDelete;

    @FindBy(xpath = "//input[@id='code']")
    private WebElement codeShiftingElement;

    @FindBy(xpath = "//button[normalize-space()='Tambah']")
    private WebElement tambahShiftingButton;

    @FindBy(xpath = "//button[normalize-space()='Simpan']")
    private WebElement saveEditShiftingButton;

    @FindBy(xpath = "//button[normalize-space()='Batal']")
    private WebElement batalShiftingButton;


    // JAM
    @FindBy(css = ".MuiClock-wrapper")
    private List<WebElement> headJamAndMenitButton;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Jam Masuk'])[1]/following::*[name()='svg'][1]")
    private WebElement jamMasukButton;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Jam Keluar'])[1]/following::*[name()='svg'][1]")
    private WebElement jamKeluarButton;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Break Start'])[1]/following::*[name()='svg'][1]")
    private WebElement jamBreakStartButton;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Break End'])[1]/following::*[name()='svg'][1]")
    private WebElement jamBreakEndButton;

    // Validasi
    @FindBy(xpath = "//div[@id='__next']/div/div[2]/div/div/div/div/div/div/div")
    private WebElement validasiKodeSudahDigunakan;

    @FindBy(xpath = "//p[@id='name-helper-text']")
    private WebElement validasiNamaShiftingHarusDiisi;


    // Actions
    public void fillJamKerja(String jamKerja) {
        jamKerjaElement.sendKeys(jamKerja);
    }
    public void fillCodeShifting(String shifting) {
        codeShiftingElement.sendKeys(shifting);
    }
    public void fillSearch(String nama) {
        waitSearch();
        searchElement.sendKeys(nama);
    }
//    public void removeJamKerja() {
//        Actions actions = new Actions(driver);
//        jamKerjaElement.click();
//        actions.sendKeys(Keys.CONTROL+"a").pause(Duration.ofSeconds(1)).sendKeys(Keys.BACK_SPACE).perform();
//    }
//    public void removeCodeShifting() {
//        Actions actions = new Actions(driver);
//        codeShiftingElement.click();
//        actions.moveToElement(codeShiftingElement).click().sendKeys(Keys.CONTROL+"a").pause(Duration.ofSeconds(1)).sendKeys(Keys.BACK_SPACE).perform();
//    }
    public void clickButtonTambahkan() {
        addButton.click();
    }
    public void clickButtonComboBoxUnit() {
        UnitButton.click();
    }
    public void clickButtonJamMasuk() {
        jamMasukButton.click();
    }
    public void clickButtonJamKeluar() {
        jamKeluarButton.click();
    }
    public void clickButtonBreakStart() {
        jamBreakStartButton.click();
    }
    public void clickButtonBreakEnd() {
        jamBreakEndButton.click();
    }
    public void clickButtonTambahShifting() {
        tambahShiftingButton.click();
    }
    public void clickButtonBatalShifting() {
        batalShiftingButton.click();
    }
    public void clickButtonSearch() {searchButton.click();}
    public void clickButtonReset() {resetButton.click();}
    public void clickOptionData1() {optionData1.click();}
    public void clickEdit1() {editOption1.click();}
    public void clickDelete1() {deleteOption1.click();}
    public void clickOptionData2() {optionData2.click();}
    public void clickDelete2() {deleteOption2.click();}
    public void clickButtonDelete() {ButtonDeleteInside.click(); }
    public void clickButtonCancelDelete()  {buttonCancelDelete.click(); }
    public void clickButtonSaveEdit() {saveEditShiftingButton.click(); }
    public void clickButtonRowsPerPage() {
        rowsPerPageButton.click();
    }
    public void clickpage5() { page5.click();}
    public void clickpage10() { page10.click();}
    public void clickpage15() { page15.click();}

    // logic
    public void getTime(String hour, String minute) {
        Actions actions = new Actions(driver);
            waitForShowClockElement();

        // Pertama (JAM)
        for (WebElement parent : headJamAndMenitButton) {
            List<WebElement> jamMenitElements = parent.findElements(By.cssSelector(".MuiClockNumber-root"));

            for (WebElement hourElement : jamMenitElements) {
                String setHour = hourElement.getText().trim();
                if (setHour.isEmpty()) {
                    setHour = hourElement.getAttribute("textContent").trim();
                }
                if (setHour.contains(hour)) {
//                    System.out.println("Clicking on Hour: " + setHour);
                       Delay(TWO);
                            actions.moveToElement(hourElement).click().perform();
                                break; // Keluar dari loop setelah klik jam
                }
            }
        }

        // Kedua (MENIT) "StaleElementReferenceException"
        for (WebElement parent : headJamAndMenitButton) {
            List<WebElement> jamMenitElements = parent.findElements(By.cssSelector(".MuiClockNumber-root"));

            for (WebElement minuteElement : jamMenitElements) {
                String setMinute = minuteElement.getText().trim();
                if (setMinute.isEmpty()) {
                    setMinute = minuteElement.getAttribute("textContent").trim();
                }

                if (setMinute.contains(minute)) {
//                    System.out.println("Clicking on Minute: " + setMinute);

                    // Tunggu hingga elemen menit bisa diklik
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement clickableMinute = wait.until(ExpectedConditions.elementToBeClickable(minuteElement));
                        actions.moveToElement(clickableMinute).click().perform();
                    return;
                }
            }
        }
    }
    public void selectUnit(String expectedUnit)         {
        Actions actions = new Actions(driver);
            Delay(TWO);
                clickButtonComboBoxUnit();

        // Looping untuk mencari unit yang sesuai berdasarkan aria-activedescendant
        for (int i = 0; i < 20; i++) { // Loop maksimal 20 kali agar tidak infinite loop
            WebElement activeElement = driver.findElement(By.xpath("//input[@id='job_departement']"));
            String activeDescendant = activeElement.getAttribute("aria-activedescendant");

            // Jika elemen tidak ditemukan, lanjutkan scrolling ke bawah
            if (activeDescendant == null || activeDescendant.isEmpty()) {
                actions.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(500)).perform();
                continue;
            }

            // Ambil teks dari elemen yang aktif saat ini di dropdown
            WebElement activeOption = driver.findElement(By.id(activeDescendant));
            String activeText = activeOption.getText().trim();

//            System.out.println("Current option: " + activeText);

            // Jika teks sesuai dengan yang dicari, tekan Enter dan keluar dari loop
            if (activeText.equals(expectedUnit)) {
                actions.sendKeys(Keys.ENTER).perform();
//                System.out.println("Selected: " + activeText);
                return;
            }

            // Jika belum ditemukan, tekan Arrow Down lagi
            actions.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(500)).perform();
        }

        System.out.println("Unit not found: " + expectedUnit);
    }
//    public String getAllText(String keyData)            {
//        waitForShowHeadTableDataElement();
//        String actualData = ""; // Inisialisasi nilai default
//
//        for (WebElement parent : headTableData) {
//            List<WebElement> allData = parent.findElements(By.cssSelector(".MuiTypography-root"));
//
//            for (WebElement data : allData) {
//                String setData = data.getText().trim();
//
//                if (setData.isEmpty()) {
//                    setData = data.getAttribute("textContent").trim();
//                }
//
//                if (setData.contains(keyData)) {
//                    actualData = setData; // Simpan nilai yang ditemukan
//                    System.out.println("Cetak data actual = " + actualData);
//                    return actualData; // Langsung kembalikan jika ditemukan
//                }
//            }
//        }
//        return actualData; // Kembalikan nilai default jika tidak ditemukan
//    }
    public void getOption(String keyOption)             {
        Actions actions = new Actions(driver);
//        String optionChoice = ""; // Inisialisasi nilai default

        for (WebElement parent : HeadOption) {
            List<WebElement> allOption = parent.findElements(By.cssSelector(".MuiButtonBase-root.MuiMenuItem-root.MuiMenuItem-gutters.MuiMenuItem-root.MuiMenuItem-gutters"));
            for (WebElement option : allOption) {
                String setData = option.getText().trim();
                if (setData.isEmpty()) {
                    setData = option.getAttribute("textContent").trim();
                }

                if (setData.contains(keyOption)) {
                    actions.moveToElement(option).click().perform();
                    return;
                }
            }
        }
    }
    public void setTime (String hour, String minute) {
        getTime(hour, minute);
    }

// # Behavior methods (Selenium)

// Case Pagination (Rows Per Pages)
    public void klikPage5 () {
        clickButtonRowsPerPage();
        Delay(TWO);
    }

// Case Tambahkan
    public void klikTambahkan () {
        clickButtonTambahkan();
            Delay(TWO);
    }
    public void setJamMasuk (String jam, String menit)      {
        clickButtonJamMasuk();
        Delay(TWO);
        setTime(jam, menit);
        Delay(TWO);
    }
    public void setJamKeluar (String jam, String menit)     {
        clickButtonJamKeluar();
        Delay(TWO);
        setTime(jam, menit);
        Delay(TWO);
    }
    public void setBreakStart (String jam, String menit)    {
        clickButtonBreakStart();
        Delay(TWO);
        setTime(jam, menit);
        Delay(TWO);
    }
    public void setBreakEnd (String jam, String menit)      {
        clickButtonBreakEnd();
        Delay(TWO);
        setTime(jam, menit);
        Delay(TWO);
    }
    public void inputNamaJamKerja (String jamKerja) {
        fillJamKerja(jamKerja);
    }
    public void inputCodeShifting (String shifting)     {
        fillCodeShifting(shifting);
    }
    public void pilihUnit(String unit)                    {
        selectUnit(unit);
    }
    public void klikTambah (){
        clickButtonTambahShifting();
            Delay(TWO);
            Delay(TWO);
            waitDisplay();
    }
    public void klikBatal ()  {
        clickButtonBatalShifting();
            Delay(TWO);
        waitDisplay();
    }

// case edit
    public void klikSimpan(){
        clickButtonSaveEdit();
            Delay(TWO);
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

// Case Pencarian & Reset
    public void klikSearch(){
        clickButtonSearch();
            Delay(TWO);
    }
    public void inputDataPencarian (String nama){
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

    public void option1EditActivity () {
        Actions actions = new Actions(driver);
    waitDisplay();
    Delay(TWO);
        clickOptionData1();
    Delay(TWO);
        clickEdit1();
    Delay(TWO);
        actions.moveToElement(jamKerjaElement).click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
        Delay(TWO);
    }
    public void klikEditData1 () {
        Actions actions = new Actions(driver);
        clickEdit1();
        Delay(TWO);
        actions.moveToElement(jamKerjaElement).click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
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
    public void klikEditData2 () {
        clickDelete2();
        Delay(TWO);
    }

    // Show Elements
    public void waitForShowClockElement () {
        By locator = By.cssSelector(".MuiClock-wrapper");
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
    public void waitDisplay(){
        By locator = By.xpath("//*[@id=\"__next\"]/div");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitSearch() {
        By locator = By.xpath("//input[@id='search']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitValidationNamaShiftingHarusDiisi(){
        By locator = By.xpath("//p[@id='name-helper-text']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitValidationKodeShiftingSudahDigunakan(){
        By locator = By.xpath("//div[@id='__next']/div/div[2]/div/div/div/div/div/div/div");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Validation
    public String getValidation1 (){
        waitValidationNamaShiftingHarusDiisi();
        String validasi = validasiNamaShiftingHarusDiisi.getText();
        return validasi;
    }
    public String getValidation2 (){
        waitValidationKodeShiftingSudahDigunakan();
        String validasi = validasiKodeSudahDigunakan.getText();
        return validasi;
    }
    public String getFieldSearch() {
        Delay(TWO);
        String Value = searchElement.getAttribute("value");
        return Value;
    }
    public String getHeadingElement (){
        waitHeadingElement();
        Delay(TWO);
        String teks = headingElement.getText();
        return teks;
    }
    public String getPage(){
        waitForShowPage();
        Delay(TWO);
        String page = totalPage.getText();
        return page;
    }
    public String getTextTableDataElement() {
        waitForShowTableDataElement();
        Delay(TWO);
        String data = tableData1.getText();
        return data;
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
