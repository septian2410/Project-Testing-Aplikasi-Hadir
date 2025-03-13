package com.juaracoding.pages.Management;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.juaracoding.drivers.DriverSingleton.driver;

public class ShiftingPage {

    private WebDriverWait wait;

    //  Locator OUTSIDE
    @FindBy(xpath = "//button[normalize-space()='Tambahkan']")
    private WebElement addButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchElement;

    // HEAD Table Data
    @FindBy(css = ".MuiTable-root MuiTable-stickyHeader css-o1eexh")
    private List<WebElement> headTableData;

    @FindBy(css = ".MuiTypography-root MuiTypography-h6 css-1gtt4lb")
    private WebElement TableData;


    // Locator INSIDE
    @FindBy(xpath = "//input[@id='name']")
    private WebElement jamKerjaElement;

    @FindBy(xpath = "//input[@id='job_departement']")
    private WebElement isiUnitElement;

    // HEAD pilih unit
    @FindBy(css = ".MuiAutocomplete-endAdornment")
    private List<WebElement> headPilihUnitElement;

    @FindBy(css = "#job_departement.MuiInputBase-input")
    private List<WebElement> headPilihUnitElement2;

    @FindBy(css = ".MuiDialogContent-root")
    private List<WebElement> headAllElement;

    @FindBy(xpath = "//button[@title='Open']//*[name()='svg']")
    private WebElement pilihUnitElement;

    @FindBy(xpath = " //input[@id='job_departement' and @aria-activedescendant='job_departement-option-0']")
    private WebElement unit0Element;

    @FindBy(css = ".MuiButtonBase-root.MuiIconButton-root.MuiIconButton-sizeMedium.MuiAutocomplete-popupIndicator")
    private WebElement unitElement;

    // HEAD button jam
    @FindBy(css = ".MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-q9cuy5")
    private WebElement headSemuaJamButton;

    @FindBy(xpath = "//div[@id='alert-dialog-slide-description']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//button[1]//*[name()='svg']")
    private WebElement jamMasukButton;

    @FindBy(xpath = "//div[@role='presentation']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//button[1]//*[name()='svg']")
    private WebElement jamKeluarButton;

    @FindBy(xpath = "//body/div[@role='presentation']/div[@role='presentation']/div[@role='dialog']/form/div[@class='MuiDialogContent-root css-1ty026z']/div[@id='alert-dialog-slide-description']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-5 css-xgs5wp']/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]//*[name()='svg']")
    private WebElement jamBreakStartButton;

    @FindBy(xpath = "//body/div[@role='presentation']/div[@role='presentation']/div[@role='dialog']/form/div[@class='MuiDialogContent-root css-1ty026z']/div[@id='alert-dialog-slide-description']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-5 css-xgs5wp']/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]//*[name()='svg']")
    private WebElement jamBreakEndButton;

    // HEAD pilih jam / menit
    @FindBy(css = ".MuiClock-wrapper")
    private List<WebElement> headJamAndMenitListElement;

    @FindBy(css = ".MuiClockNumber-root")
    private WebElement jamAndMenitElement;

    // element lain
    @FindBy(xpath = "//input[@id='code']")
    private WebElement codeShiftingElement;

    @FindBy(xpath = "//button[normalize-space()='Tambah']")
    private WebElement tambahShiftingButton;

    @FindBy(xpath = "//button[normalize-space()='Batal']")
    private WebElement batalShiftingButton;


