package com.juaracoding.WebAdmin.pages.dashboards;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.BrowserType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.juaracoding.drivers.DriverSingleton.driver;

public class DashboardPage {

    private WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    public void Delay()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//p[normalize-space()='© 2022 Aplikasi Hadir']")
    private WebElement welcomeHeadingElement;

    @FindBy(xpath = "//button[normalize-space()='Logout']")
    private WebElement buttonLogoutElement;

    @FindBy(xpath = "//h5[normalize-space()='Admin Hadir']")
    private WebElement buttonProfil;

    @FindBy(xpath = "//p[normalize-space()='Management']")
    private WebElement buttonManagement;

    @FindBy(xpath = "//p[normalize-space()='Shifting']")
    private WebElement buttonShifting;

    @FindBy(xpath = "//div[@class='MuiBox-root css-1qd452l']")
    private WebElement buttonHome;

    @FindBy(xpath = "//div[@id='__next']/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/p")
    private WebElement buttonPending;

    @FindBy(xpath = "//p[normalize-space()='Jadwal']")
    private WebElement buttonJadwal;

//  Actions
    public void clickManagementButton() {
        buttonManagement.click();
    }
    public void clickShiftingButton() {
        buttonShifting.click();
    }
    public void clickHomeButton() {
        buttonHome.click();
    }
    public void clickJadwalButton() {
        buttonJadwal.click();
    }
    public void clickLogOutButton() {
        buttonLogoutElement.click();
    }
    public void clickProfilButton() {
        buttonProfil.click();
    }
    public void clickPending() {
        buttonPending.click();
    }

//  Behavior Method (Selenium)
    public void menuManagement() {
        Actions actions = new Actions(driver);
        waitDisplay();
        waitManagement();
        actions.moveToElement(welcomeHeadingElement).pause(2).perform();
        clickManagementButton();
                Delay();

    }
    public void menuShifting( ) {
        waitDisplay();
        clickShiftingButton();
            Delay();
                waitDisplay();
    }
    public void menuHome( ) {
        Actions actions = new Actions(driver);
        waitDisplay();
        waitHome();
        actions.moveToElement(buttonHome).pause(2).perform();
        clickHomeButton();
            Delay();
                waitDisplay();
    }
    public void menuJadwal( ) {
        waitJadwal();
        Delay();
        clickJadwalButton();
        Delay();
            waitDisplay();
    }
    public void menuPending () {
        waitDisplay();
        waitPending();
        clickPending();
            Delay();
    }
    public void logOutActivity( ) {
    Delay();
        clickProfilButton();
    Delay();
        clickLogOutButton();
    }

//  Show Element
    public void waitDisplay(){
        By locator = By.xpath("//*[@id=\"__next\"]/div");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitManagement(){
        By locator = By.xpath("//p[normalize-space()='Management']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitJadwal(){
        By locator = By.xpath("//p[normalize-space()='Jadwal']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitPending(){
        By locator = By.xpath("//div[@id='__next']/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/p");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForDashboardMenuHeadingElement() {
        By locator = By.xpath("//p[normalize-space()='© 2022 Aplikasi Hadir']");
//        By locator = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/p");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitHome() {
        By locator = By.xpath("//div[@class='MuiBox-root css-1qd452l']//*[name()='svg']//*[name()='path' and contains(@d,'M50 36.358')]");
//        By locator = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/p");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
        public String getTextDashboardMenuHeadingElement() {
            Actions actions = new Actions(driver);
            waitDisplay();
            waitForDashboardMenuHeadingElement();
            actions.moveToElement(welcomeHeadingElement).perform();
                return welcomeHeadingElement.getText();
        }

}
