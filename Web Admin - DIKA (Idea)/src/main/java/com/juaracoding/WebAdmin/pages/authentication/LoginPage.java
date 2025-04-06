package com.juaracoding.WebAdmin.pages.authentication;

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
import java.util.concurrent.TimeUnit;

import static com.juaracoding.drivers.DriverSingleton.driver;

public class LoginPage {

    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);                  // Inisialisasi Elemen Web yang Diidentifikasi
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //  Mengatur waktu tunggu
    }
    public void Delay()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // locator
    @FindBy(id = "email")
    WebElement emailElement;

    @FindBy(id = "password")
    WebElement passwordElement;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSignInElement;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-a97271']")
    WebElement loginElement;

    // Acc Not Found & Acc / Pass Invalid
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1qamc72']")
    WebElement errornote;


//  Action
    public void fillEmail(String email) {
        emailElement.sendKeys(email);
    }
    public void fillPassword(String password) {
        passwordElement.sendKeys(password);
    }
    public void clickLoginButton() {
        buttonSignInElement.click();
    }

//  Behavior Method (Selenium)
    public void loginActivity(String email, String password) {
            fillEmail(email);
        Delay();
            fillPassword(password);
        Delay();
            clickLoginButton();
        Delay();
    }
    public void inputEmail(String email) { fillEmail(email); Delay();  }
    public void inputPassword(String password) { fillPassword(password); Delay(); }
    public void clickButtonLogin() {  clickLoginButton(); Delay();}

//  Show element
    public void waitForErrorNoteElement() {
        By locator = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1qamc72']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Tunggu elemen terlihat di browser
    }

    public String getTextErrorNoteElement() {
        waitForErrorNoteElement();
            Delay();
                String errorMessage = errornote.getText();
                    return errorMessage;
    }
        public String getTextLoginPageElement() {
            Delay();
                String errorMessage = loginElement.getText();
                    return errorMessage;
    }



}