    // Driver
    public ShiftingPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void clickButtonTambahkan() {
        addButton.click();
    }
    public void fillJamKerja(String jamKerja) {
        jamKerjaElement.sendKeys(jamKerja);
    }
    public void fillUnit(String unit) {
        isiUnitElement.sendKeys(unit);
    }
    public void fillCodeShifting(String shifting) {
        codeShiftingElement.sendKeys(shifting);
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

    public void clickButtonComboBoxUnit(String unit) throws InterruptedException {
        Actions actions = new Actions(driver);
//
//        actions.moveToElement(unitElement).click().pause(Duration.ofSeconds(1)).perform();
//            TimeUnit.SECONDS.sleep(2);
//            waitForElementUnit34();
//        actions.moveToElement(unit34Element).click().pause(Duration.ofSeconds(1)).perform();
//            TimeUnit.SECONDS.sleep(2);

        fillUnit(unit);
        // Simulate move and click on the first unit element
//        actions.moveToElement(unitElement).click().pause(Duration.ofSeconds(1)).perform();
//        TimeUnit.SECONDS.sleep(2);
////        actions.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).perform();
//        waitForElementUnit1();
//        TimeUnit.SECONDS.sleep(2);
//
//// Scroll ke unit34Element sebelum melakukan moveToElement
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//// Scroll ke unit34Element
//        js.executeScript("arguments[0].scrollIntoView(true);", unit0Element); // Scroll hingga elemen ditemukan
//        TimeUnit.SECONDS.sleep(1); // Tunggu sejenak setelah scroll
//
//// Klik unit34Element setelah di-scroll
//        actions.moveToElement(unit0Element).click().pause(Duration.ofSeconds(1)).perform();
//        TimeUnit.SECONDS.sleep(2);

    }

    public void getTime(String hour, String minute) throws InterruptedException {
        Actions actions = new Actions(driver);

        waitForShowClockElement();
        TimeUnit.SECONDS.sleep(2);

        // Pertama (JAM)
        for (WebElement parent : headJamAndMenitListElement) {
            List<WebElement> jamMenitElements = parent.findElements(By.cssSelector(".MuiClockNumber-root"));

            for (WebElement hourElement : jamMenitElements) {
                String setHour = hourElement.getText().trim();
                if (setHour.isEmpty()) {
                    setHour = hourElement.getAttribute("textContent").trim();
                }
                if (setHour.contains(hour)) {
                    System.out.println("Clicking on Hour: " + setHour);

                    // Klik elemen jam
                    actions.moveToElement(hourElement).click().perform();
                    TimeUnit.SECONDS.sleep(1);
                    break; // Keluar dari loop setelah klik jam
                }
            }
        }

        // Kedua (MENIT) "StaleElementReferenceException"
        for (WebElement parent : headJamAndMenitListElement) {
            List<WebElement> jamMenitElements = parent.findElements(By.cssSelector(".MuiClockNumber-root"));

            for (WebElement minuteElement : jamMenitElements) {
                String setMinute = minuteElement.getText().trim();
                if (setMinute.isEmpty()) {
                    setMinute = minuteElement.getAttribute("textContent").trim();
                }

                if (setMinute.contains(minute)) {
                    System.out.println("Clicking on Minute: " + setMinute);

                    // Tunggu hingga elemen menit bisa diklik
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement clickableMinute = wait.until(ExpectedConditions.elementToBeClickable(minuteElement));
                    actions.moveToElement(clickableMinute).click().perform();
                    return;
                }
            }
        }
    }

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

//                if (setUnit.isEmpty()) {
//                        setUnit = unit.getAttribute("textContent").trim();
//                    }
//                    if (setUnit.contains(keyUnit)) {
//                        System.out.println("Clicking Unit: " + unit);
//
//                        // Klik elemen jam
//                        actions.moveToElement(unit).click().perform();
//                        TimeUnit.SECONDS.sleep(1);
//                        break;
//                }
//            }

    }

//    public void selectUnit(String expectedUnit) throws InterruptedException {
//        Actions actions = new Actions(driver);
//        WebElement inputElement = driver.findElement(By.id("job_departement"));
//
//        // Pastikan dropdown muncul sebelum mulai memilih
//        inputElement.click();
//        TimeUnit.SECONDS.sleep(1); // Tunggu sejenak agar dropdown muncul
//
//        // Looping untuk mencari unit yang sesuai berdasarkan aria-activedescendant
//        for (int i = 0; i < 20; i++) { // Loop maksimal 20 kali agar tidak infinite loop
//            WebElement activeElement = driver.findElement(By.xpath("//input[@id='job_departement']"));
//            String activeDescendant = activeElement.getAttribute("aria-activedescendant");
//
//            // Jika elemen tidak ditemukan, lanjutkan scrolling ke bawah
//            if (activeDescendant == null || activeDescendant.isEmpty()) {
//                actions.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(500)).perform();
//                continue;
//            }
//
//            // Ambil teks dari elemen yang aktif saat ini di dropdown
//            WebElement activeOption = driver.findElement(By.id(activeDescendant));
//            String activeText = activeOption.getText().trim();
//
//            System.out.println("Current option: " + activeText);
//
//            // Jika teks sesuai dengan yang dicari, tekan Enter dan keluar dari loop
//            if (activeText.(expectedUnit)) {
//                actions.sendKeys(Keys.ENTER).perform();
//                System.out.println("Selected: " + activeText);
//                return;
//            }
//
//            // Jika belum ditemukan, tekan Arrow Down lagi
//            actions.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(500)).perform();
//        }
//    }


//         TimeUnit.SECONDS.sleep(2);

