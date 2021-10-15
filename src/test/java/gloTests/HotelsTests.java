package gloTests;

import BaseTest.BaseAbstractTest;
import Entities.HotelsSearch;
import Entities.Travellers;
import TAExceptions.TAUnknownBrowserException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelsPage;

public class HotelsTests extends BaseAbstractTest {

    public HotelsTests() throws TAUnknownBrowserException {
        super("chrome");
    }

    @Test
    public void testHotelsPage() {
        getDriver().navigateTo("https://www.phptravels.net/");

        String city = "Krakow";
        Travellers travellers = new Travellers();
        HotelsSearch hotelsSearch = new HotelsSearch();

        new HomePage(getDriver()).switchToHotelsPage().fillPageAndSearch(hotelsSearch);



        int a = 5+6;
    }
}
