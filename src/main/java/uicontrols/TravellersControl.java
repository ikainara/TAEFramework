package uicontrols;

import BaseControlls.BaseControl;
import Core.TAEDriver;
import Entities.Travellers;
import org.openqa.selenium.By;

public class TravellersControl extends BaseControl {
    public TravellersControl(String name, TAEDriver driver, By locator) {
        super(name, driver, locator);
    }

    public TravellersControl(String name, TAEDriver driver, String xpath) {
        super(name, driver, xpath);
    }

    public void setTravellers(Travellers travellers){
        //this method should set travellers controls
        //to the state of passed travellers object
    }
}
