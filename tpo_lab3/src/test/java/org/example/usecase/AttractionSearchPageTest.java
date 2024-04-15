package org.example.usecase;

import org.example.Utils;
import org.example.pages.AttractionPage;
import org.example.pages.AttractionsPage;
import org.example.pages.AttractionSearchPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.example.Utils.wait10Sec;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AttractionSearchPageTest {

    @Test
    void test() {
        Utils.getDrivers().forEach(webDriver -> {
            webDriver.get(Utils.DEFAULT_URL + "/attractions");
            wait10Sec(webDriver);
            AttractionSearchPage attractionSearchPage = new AttractionSearchPage(webDriver);
            attractionSearchPage.getWhereField().sendKeys("Paris");
            wait10Sec(webDriver);
            attractionSearchPage.getWhereFieldButton().click();
            attractionSearchPage.getDateButton().click();
            attractionSearchPage.getSearchButton().click();
            wait10Sec(webDriver);
            AttractionsPage attractionsPage = new AttractionsPage(webDriver);
            assertEquals("Attractions", attractionsPage.getAttractionTextField().getText());
            attractionsPage.getAttractionButton().click();
            wait10Sec(webDriver);
            AttractionPage attractionPage = new AttractionPage(webDriver);
            assertNotNull(attractionPage.getAttractionName());
            webDriver.quit();
        });
    }
}
