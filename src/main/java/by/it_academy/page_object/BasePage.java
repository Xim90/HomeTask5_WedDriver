package by.it_academy.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static by.it_academy.framework.DriverManager.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {
    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        return wait.until(visibilityOfElementLocated(by));
    }

    public List<WebElement> waitForElementsVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
}
