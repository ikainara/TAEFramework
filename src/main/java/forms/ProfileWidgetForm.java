package forms;

import BaseElements.BaseAbstractForm;
import Core.TAEDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileWidgetForm extends BaseAbstractForm {



    @FindBy(xpath = "//div[text()='People Who Follow Me']//following-sibling::div")
    public WebElement followMe;

    @FindBy(id = "follow_count")
    public WebElement IFollow;

    @FindBy(xpath = "//div[text()='Teammates']//following-sibling::div")
    public WebElement teammates;

    @FindBy(xpath = "//div[text()='My Communities']//following-sibling::div")
    public WebElement communities;

    @FindBy(xpath = "//div[@class='profile-widget-content']//h2")
    public WebElement name;

    @FindBy(xpath = "//div[@class='profile-widget-content']//p")
    public WebElement position;

    public ProfileWidgetForm(TAEDriver driver) {
        super(driver);
        PageFactory.initElements(driver.getDriver(), this);
        getLogger().info("elements to check set");
    }
}
