package com.juaracoding.WebUser.pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.juaracoding.drivers.utils.TimeDuration.TWO;

public class LoginPage {
    private WebDriverWait wait;

// locator
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    // Akun tidak ditemukan / Email atau password salah
    @FindBy(xpath = "//div[@id='__next']/div/div/div/div[2]/div/div/div/div[2]/p")
    WebElement errorNote;

//  Driver
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);                  // Inisialisasi Elemen Web yang Diidentifikasi
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //  Mengatur waktu tunggu
    }
    private void Delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Delay interrupted: " + e.getMessage());
        }
    }

//  Action
    public void fillEmail(String email) {
        emailField.sendKeys(email);
    }
    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        submitButton.click();
    }

//  Behavior Method Selenium
    public void inputEmail(String email) { Delay(TWO); fillEmail(email);  }
    public void inputPassword(String password) { Delay(TWO); fillPassword(password);  }
    public void clickButtonLogin() {  Delay(TWO); clickLoginButton();  Delay(TWO);}

//  Show element
    public void waitForErrorNoteElement() {
        By locator = By.xpath("//div[@id='__next']/div/div/div/div[2]/div/div/div/div[2]/p");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

//    Validation
        public String getTextErrorNoteElement() {
        waitForErrorNoteElement();
            Delay(TWO);
                String errorMessage = errorNote.getText();
                    return errorMessage;
    }
        public String getFieldEmailElement() {
            Delay(TWO);
               String emailValue =  emailField.getAttribute("value");
                    return emailValue;
        }
}









