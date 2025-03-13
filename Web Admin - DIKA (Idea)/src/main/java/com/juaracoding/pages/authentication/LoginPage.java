package com.juaracoding.pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriverWait wait;

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

//  Driver
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);                  // Inisialisasi Elemen Web yang Diidentifikasi
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //  Mengatur waktu tunggu
    }

//  Action
    public void fillUsername(String username) {
        emailElement.sendKeys(username);
    }
    public void fillPassword(String password) {
        passwordElement.sendKeys(password);
    }
    public void clickLoginButton() {
        buttonSignInElement.click();
    }

//  Behavior Method (Selenium_
    public void loginActivity(String username, String password) throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);   // Menunggu 2 detik
            fillUsername(username);
        TimeUnit.SECONDS.sleep(2);
            fillPassword(password);
        TimeUnit.SECONDS.sleep(2);
            clickLoginButton();
    }

//  Behavior Method (Cucumber)
    public void inputUsername(String username) throws InterruptedException { TimeUnit.SECONDS.sleep(2); fillUsername(username);  }
    public void inputPassword(String password) throws InterruptedException { TimeUnit.SECONDS.sleep(2); fillPassword(password);  }
    public void clickButtonLogin() throws InterruptedException {clickLoginButton(); TimeUnit.SECONDS.sleep(5);}

//  Show element
    public void waitForErrorNoteElement() {
        By locator = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1qamc72']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Tunggu elemen terlihat di browser
    }
    public String getTextErrorNoteElement() {
        waitForErrorNoteElement(); // Tunggu elemen sebelum mengakses teksnya
        String errorMessage = errornote.getText(); // Ambil teks dari elemen
        try {
            Thread.sleep(2000); // Berhenti selama 2 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return errorMessage; // Kembalikan teks error (login not correct)
    }
    public void waitForLoginPageElement() {
        By locator = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-a97271']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)); // Tunggu elemen terlihat di browser
    }
    public String getTextLoginPageElement() {
        waitForLoginPageElement(); // Tunggu elemen sebelum mengakses teksnya
        String errorMessage = loginElement.getText(); // Ambil teks dari elemen
        try {
            Thread.sleep(2000); // Berhenti selama 2 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return errorMessage; // Kembalikan teks error (login not correct)
    }



}
