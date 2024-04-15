package org.example.usecase;

import org.example.Utils;
import org.example.pages.FlightsSearchPage;
import org.example.pages.SearchCarPage;
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

public class AviaSearchTest {

    @Test
    void aviaSearchTest() {
        Utils.getDrivers().forEach(webDriver -> {
            webDriver.get(Utils.DEFAULT_URL + "/flights");
            wait10Sec(webDriver);
            FlightsSearchPage flightSearchPage = new FlightsSearchPage(webDriver);
            flightSearchPage.getFromButton().click();
            wait10Sec(webDriver);
            flightSearchPage.getFromField().sendKeys("Pulkovo");
            flightSearchPage.getAllFromMark().click();
            flightSearchPage.getWhereButton().click();
            flightSearchPage.getSityInput().sendKeys("Moscow");
            wait10Sec(webDriver);
            flightSearchPage.getAllAirports().click();
            flightSearchPage.getFoundButton().click();
            WebDriverWait driverWait = new WebDriverWait(webDriver, Duration.of(10, ChronoUnit.SECONDS));
            WebElement some = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/main/div/div/div[2]/div/div/div/div[3]/button/span")));
            assertEquals("Include nearby airports", some.getText());
            webDriver.quit();
        });
    }
}
