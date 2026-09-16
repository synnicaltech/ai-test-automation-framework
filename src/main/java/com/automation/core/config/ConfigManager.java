package com.automation.core.config;

import com.automation.core.exception.FrameworkException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigManager {

    private static final String DEFAULT_ENVIRONMENT = "qa";

    private static final Properties PROPERTIES = new Properties();

    static {
        loadConfigurations();
    }

    private static void loadConfigurations(){
        String environment = System.getProperty("env", DEFAULT_ENVIRONMENT);
        String fileName = "config/config-"+environment.toLowerCase()+".properties";

        try(InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(fileName)){
            if(inputStream == null){
                throw new FrameworkException("Configuration file not found: "+fileName);
            }
            PROPERTIES.load(inputStream);
            System.out.println("Configurations loaded for environment: "+environment);
        } catch (IOException e) {
            throw new FrameworkException("Failed to load configurations: "+fileName, e);
        }
    }

    public static String get(String key){
        String systemProperty = System.getProperty(key);
        if(systemProperty != null && !systemProperty.isBlank()){
            return systemProperty;
        }
        String value = PROPERTIES.getProperty(key);
        if(value == null){
            throw new FrameworkException("Configuration key not found: "+key);
        }
        return value;
    }

    public static String get(String key, String def){
        String systemProperty = System.getProperty(key);
        if (systemProperty != null && !systemProperty.isBlank()) {
            return systemProperty;
        }
        return PROPERTIES.getProperty(key, def);
    }

    public static int getInt(String key){
        return Integer.parseInt(get(key));
    }

    public static boolean getBoolean(String key){
        return Boolean.parseBoolean(get(key));
    }
}
