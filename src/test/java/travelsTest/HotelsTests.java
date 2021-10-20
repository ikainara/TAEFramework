package travelsTest;

import BaseTest.BaseAbstractTest;
import Entities.HotelsSearch;
import Entities.Travellers;
import TAExceptions.TAUnknownBrowserException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelsPage;
import uicontrols.CustomSelect;

import static org.testng.AssertJUnit.assertEquals;

public class HotelsTests extends BaseAbstractTest {
    protected HotelsPage hotelsPage;

    public HotelsTests() throws TAUnknownBrowserException {
        super("chrome");
    }

    @BeforeTest
    public void run() {
        getDriver().navigateTo("https://www.phptravels.net/");
        String city = "Krakow";
        HomePage homePage = new HomePage(getDriver());
        homePage.switchToHotelsPage();
        CustomSelect customSelect = new CustomSelect("HotelCity", getDriver(), "(//*[@role='combobox'])[1]");
        customSelect.selectItem(city);
        hotelsPage = new HotelsPage(getDriver());
    }

    @Test
    public void tryingToFillEverything() {
        Travellers travellers = new Travellers(1, 3, 2, new int[]{3, 4}, "Poland");
        hotelsPage.setLanguage();
        hotelsPage.setTravellers(travellers);
        hotelsPage.submit();
    }

    @Test
    public void fillRoomsShouldSetValue() {
        hotelsPage.openDropdown();
        hotelsPage.sleep();
        hotelsPage.fillRooms(2);
        assertEquals("2", getDriver().getElement(By.xpath("//input[@id='rooms']")).getAttribute("value").trim());
    }

    @Test
    public void fillKidsShouldSetValue() {
        hotelsPage.openDropdown();
        hotelsPage.sleep();
        hotelsPage.fillKids(3);
        assertEquals("3", getDriver().getElement(By.xpath("//input[@id='childs']")).getAttribute("value").trim());
    }

    @Test
    public void fillAdultsShouldSetValue() {
        hotelsPage.openDropdown();
        hotelsPage.sleep();
        hotelsPage.fillAdults(3);
        assertEquals("3", getDriver().getElement(By.xpath("//input[@id='adults']")).getAttribute("value").trim());
    }

}
