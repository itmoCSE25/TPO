package org.example.usecase;

import org.example.Utils;
import org.example.pages.SearchHostelPage;
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

public class SearchHostelTest {

    @BeforeEach
    void init() {}

    @Test
    void searchTest() {
        WebDriver webDriver = Utils.getChromeDriver();
        webDriver.get(Utils.DEFAULT_URL);
        wait10Sec(webDriver);
        SearchHostelPage searchHostelPage = new SearchHostelPage(webDriver);
        searchHostelPage.getWhereField().sendKeys("Moscow");
        searchHostelPage.getFindButton().click();
        wait10Sec(webDriver);
        WebDriverWait driverWait = new WebDriverWait(webDriver, Duration.of(10, ChronoUnit.SECONDS));
        WebElement some = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[2]/div/div[2]/div[1]/nav/ol/li[4]/span/div")));
        assertEquals("Search results", some.getText());
        webDriver.quit();
    }
}
