package Entities;

import java.util.Date;

public class HotelsSearch {

    private String cityName;
    private Date fromDate;
    private Date toDate;
    private Travellers travellers;

    public HotelsSearch() {}

    public HotelsSearch(String cityName, Date fromDate, Date toDate, Travellers travellers) {
        this.cityName = cityName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.travellers = travellers;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Travellers getTravellers() {
        return travellers;
    }

    public void setTravellers(Travellers travellers) {
        this.travellers = travellers;
    }
}
