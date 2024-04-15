package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttractionsPage {

    public AttractionsPage(WebDriver webElement) {
        PageFactory.initElements(webElement, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div/div[1]/div/nav/ol/li[2]/span/div")
    private WebElement attractionTextField;

    @FindBy(xpath = "//*[@id=\"attr-search-results-page-main-content\"]/div[1]/div/div/div/div[1]")
    private WebElement attractionButton;

    public WebElement getAttractionTextField() {
        return attractionTextField;
    }

    public WebElement getAttractionButton() {
        return attractionButton;
    }
}
