package org.example.usecase;

import org.example.Utils;
import org.example.pages.HostelCardPage;
import org.example.pages.HostelsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

import static org.example.Utils.wait10Sec;

public class HostelsPageTest {

    @AfterEach
    void tearDown() {
        Utils.getDrivers().forEach(WebDriver::quit);
    }

    @Test
    void ratingTest() {
        Utils.getDrivers().forEach(webDriver -> {
            //https://www.booking.com/searchresults.ru.html?ss=Dubai
            webDriver.get("https://www.booking.com/searchresults.ru.html?label=gen173nr-1FCAQoggJCDHNlYXJjaF9kdWJhaUghWARowgGIAQGYASG4AQfIAQzYAQHoAQH4AQOIAgGoAgO4ArTts7EGwAIB0gIkZTAyYTlhNjktYmI5Ny00ZjU1LTljMDItZjEzZTlkYjc3Mjgz2AIF4AIB&sid=48592d963c61a82cbed545c8e0feeb14&aid=304142&ss=Dubai%2C+Dubai+Emirate%2C+United+Arab+Emirates&ssne=%D0%A1%D1%82%D0%B0%D0%BC%D0%B1%D1%83%D0%BB&ssne_untouched=%D0%A1%D1%82%D0%B0%D0%BC%D0%B1%D1%83%D0%BB&efdco=1&lang=ru&src=index&dest_id=-782831&dest_type=city&ac_position=0&ac_click_type=b&ac_langcode=en&ac_suggestion_list_length=5&search_selected=true&search_pageview_id=f1ac7e57087000c7&ac_meta=GhA2NWU1ODAyODdkZGEwMTBhIAAoATICZW46BUR1YmFpQABKAFAA&group_adults=2&no_rooms=1&group_children=0");
            wait10Sec(webDriver);
            HostelsPage hostelsPage = new HostelsPage(webDriver);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hostelsPage.getScoreMoreThan9Filter().click();
            hostelsPage = new HostelsPage(webDriver);
            hostelsPage.getReviewsScore()
                    .stream()
                    .map(WebElement::getText)
                    .map(str -> {
                        if (str.length() > 4) {
                            return str.replace(",", ".").split(" ")[1];
                        }
                        return str.replace(",", ".");
                    })
                    .map(Double::valueOf)
                    .forEach(val -> Assertions.assertTrue(val >= 9.0));
        });
    }

