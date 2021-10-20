package uicontrols;

import BaseControlls.BaseControl;
import Core.TAEDriver;
import Entities.Travellers;
import forms.HotelForm;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pages.HotelsPage;

public class TravellersControl extends BaseControl {
    public TravellersControl(String name, TAEDriver driver, By locator) {
        super(name, driver, locator);
    }

    public TravellersControl(String name, TAEDriver driver, String xpath) {
        super(name, driver, xpath);
    }

    public void setTravellers(Travellers travellers){
        HotelsPage hotelsPage = new HotelsPage(driver);
        hotelsPage.setTravellers(travellers);
    }
}
