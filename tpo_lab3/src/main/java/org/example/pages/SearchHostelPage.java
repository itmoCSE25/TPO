package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHostelPage {

    public SearchHostelPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id=\":re:\"]")
    private WebElement whereField;

    @FindBy(xpath = "//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[2]/div/div/button")
    private WebElement dateButton;

    @FindBy(xpath = "//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[2]/div/div[2]/div/nav/div[1]/ul/li[2]/button")
    private WebElement flexibleButton;

    @FindBy(xpath = "//*[@id=\":r22:\"]")
    private WebElement weekendCheckbox;

    @FindBy(xpath = "//*[@id=\":r26:\"]/li[1]/label/input")
    private WebElement currentMonthCheckbox;

    @FindBy(xpath = "//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[4]/button")
    private WebElement findButton;

    public WebElement getWhereField() {
        return whereField;
    }

    public WebElement getFindButton() {
        return findButton;
    }

    public WebElement getFlexibleButton() {
        return flexibleButton;
    }

    public WebElement getWeekendCheckbox() {
        return weekendCheckbox;
    }

    public WebElement getCurrentMonthCheckbox() {
        return currentMonthCheckbox;
    }

    public WebElement getDateButton() {
        return dateButton;
    }


}
