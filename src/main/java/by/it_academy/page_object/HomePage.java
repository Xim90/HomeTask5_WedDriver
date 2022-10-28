package by.it_academy.page_object;

import by.it_academy.framework.DriverManager;
import org.openqa.selenium.By;

public class HomePage extends BasePage{
    public static final String ONLINER_URL = "https://www.onliner.by/";
    public static final String ONLINER_CATALOG_LINK_PATTERN = "//*[@class='b-top-menu']//a[contains(@href,'catalog')]";

    public HomePage() {
        DriverManager.getDriver().get(ONLINER_URL);
    }

    public CatalogPage clickOnCatalogLink(){
        waitForElementVisible(By.xpath(ONLINER_CATALOG_LINK_PATTERN)).click();
        return new CatalogPage();
    }
}