        // Behavior methods
        public void setTime (String hour, String minute) throws InterruptedException {
            getTime(hour, minute);
            TimeUnit.SECONDS.sleep(2);
        }
        public void addActivity () throws InterruptedException {
            TimeUnit.SECONDS.sleep(2);
            clickButtonTambahkan();
        }
        public void addShiftingActivity () throws InterruptedException {
            TimeUnit.SECONDS.sleep(2);
            clickButtonTambahShifting();
        }
        public void cancelShiftingActivity () throws InterruptedException {
            TimeUnit.SECONDS.sleep(2);
            clickButtonBatalShifting();
        }

        public void jamMasukActivity () throws InterruptedException {
            TimeUnit.SECONDS.sleep(2);
            clickButtonJamMasuk();
            TimeUnit.SECONDS.sleep(2);
        }
        public void jamKeluarActivity () throws InterruptedException {
            TimeUnit.SECONDS.sleep(2);
            clickButtonJamKeluar();
            TimeUnit.SECONDS.sleep(2);
        }
        public void jamBreakStartActivity () throws InterruptedException {
            TimeUnit.SECONDS.sleep(2);
            clickButtonBreakStart();
            TimeUnit.SECONDS.sleep(2);
        }
        public void JamBreakEndActivity () throws InterruptedException {
            TimeUnit.SECONDS.sleep(2);
            clickButtonBreakEnd();
            TimeUnit.SECONDS.sleep(2);
        }

        public void inputNamaJamKerja (String jamKerja) throws InterruptedException {
            TimeUnit.SECONDS.sleep(2);
            fillJamKerja(jamKerja);
        }
        public void inputUnit (String unit) throws InterruptedException {
//            TimeUnit.SECONDS.sleep(2);
//                fillUnit(unit);

            TimeUnit.SECONDS.sleep(2);
                clickButtonComboBoxUnit("BCA");

            TimeUnit.SECONDS.sleep(4);
            getListUnit(unit);

//        actions.moveToElement(fillUnit(unit)).click().perform();
        }
        public void inputCodeShifting (String shifting) throws InterruptedException {
            TimeUnit.SECONDS.sleep(2);
            fillCodeShifting(shifting);
        }


        // Show Elements
        public void waitForShowClockElement () {
            By locator = By.cssSelector(".MuiClock-wrapper");
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        public void waitForShowListUnitElement () {
            By locator = By.cssSelector("#job_departement.MuiInputBase-input");
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        public void waitForShowContainerAddShiftingElement () {
            By locator = By.cssSelector(".MuiDialogContent-root");
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        public void waitForElementUnit1(){
            By locator = By.xpath("//input[@id='job_departement' and @aria-activedescendant='job_departement-option-0']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }


    }

