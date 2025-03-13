package com.juaracoding.pages.dashboards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DashboardPage {

    private WebDriverWait wait;

//  Locator
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1ar04jk']")
    private WebElement welcomeHeadingElement;

    @FindBy(xpath = "//button[normalize-space()='Logout']")
    private WebElement buttonLogoutElement;

    @FindBy(xpath = "//h5[normalize-space()='Admin Hadir']")
    private WebElement buttonProfil;

    @FindBy(xpath = "//p[normalize-space()='Management']")
    private WebElement buttonManagement;

    @FindBy(xpath = "//p[normalize-space()='Shifting']")
    private WebElement buttonShifting;

    @FindBy(xpath = "//p[normalize-space()='Jadwal']")
    private WebElement buttonJadwal;

// Driver
    public DashboardPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

//  Actions
    public void clickManagementButton() {
        buttonManagement.click();
    }
    public void clickShiftingButton() {
        buttonShifting.click();
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

//  Behavior Method
    public void shiftingActivity( ) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
            clickManagementButton();
        TimeUnit.SECONDS.sleep(2);
            clickShiftingButton();
    }
    public void jadwalActivity( ) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
            clickManagementButton();
        TimeUnit.SECONDS.sleep(2);
            clickJadwalButton();
    }
    public void logOutActivity( ) throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
            clickProfilButton();
        TimeUnit.SECONDS.sleep(2);
            clickLogOutButton();
    }

//  Show Element
    public void waitForDashboardMenuHeadingElement() {
        By locator = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1ar04jk']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public String getTextDashboardMenuHeadingElement() {
            waitForDashboardMenuHeadingElement();
            return welcomeHeadingElement.getText();
        }

}
