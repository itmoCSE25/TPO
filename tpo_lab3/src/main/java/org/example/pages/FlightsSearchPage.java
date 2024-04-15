package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsSearchPage {

    public FlightsSearchPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/main/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/button[1]")
    private WebElement fromButton;

    @FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/div/div[1]/div/div/div/div/input")
    private WebElement fromField;

    @FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/div/ul/li/span[3]/div/input")
    private WebElement allFromMark;

    @FindBy(xpath = "//*[@id=\"basiclayout\"]/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/button[3]")
    private WebElement whereButton;

    @FindBy(xpath = "//*[@id=\":Rj6qgld5:\"]/div/div/div/div/div/div/div[1]/div/div/div/div/input")
    private WebElement sityInput;

    @FindBy(xpath = "//*[@id=\"basiclayout\"]/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div/button")
    private WebElement foundButton;

    @FindBy(xpath = "/html/body/div[5]/div/div/div/div/div/div/ul/li[1]/span[3]/div/input")
    private WebElement allAirports;

    public WebElement getWhereButton() {
        return whereButton;
    }

    public WebElement getSityInput() {
        return sityInput;
    }

    public WebElement getFoundButton() {
        return foundButton;
    }

    public WebElement getAllAirports() {
        return allAirports;
    }

    public WebElement getFromButton() {
        return fromButton;
    }

    public WebElement getFromField() {
        return fromField;
    }

    public WebElement getAllFromMark() {
        return allFromMark;
    }
}
