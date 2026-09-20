package com.automation.testdata.reader;

import com.automation.core.exception.FrameworkException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyTestDataReader {

    private final Properties properties ;

    public PropertyTestDataReader(String resourcePath){
        properties = new Properties();
        load(resourcePath);
    }

    private void load(String resourcePath){
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)){
            if(inputStream == null){
                throw new FrameworkException("Test data file not found : "+resourcePath);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new FrameworkException("Failed to load test data : "+resourcePath, e);
        }
    }

    public String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new FrameworkException("Test data key not found: " + key);
        }
        return value;
    }

    public String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
