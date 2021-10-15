package Entities;

public enum HomePageTabs {
    HOME("Home"),
    HOTELS("Hotels"),
    FLIGHTS("Flights"),
    CARS("Cars");
    private String displayName;

    HomePageTabs(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
