package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCarPage {

    public SearchCarPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id=\"searchbox-toolbox-fts-pickup\"]")
    private WebElement inputField;

    @FindBy(xpath = "//*[@id=\"searchbox-toolbox-fts-pickup-suggestion-0\"]/div")
    private WebElement firstElemInRowButton;

    @FindBy(xpath = "//*[@id=\"b2runway_internal_actionPage\"]/div[4]/main/div[2]/div/div/div/div/div/div[2]/div/div[2]/div/div[3]/button")
    private WebElement findButton;

    public WebElement getInputField() {
        return inputField;
    }

    public WebElement getFindButton() {
        return findButton;
    }

    public WebElement getFirstElemInRowButton() {
        return firstElemInRowButton;
    }
}
