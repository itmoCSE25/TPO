package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HostelCardPage {

    public HostelCardPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    ///html/body/div[3]/div/div[4]/div[1]/div[1]/div[3]/div/div/div[1]/div[2]/div[2]/div/div/ul/li[4]/div/div/div/span/div/span
    @FindBy(xpath = "//*[@data-testid='property-most-popular-facilities-wrapper']//li//div//div//div//span//div//span")
    List<WebElement> popularIcons;

    public List<WebElement> getPopularIcons() {
        return popularIcons;
    }
}