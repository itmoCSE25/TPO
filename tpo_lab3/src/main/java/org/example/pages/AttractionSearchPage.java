package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttractionSearchPage {

    public AttractionSearchPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div/div/div/div/div/div/div/div[1]/form/div[1]/input")
    private WebElement whereField;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div/div/div/div/div/div/div/div[2]/ul[1]/li[2]")
    private WebElement whereFieldButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div/div/div/div/div/div/div/div[1]/form/div[2]/div")
    private WebElement dateButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div/div/div/div/div/div/div/div[2]/div[1]/div/div[1]/table/tbody/tr[4]/td[1]/span")
    private WebElement dateFieldButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div/div/div/div/div/div/div/div[1]/form/button")
    private WebElement searchButton;

    public WebElement getWhereField() {
        return whereField;
    }

    public WebElement getWhereFieldButton() {
        return whereFieldButton;
    }

    public WebElement getDateButton() {
        return dateButton;
    }

    public WebElement getDateFieldButton() {
        return dateFieldButton;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
}
