package org.example.usecase;

import org.example.Utils;
import org.example.pages.SearchCarPage;
import org.example.pages.SearchHostelPage;
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

public class SearchCarTest {

    @Test
    void searchCarTest() {
        Utils.getDrivers().forEach(webDriver -> {
            webDriver.get(Utils.DEFAULT_URL + "/car");
            wait10Sec(webDriver);
            SearchCarPage searchCarPage = new SearchCarPage(webDriver);
            searchCarPage.getInputField().sendKeys("Dubai");
            wait10Sec(webDriver);
            searchCarPage.getFirstElemInRowButton().click();
            searchCarPage.getFindButton().click();
            WebDriverWait driverWait = new WebDriverWait(webDriver, Duration.of(30, ChronoUnit.SECONDS));
            WebElement some = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div/div/section/div/div/div/div[1]/div[1]/div")));
            assertEquals("Moscow Domodedovo Airport", some.getText());
            webDriver.quit();
        });
    }
}
