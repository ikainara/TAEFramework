package pages;

import BaseElements.BaseAbstractPage;
import Core.TAEDriver;
import Entities.HotelsSearch;
import Entities.Travellers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uicontrols.CustomSelect;
import uicontrols.TravellersControl;

public class HotelsPage extends BaseAbstractPage {
    public static String TITLE = "Search Hotels - PHPTRAVELS";
    CustomSelect cityDropdown;

    @FindBy(xpath = "//*[@class='dropdown-menu dropdown-menu-wrap']/..")
    public WebElement travellersDropdown;
    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//button[@id='languages']")
    public WebElement languageButton;
    @FindBy(xpath = "(//a[normalize-space()='English'])[1]")
    public WebElement english;
    @FindBy(xpath = ("(//i[@class='la la-plus'])[3]"))
    public WebElement increaseAdults;
    @FindBy(xpath = ("(//div[@class='qtyDec'])[2]"))
    public WebElement decreaseAdults;
    @FindBy(xpath = ("(//div[@class='roomInc'])[1]"))
    public WebElement increaseRooms;
    @FindBy(xpath = ("(//div[@class='qtyInc'])[3]"))
    public WebElement increaseKids;
    @FindBy(xpath = ("(//select[@id='nationality'])[1]"))
    public WebElement setCountry;

    public HotelsPage(TAEDriver driver) {
        super(driver, TITLE);
        PageFactory.initElements(driver.getDriver(), this);
        cityDropdown = new CustomSelect("HotelCity", driver, "//span[@role='combobox']");
    }

    public HotelsPage selectCity(String cityName) {
        cityDropdown.selectItem(cityName);
        return this;
    }

    public HotelsPage setTravellers(Travellers travellers) {
        openDropdown();
        sleep();
        fillRooms(travellers.getRooms());
        fillAdults(travellers.getAdults());
        fillKids(travellers.getKids());
        fillKidsAges(travellers.getKidsAges(), travellers.getKids());
        fillCountry(travellers.getCountry());
        return this;
    }

    public void openDropdown() {
        travellersDropdown.click();
        getLogger().info("dropdown clicked");
    }

    public void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fillRooms(int rooms) {
        if (rooms > 1) {
            for (int i = 1; i < rooms; i++) {
                increaseRooms.click();
            }
        }
        getLogger().info("rooms filled");
    }

    public void fillKids(int kids) {
        if (kids > 0) {
            for (int i = 0; i < kids; i++) {
                increaseKids.click();
            }
        }
        getLogger().info("kids filled");
    }

    public void fillAdults(int adults) {
        if (adults > 2) {
            for (int i = 2; i < adults; i++) {
                increaseAdults.click();
            }
        } else if (adults < 2) {
            for (int i = 2; i > adults; i--) {
                decreaseAdults.click();
            }
        }
        getLogger().info("adults filled");
    }

    public void fillCountry(String country) {
        if (country != null) {
            setCountry.sendKeys(country);
        }
        getLogger().info("country filled");
    }

    public void fillKidsAges(int[] ages, int kids) {
        if (ages != null) {
            WebElement input;
            for (int i = 1; i <= kids; i++) {
                input = driver.getElement(By.xpath("(//select[@id='ages" + i +"'])[1]"));
                input.sendKeys(String.valueOf(ages[i - 1]));
            }
        }
        getLogger().info("kids ages filled");
    }

    public HotelsPage submit() {
        submitButton.click();
        return this;
    }

    public HotelsPage fillPage(HotelsSearch hotelsSearch) {
        selectCity(hotelsSearch.getCityName());
        setTravellers(hotelsSearch.getTravellers());
        return this;
    }

    public HotelsPage fillPageAndSearch(HotelsSearch hotelsSearch) {
        fillPage(hotelsSearch);
        submit();
        return this;
    }

    public void setLanguage() {
        if (!(languageButton.getText().trim().equals("English"))) {
            languageButton.click();
            sleep();
            english.click();
        }
    }
}
