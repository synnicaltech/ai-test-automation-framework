package com.automation.core.config;

import com.automation.core.exception.FrameworkException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigManager {

    private final static Logger log = LoggerFactory.getLogger(ConfigManager.class);

    private static final String DEFAULT_ENVIRONMENT = "qa";

    private static final Properties PROPERTIES = new Properties();

    static {
        loadConfigurations();
    }

    private static void loadConfigurations(){
        String environment = System.getProperty("env", DEFAULT_ENVIRONMENT);
        String fileName = "config/config-"+environment.toLowerCase()+".properties";

        log.info("Loading configuration for environment: {}", environment);
        try(InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(fileName)){
            if(inputStream == null){
                log.error("Configuration file not found: {}", fileName);
                throw new FrameworkException("Configuration file not found: "+fileName);
            }
            PROPERTIES.load(inputStream);
            log.info("Configuration loaded successfully: {}", fileName);
        } catch (IOException e) {
            log.error("Failed to load configuration: {}", fileName, e);
            throw new FrameworkException("Failed to load configurations: "+fileName, e);
        }
    }

    public static String get(String key){
        String systemProperty = System.getProperty(key);
        if(systemProperty != null && !systemProperty.isBlank()){
            log.debug("Using system property for key: {}", key);
            return systemProperty;
        }
        String value = PROPERTIES.getProperty(key);
        if(value == null){
            log.error("Configuration key not found: {}", key);
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
        try {
            return Integer.parseInt(get(key));
        }catch (NumberFormatException e){
            log.error("Invalid integer configuration value for key: {}", key, e);
            throw new FrameworkException("Invalid integer configuration value for key: " + key, e);
        }
    }

    public static boolean getBoolean(String key){
        return Boolean.parseBoolean(get(key));
    }
}
