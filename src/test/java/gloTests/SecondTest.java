package gloTests;

import BaseTest.BaseAbstractChromeTest;
import TAExceptions.TAUnknownBrowserException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import uicontrols.CustomSelect;

public class SecondTest extends BaseAbstractChromeTest {
    public SecondTest() throws TAUnknownBrowserException {
    }

    @Test(groups = {"citytests"})
    public void twoCitiesTest() {
        getDriver().getDriver().get("https://www.phptravels.net/");
        changeLanguage();
        CustomSelect customSelect = new CustomSelect("HotelCity", getDriver(), "(//*[@role='combobox'])[1]");
        customSelect.selectItem("Berlin");
        Assert.assertTrue(customSelect.getSelectedItem().contains("Berlin"), "Verify selected item is Berlin");
        customSelect.selectItem("London");
        Assert.assertTrue(customSelect.getSelectedItem().contains("London"), "Verify selected item is London");
    }

    private void changeLanguage() {
        getDriver().getElement(By.id("languages")).click();
        getDriver().getElement(By.xpath("//ul/li/a[text()=' English']")).click();
    }
}
