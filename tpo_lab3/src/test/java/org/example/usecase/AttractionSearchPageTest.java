package org.example.usecase;

import org.example.Utils;
import org.example.pages.AttractionPage;
import org.example.pages.AttractionsPage;
import org.example.pages.AttractionSearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.Utils.wait10Sec;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AttractionSearchPageTest {

    @AfterEach
    void tearDown() {
        Utils.getDrivers().forEach(WebDriver::quit);
    }

    @Test
    void test() {
        Utils.getDrivers().forEach(webDriver -> {
            webDriver.get(Utils.DEFAULT_URL + "/attractions");
            wait10Sec(webDriver);
            AttractionSearchPage attractionSearchPage = new AttractionSearchPage(webDriver);
            attractionSearchPage.getWhereField().sendKeys("Paris");
            attractionSearchPage.getWhereFieldButton().click();
            attractionSearchPage.getDateButton().click();
            attractionSearchPage.getSearchButton().click();
            AttractionsPage attractionsPage = new AttractionsPage(webDriver);
            String attractionsName = attractionsPage.getAttractionTextField().getText();
            attractionsPage.getAttractionButton().click();
            AttractionPage attractionPage = new AttractionPage(webDriver);
            String attractionName = attractionPage.getAttractionName().getText();
            assertEquals("Attractions", attractionName);
            assertNotNull(attractionName);
        });
    }
}
