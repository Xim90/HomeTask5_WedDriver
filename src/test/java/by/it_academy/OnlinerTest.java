package by.it_academy;

import by.it_academy.framework.DriverManager;
import by.it_academy.page_object.CatalogPage;
import by.it_academy.page_object.HomePage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OnlinerTest {
    public static final String SPACES_PATTERN = "[\s]+";
    public static final int EXPECTED_NUMBER_ACCESSORIES_DROPDOWN_LIST_ITEMS = 14;
    public static final String EXPECTED_ACCESSORIES_DROPDOWN_LIST_ITEMS_DESCRIPTION_GOODS_CONTENT = "товар";
    public static final String EXPECTED_ACCESSORIES_DROPDOWN_LIST_ITEMS_DESCRIPTION_MIN_PRICE_CONTENT = "р.";
    public static final String EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_1 = "Onlíner Prime";
    public static final String EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_2 = "Электроника";
    public static final String EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_3 = "Компьютеры и сети";
    public static final String EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_4 = "Бытовая техника";
    public static final String EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_5 = "Стройка и ремонт";
    public static final String EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_6 = "Дом и сад";
    public static final String EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_7 = "Авто и мото";
    public static final String EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_8 = "Красота и спорт";
    public static final String EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_9 = "Детям и мамам";
    public static final String EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_10 = "Работа и офис";
    public static final String EXPECTED_COMPUTER_AND_NETWORKS_ASIDE_LIST_ITEM_NAME_1 = "Ноутбуки, компьютеры, мониторы";
    public static final String EXPECTED_COMPUTER_AND_NETWORKS_ASIDE_LIST_ITEM_NAME_2 = "Комплектующие";
    public static final String EXPECTED_COMPUTER_AND_NETWORKS_ASIDE_LIST_ITEM_NAME_3 = "Хранение данных";
    public static final String EXPECTED_COMPUTER_AND_NETWORKS_ASIDE_LIST_ITEM_NAME_4 = "Сетевое оборудование";
    private static HomePage homePage;

    private List<String> getExpectedCatalogClassifierItems() {
        List<String> expectedCatalogClassifierItems = new ArrayList<>();
        expectedCatalogClassifierItems.add(EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_1);
        expectedCatalogClassifierItems.add(EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_2);
        expectedCatalogClassifierItems.add(EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_3);
        expectedCatalogClassifierItems.add(EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_4);
        expectedCatalogClassifierItems.add(EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_5);
        expectedCatalogClassifierItems.add(EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_6);
        expectedCatalogClassifierItems.add(EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_7);
        expectedCatalogClassifierItems.add(EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_8);
        expectedCatalogClassifierItems.add(EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_9);
        expectedCatalogClassifierItems.add(EXPECTED_CATALOG_CLASSIFIER_ITEM_NAME_10);
        return expectedCatalogClassifierItems;
    }

    private List<String> getExpectedComputerAndNetworksCategoryList() {
        List<String> expected = new ArrayList<>();
        expected.add(EXPECTED_COMPUTER_AND_NETWORKS_ASIDE_LIST_ITEM_NAME_1);
        expected.add(EXPECTED_COMPUTER_AND_NETWORKS_ASIDE_LIST_ITEM_NAME_2);
        expected.add(EXPECTED_COMPUTER_AND_NETWORKS_ASIDE_LIST_ITEM_NAME_3);
        expected.add(EXPECTED_COMPUTER_AND_NETWORKS_ASIDE_LIST_ITEM_NAME_4);
        return expected;
    }

    @BeforeAll
    public static void setup() {
        DriverManager.setDriver();
        homePage = new HomePage();
    }

    @Test
    public void checkCatalogClassifierItemsName() {
        List<WebElement> catalogElements = homePage
                .clickOnCatalogLink()
                .getCatalogClassifierItems();
        Assertions.assertThatList(catalogElements)
                .map(WebElement::getText)
                .containsExactlyElementsOf(getExpectedCatalogClassifierItems());
    }

    @Test
    public void checkComputerAndNetworkAsideListItemsName() {
        CatalogPage catalogPage = new CatalogPage();
        Assertions.assertThatList(catalogPage.getComputerAndNetworksCategoryItemsList())
                .map(WebElement::getText)
                .containsAll(getExpectedComputerAndNetworksCategoryList());
    }

    @Test
    public void checkAccessoriesDropdownListItemsContent() {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.clickOnAccessoriesCategoryItem();
        List<WebElement> dropDownListItemsTitle = catalogPage.getAccessoriesCategorySideListItemsTitle();
        List<WebElement> dropDownListItemsDescription = catalogPage.getAccessoriesCategorySideListItemsDescription();
        Assertions.assertThatList(dropDownListItemsTitle)
                .hasSize(EXPECTED_NUMBER_ACCESSORIES_DROPDOWN_LIST_ITEMS)
                .map(WebElement::getText)
                .noneMatch(String::isEmpty)
                .noneMatch(el -> el.matches(SPACES_PATTERN));
        Assertions.assertThatList(dropDownListItemsDescription)
                .hasSize(EXPECTED_NUMBER_ACCESSORIES_DROPDOWN_LIST_ITEMS)
                .map(WebElement::getText)
                .allMatch(el -> el.contains(EXPECTED_ACCESSORIES_DROPDOWN_LIST_ITEMS_DESCRIPTION_GOODS_CONTENT))
                .allMatch(el -> el.contains(EXPECTED_ACCESSORIES_DROPDOWN_LIST_ITEMS_DESCRIPTION_MIN_PRICE_CONTENT));
    }

    @AfterAll
    public static void tearsDown() {
        DriverManager.closeDriver();
    }
}
