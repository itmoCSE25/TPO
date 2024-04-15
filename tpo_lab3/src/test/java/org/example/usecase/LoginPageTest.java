package org.example.usecase;

import org.example.Utils;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.example.Utils.wait10Sec;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest {

    @BeforeEach
    void init() {
        Utils.prepareDrivers();
    }

    @Test
    void loginTest() {
        WebDriver webDriver = Utils.getChromeDriver();
        webDriver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        wait10Sec(webDriver);
        webDriver.get("https://account.booking.com");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.getEmailField().sendKeys("test-itmo@niuitmo.ru");
        loginPage.getContinueButton().click();
        loginPage.getPasswordField().sendKeys("Y4f-EjS-ipY-kPx");
        loginPage.getSignInButton().click();
        WebDriverWait driverWait = new WebDriverWait(webDriver, Duration.of(10, ChronoUnit.SECONDS));
        WebElement some = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b2indexPage\"]/div[3]/div/div/header/nav[1]/div[2]/div/span/button/span/div/div[2]/div[1]")));
        assertEquals("Your account", some.getText());
        webDriver.quit();
    }

    @Test
    void logoutTest() {
        WebDriver webDriver = Utils.getChromeDriver();
        webDriver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        wait10Sec(webDriver);
        webDriver.get("https://account.booking.com");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.getEmailField().sendKeys("test-itmo@niuitmo.ru");
        loginPage.getContinueButton().click();
        loginPage.getPasswordField().sendKeys("Y4f-EjS-ipY-kPx");
        loginPage.getSignInButton().click();
        wait10Sec(webDriver);
        WebDriverWait driverWait = new WebDriverWait(webDriver, Duration.of(10, ChronoUnit.SECONDS));
        WebElement profileButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/header/nav[1]/div[2]/div/span/button")));
        profileButton.click();
        WebElement logoutButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[18]/div/div/div/div/ul/li[7]/button")));
        logoutButton.click();
        WebElement fin = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/nav[1]/div[2]/div/a/span")));
        assertEquals("Sign in", fin.getText());
    }
}
