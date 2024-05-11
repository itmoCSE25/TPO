package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHostelPage {

    public SearchHostelPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@data-testid='destination-container']//input")
    private WebElement whereField;

    @FindBy(xpath = "//*[@data-testid='searchbox-layout-wide']//button[@type='submit']")
    private WebElement findButton;

    public WebElement getWhereField() {
        return whereField;
    }

    public WebElement getFindButton() {
        return findButton;
    }
}
