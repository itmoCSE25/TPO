package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Utils {
    public static final String DEFAULT_URL = "https://www.booking.com";

    public static FirefoxDriver getFireFoxDriver() {
        return new FirefoxDriver();
    }

    public static ChromeDriver getChromeDriver() {
        return new ChromeDriver();
    }

    public static List<WebDriver> getDrivers() {
        return List.of(getChromeDriver(), getFireFoxDriver());
    }

    public static void wait10Sec(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
    }
}
