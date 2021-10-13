import BaseTest.BaseAbstractChromeTest;
import Entities.User;
import TAExceptions.TAUnknownBrowserException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FirstTest extends BaseAbstractChromeTest {
    public FirstTest() throws TAUnknownBrowserException {
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        getDriver().getDriver().get("https://glo.globallogic.com/apps/glo/login");
        User user = new User("fakeLogin", "fakePassword");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.tryLogin(user);

        Assert.assertNotEquals(getDriver().getDriver().getTitle(), LoginPage.TITLE,
                String.format("Verify that login attempt was unsuccessful for user with username: '%s', password: '%s'",
                        user.getUserName(), user.getPassword()));

    }

    @Test
    public void testPageInfoText() {
        getDriver().getDriver().get("https://glo.globallogic.com/apps/glo/login");

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertEquals(loginPage.getPageInfoText(), LoginPage.INFO_TEXT, "Verify page info text corresponds to expected one");
    }
}
