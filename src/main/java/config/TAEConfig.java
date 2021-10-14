package config;

import Core.TAEBaseObject;
import Entities.User;
import TAExceptions.TAConfigFileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class TAEConfig extends TAEBaseObject {

    public static User getSuccessfulUser(){
        Properties properties = getProperties(ConfigFiles.USERS.getDisplayName());

        return new User(properties.getProperty("successful.username"), properties.getProperty("successful.password"));
    }

    private static Properties getProperties(String propertiesFile) {
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream(propertiesFile);
        try {
            if (stream != null) {
                properties.load(stream);
            } else {
                throw new TAConfigFileNotFoundException(String.format("Unable to find config file '%s'", propertiesFile));
            }
        } catch (Exception e) {
            getLogger().error(String.format("Unable to read properties file '%s'. Following error occur:\n%s", propertiesFile, e.getMessage()));
        }
        return properties;
    }

}
