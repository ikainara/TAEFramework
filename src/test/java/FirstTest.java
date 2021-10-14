import BaseTest.BaseAbstractChromeTest;
import Entities.User;
import TAExceptions.TAUnknownBrowserException;
import config.TAEConfig;
import org.testng.annotations.Test;
import uicontrols.CustomSelect;


public class FirstTest extends BaseAbstractChromeTest {
    public FirstTest() throws TAUnknownBrowserException {
    }

    @Test
    public void citySearch() {
        getDriver().getDriver().get("https://www.phptravels.net/");
        CustomSelect customSelect = new CustomSelect("HotelCity", getDriver(), "(//*[@role='combobox'])[1]");
        customSelect.selectItem("Krakow");
        int a = 5+6;

    }

    @Test
    public void test1() {
        getDriver().getDriver().get("https://www.glo.globallogic.com/");

        User user = TAEConfig.getSuccessfulUser();

    }

}
