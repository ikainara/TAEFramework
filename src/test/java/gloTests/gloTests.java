package gloTests;

import BaseTest.BaseAbstractChromeTest;
import Entities.User;
import TAExceptions.TAUnknownBrowserException;
import forms.ProfileWidgetForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class gloTests extends BaseAbstractChromeTest {
    public gloTests() throws TAUnknownBrowserException {
    }

    private ProfileWidgetForm profileWidgetForm;
    private String wrongPassword;

    @BeforeTest
    public void login() {
        getDriver().getDriver().get("https://bit.ly/2YZLfoY");
        LoginPage loginPage = new LoginPage(getDriver());
        User user = new User("login", "password");
        loginPage.tryLogin(user);
        profileWidgetForm = new ProfileWidgetForm(getDriver());
    }

    @Test
    public void checkingNumbersOfPeopleFollowed() {
        assertEquals("4", profileWidgetForm.IFollow.getText().trim());
    }

    @Test
    public void checkingName() {
        assertEquals("Karol Wasyliszyn", profileWidgetForm.name.getText());
    }

    @Test
    public void checkingPeopleWhoFollowsMe() {
        assertEquals("4", profileWidgetForm.followMe.getText());
    }

    @Test
    public void checkingNumberOfTeammates() {
        assertEquals("204", profileWidgetForm.teammates.getText());
    }

    @Test
    public void checkingCommunities() {
        assertEquals("24", profileWidgetForm.communities.getText());
    }

    @Test
    public void checkingPosition() {
        assertEquals("Trainee Test Engineer,Quality Assurance", profileWidgetForm.position.getText());
    }
}
