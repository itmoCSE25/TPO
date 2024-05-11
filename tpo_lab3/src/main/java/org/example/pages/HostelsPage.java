package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HostelsPage {

    public HostelsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@data-testid='review-score']//div[contains(text(),',')]")
    private List<WebElement> reviewsScore;

    @FindBy(xpath = "//*[@data-testid='filters-group-label-content']")
    private WebElement scoreMoreThan9Filter;

    @FindBy(xpath = "//*[@data-testid='filters-sidebar']//*[contains(text(), 'Ресторан')]")
    private WebElement restourantFilter;

    @FindBy(xpath = "//*[@data-testid='filters-sidebar']//*[contains(text(), 'Бесплатный Wi-Fi')]")
    private WebElement wifiFilter;

    @FindBy(xpath = "//*[@data-testid=\"title-link\"]")
    private List<WebElement> titles;



    public List<WebElement> getReviewsScore() {
        return reviewsScore;
    }

    public WebElement getScoreMoreThan9Filter() {
        return scoreMoreThan9Filter;
    }

    public WebElement getRestourantFilter() {
        return restourantFilter;
    }

    public List<WebElement> getTitles() {
        return titles;
    }

    public WebElement getWifiFilter() {
        return wifiFilter;
    }
}
