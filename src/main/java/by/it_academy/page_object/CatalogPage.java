package by.it_academy.page_object;

import by.it_academy.framework.DriverManager;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class CatalogPage extends BasePage {
    public static final String CATALOG_ONLINER_URL = "https://catalog.onliner.by/";
    public static final String CATALOG_CLASSIFIER_ITEM_LINK_PATTERN = "//li[.//span[contains(text(),'%s')]]";
    public static final String CATALOG_CLASSIFIER_ITEMS_LINK =
            "//li[.//span[contains(@class,'icon_id')]]//span[contains(@class,'wrapper')]";
    public static final String CATALOG_COMPUTER_AND_NETWORK_LIST_ASIDE_ITEMS =
            "//div[@data-id=2]//div[contains(@class,'aside-title')]";
    public static final String CATALOG_COMPUTER_AND_NETWORK_LIST_ASIDE_ITEM_LINK_PATTERN =
            "//div[@data-id=2]//div[contains(text(),'%s')]";
    public static final String CATALOG_ACCESSORIES_DROPDOWN_LIST_ITEMS_TITLE =
            "//div[contains(@style,'block')]//div[./div[contains(text(),'Комплектующие')]]" +
                    "//span[contains(@class,'title')]";
    public static final String CATALOG_ACCESSORIES_DROPDOWN_LIST_ITEMS_DESCRIPTION =
            "//div[contains(@style,'block')]//div[./div[contains(text(),'Комплектующие')]]" +
                    "//span[contains(@class,'description')]";
    public static final String COMPUTER_AND_NETWORK_CATEGORY_NAME = "Компьютеры";
    public static final String ACCESSORIES_CATEGORY_NAME = "Комплектующие";

    public CatalogPage() {
        DriverManager.getDriver().get(CATALOG_ONLINER_URL);
    }

    public void clickOnCatalogCategory(String categoryName) {
        waitForElementVisible(xpath(format(CATALOG_CLASSIFIER_ITEM_LINK_PATTERN, categoryName))).click();
    }

    public List<WebElement> getCatalogClassifierItems() {
        return waitForElementsVisible(xpath(CATALOG_CLASSIFIER_ITEMS_LINK));
    }

    public List<WebElement> getComputerAndNetworksCategoryItemsList() {
        clickOnCatalogCategory(COMPUTER_AND_NETWORK_CATEGORY_NAME);
        return waitForElementsVisible(xpath(CATALOG_COMPUTER_AND_NETWORK_LIST_ASIDE_ITEMS
        ));
    }

    public void clickOnComputerAndNetworksCategoryItem(String categoryName) {
        clickOnCatalogCategory(COMPUTER_AND_NETWORK_CATEGORY_NAME);
        waitForElementVisible(xpath(format(CATALOG_COMPUTER_AND_NETWORK_LIST_ASIDE_ITEM_LINK_PATTERN, categoryName)))
                .click();
    }
    public void clickOnAccessoriesCategoryItem(){
        clickOnComputerAndNetworksCategoryItem(ACCESSORIES_CATEGORY_NAME);
    }

    public List<WebElement> getAccessoriesCategorySideListItemsTitle() {
        return waitForElementsVisible(xpath(CATALOG_ACCESSORIES_DROPDOWN_LIST_ITEMS_TITLE));
    }

    public List<WebElement> getAccessoriesCategorySideListItemsDescription() {
        return waitForElementsVisible(xpath(CATALOG_ACCESSORIES_DROPDOWN_LIST_ITEMS_DESCRIPTION));
    }

}
