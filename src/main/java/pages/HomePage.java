package pages;

import BaseElements.BaseAbstractPage;
import Core.TAEDriver;
import Entities.HomePageTabs;
import forms.HotelForm;
import org.apache.commons.lang3.*;
import org.openqa.selenium.By;

public class HomePage extends BaseAbstractPage {
    public static String TITLE = "PHPTRAVELS - PHPTRAVELS";

    public HotelForm hotelForm;
    public HomePage(TAEDriver driver) {
        super(driver, TITLE);
        hotelForm = new HotelForm(driver);
        switchLanguageToEnglish();
    }

    public HotelsPage switchToHotelsPage() {
        switchToTab(HomePageTabs.HOTELS);
        return new HotelsPage(driver);
    }

    public void switchToFlightsPage() {
        switchToTab(HomePageTabs.FLIGHTS);
    }

    public void switchToCarsPage() {
        switchToTab(HomePageTabs.CARS);
    }

    private void switchToTab(HomePageTabs tabName) {
        driver.getElement(String.format("//li/a[text()='%s']", tabName.getDisplayName())).click();
    }

    private void switchLanguageToEnglish() {
        if(!StringUtils.trim(driver.getElement(By.xpath("//button[@id='languages']")).getText()).equalsIgnoreCase("english")) {
            driver.getElement(By.id("languages")).click();
            driver.getElement(By.xpath("//ul/li/a[text()=' English']")).click();
        }
    }
}
