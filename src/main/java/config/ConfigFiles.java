package config;

public enum ConfigFiles {
    USERS("users.properties");
    private String displayName;
    ConfigFiles(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
