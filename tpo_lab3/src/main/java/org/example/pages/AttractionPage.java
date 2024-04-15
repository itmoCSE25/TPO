package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttractionPage {

    public AttractionPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/nav/ol/li[3]/span/div")
    private WebElement attractionName;

    public WebElement getAttractionName() {
        return attractionName;
    }
}