    @Test
    void wifiTest() throws RuntimeException {
        Utils.getDrivers().forEach(webDriver -> {
            webDriver.get("https://www.booking.com/searchresults.ru.html?label=gen173nr-1FCAQoggJCDHNlYXJjaF9kdWJhaUghWARowgGIAQGYASG4AQfIAQzYAQHoAQH4AQOIAgGoAgO4ArTts7EGwAIB0gIkZTAyYTlhNjktYmI5Ny00ZjU1LTljMDItZjEzZTlkYjc3Mjgz2AIF4AIB&sid=48592d963c61a82cbed545c8e0feeb14&aid=304142&ss=Dubai%2C+Dubai+Emirate%2C+United+Arab+Emirates&ssne=%D0%A1%D1%82%D0%B0%D0%BC%D0%B1%D1%83%D0%BB&ssne_untouched=%D0%A1%D1%82%D0%B0%D0%BC%D0%B1%D1%83%D0%BB&efdco=1&lang=ru&src=index&dest_id=-782831&dest_type=city&ac_position=0&ac_click_type=b&ac_langcode=en&ac_suggestion_list_length=5&search_selected=true&search_pageview_id=f1ac7e57087000c7&ac_meta=GhA2NWU1ODAyODdkZGEwMTBhIAAoATICZW46BUR1YmFpQABKAFAA&group_adults=2&no_rooms=1&group_children=0");
            wait10Sec(webDriver);
            WebDriverWait driverWait = new WebDriverWait(webDriver, Duration.of(5, ChronoUnit.SECONDS));
            HostelsPage hostelsPage = new HostelsPage(webDriver);
            WebElement acceptCookie = webDriver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']"));
            driverWait.until(s -> acceptCookie.isDisplayed());
            acceptCookie.click();
            try {
                WebElement noisyDialogWindow = webDriver.findElement(By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']"));
                driverWait.until(s -> noisyDialogWindow.isDisplayed());
                noisyDialogWindow.click();
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
            hostelsPage.getWifiFilter().click();
            hostelsPage = new HostelsPage(webDriver);
            String originalWindow = webDriver.getWindowHandle();
            hostelsPage.getTitles().stream().limit(10).forEach(title -> {
                title.click();
                goToNextWindow(webDriver, driverWait, originalWindow);
                wait10Sec(webDriver);
                HostelCardPage hostelCardPage = new HostelCardPage(webDriver);
                Pattern pattern = Pattern.compile(".*Wi-Fi.*");
                Assertions.assertTrue(
                        hostelCardPage.getPopularIcons().stream()
                                .map(WebElement::getText)
                                .anyMatch(s -> pattern.matcher(s).find())
                );
                webDriver.close();
                webDriver.switchTo().window(originalWindow);
            });
        });
    }

    @Test
    void restourantTest() {
        Utils.getDrivers().forEach(webDriver -> {
            webDriver.get("https://www.booking.com/searchresults.ru.html?label=gen173nr-1FCAQoggJCDHNlYXJjaF9kdWJhaUghWARowgGIAQGYASG4AQfIAQzYAQHoAQH4AQOIAgGoAgO4ArTts7EGwAIB0gIkZTAyYTlhNjktYmI5Ny00ZjU1LTljMDItZjEzZTlkYjc3Mjgz2AIF4AIB&sid=48592d963c61a82cbed545c8e0feeb14&aid=304142&ss=Dubai%2C+Dubai+Emirate%2C+United+Arab+Emirates&ssne=%D0%A1%D1%82%D0%B0%D0%BC%D0%B1%D1%83%D0%BB&ssne_untouched=%D0%A1%D1%82%D0%B0%D0%BC%D0%B1%D1%83%D0%BB&efdco=1&lang=ru&src=index&dest_id=-782831&dest_type=city&ac_position=0&ac_click_type=b&ac_langcode=en&ac_suggestion_list_length=5&search_selected=true&search_pageview_id=f1ac7e57087000c7&ac_meta=GhA2NWU1ODAyODdkZGEwMTBhIAAoATICZW46BUR1YmFpQABKAFAA&group_adults=2&no_rooms=1&group_children=0");
            wait10Sec(webDriver);
            WebDriverWait driverWait = new WebDriverWait(webDriver, Duration.of(5, ChronoUnit.SECONDS));
            HostelsPage hostelsPage = new HostelsPage(webDriver);
            WebElement acceptCookie = webDriver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']"));
            driverWait.until(s -> acceptCookie.isDisplayed());
            acceptCookie.click();
            try {
                WebElement noisyDialogWindow = webDriver.findElement(By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']"));
                driverWait.until(s -> noisyDialogWindow.isDisplayed());
                noisyDialogWindow.click();
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
            hostelsPage.getRestourantFilter().click();
            hostelsPage = new HostelsPage(webDriver);
            String originalWindow = webDriver.getWindowHandle();
            hostelsPage.getTitles().stream().limit(10).forEach(title -> {
                title.click();
                goToNextWindow(webDriver, driverWait, originalWindow);
                wait10Sec(webDriver);
                HostelCardPage hostelCardPage = new HostelCardPage(webDriver);
                Pattern pattern = Pattern.compile(".*[Рр]естор.*");
                hostelCardPage.getPopularIcons().stream()
                        .map(WebElement::getText)
                        .forEach(System.out::println);
                System.out.println();
                Assertions.assertTrue(
                        hostelCardPage.getPopularIcons().stream()
                                .map(WebElement::getText)
                                .anyMatch(s -> pattern.matcher(s).find())
                        || hostelCardPage.getPopularIcons().size() == 20
                );
                webDriver.close();
                webDriver.switchTo().window(originalWindow);
            });
        });
    }

    private void goToNextWindow(WebDriver driver, WebDriverWait wait, String originalWindow) {
        wait.until(s -> driver.getWindowHandles().size() != 1);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
