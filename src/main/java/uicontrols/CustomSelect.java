package uicontrols;

import BaseControlls.BaseControl;
import Core.TAEDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomSelect extends BaseControl {

    private static By base_locator = By.xpath("//span[@class='select2-search select2-search--dropdown']");
    private static String INPUT_XPATH = "./input[@type='search']";
    private static String SEARCH_RESULT = "./ancestor::span[1]//span[@class='select2-results']";
    private static String ITEM_LOCATOR = ".//li[contains(text(), '%s')]";

    public CustomSelect(String name, TAEDriver driver, By locator) {
        super(name, driver, locator);
    }

    public CustomSelect(String name, TAEDriver driver, String xpath) {
        super(name, driver, xpath);
    }

    public void selectItem(String itemName) {
        getLogger().info(String.format("Trying to select dropdown item '%s' of '%s' dropdown", itemName, super.name));
        searchItem(itemName, DEFAULT_TIMEOUT);
        clickElement(itemName);
        getLogger().info(String.format("Dropdown item '%s' has been selected in '%s' dropdown ", itemName, super.name));
    }

    public String getSelectedItem() {
        getLogger().trace("Get selected item text in '%s' dropdown");
        return driver.getElement(new ByChained(super.locator, By.xpath("./span[@role='textbox']"))).getText();
    }

    public void searchItem(String itemName, int timeOut) {
        getLogger().info(String.format("Expand dropdown '%s'", super.name));
        click(timeOut);
        getLogger().info(String.format("Dropdown '%s' expanded", super.name));
        getLogger().info(String.format("Locate filter input of '%s' dropdown", super.name));
        WebElement input = driver.getElement(new ByChained(base_locator, By.xpath(INPUT_XPATH)));
        getLogger().info(String.format("Filter '%s' dropdown with item '%s'", super.name, itemName));
        input.sendKeys(itemName);
        getLogger().info(String.format("Wait results will be displayed for '%s' dropdown with item '%s'", super.name, itemName));
        new WebDriverWait(driver.getDriver(), timeOut, DEFAULT_SLEEP).until(ExpectedConditions.attributeContains(
                new ByChained(base_locator, By.xpath(SEARCH_RESULT), By.xpath("./ul/li[1]")), "class", "select2-results__option select2-results__"));
    }

    public void clickElement(String itemName) {
        getLogger().info(String.format("Select item '%s' from the result list of '%s' dropdown", itemName, super.name));
        driver.getElement(new ByChained(base_locator, By.xpath(SEARCH_RESULT), By.xpath(String.format(ITEM_LOCATOR, itemName)))).click();
    }

}
