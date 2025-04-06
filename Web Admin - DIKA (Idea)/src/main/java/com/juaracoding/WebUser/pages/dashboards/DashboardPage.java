package com.juaracoding.WebUser.pages.dashboards;

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

public class DashboardPage {

    private WebDriverWait wait;

//  Locator
    @FindBy(xpath = "//div[@id='__next']/div/div/div/div[2]/div/p")
    private WebElement headingElement;

    @FindBy(xpath = "(//button[@type='button'])[8]")
    private WebElement buttonLogout;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement buttonMenu;

// Driver
    public DashboardPage(WebDriver driver) {
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

//  Actions
    public void clickMenuButton() {
        Delay(TWO); buttonMenu.click();
    }
    public void clickLogOutButton() {
        Delay(TWO); buttonLogout.click();
    }

//  Show Element
    public void waitForDashboardMenuHeadingElement() {
        By locator = By.xpath("//div[@id='__next']/div/div/div/div[2]/div/p");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
        public String getTextDashboardMenuHeadingElement() {
            waitForDashboardMenuHeadingElement();
                Delay(TWO);
                    return headingElement.getText();
        }

}
