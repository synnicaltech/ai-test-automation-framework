package com.automation.testdata.reader;

import com.automation.core.exception.FrameworkException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyTestDataReader {

    private static final Logger log = LoggerFactory.getLogger(PropertyTestDataReader.class);

    private final Properties properties ;

    public PropertyTestDataReader(String resourcePath){
        properties = new Properties();
        load(resourcePath);
    }

    private void load(String resourcePath){
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)){
            if(inputStream == null){
                log.error("Test data file not found: {}", resourcePath);
                throw new FrameworkException("Test data file not found : "+resourcePath);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            log.error("Failed to load test data: {}", resourcePath, e);
            throw new FrameworkException("Failed to load test data : "+resourcePath, e);
        }
    }

    public String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            log.error("Test data key not found: {}", key);
            throw new FrameworkException("Test data key not found: " + key);
        }
        return value;
    }

    public String get(String key, String defaultValue) {
        String value = properties.getProperty(key, defaultValue);
        if(value == null){
            log.error("Test data key not found: {}", key);
            throw new FrameworkException("Test data key not found: "+ key);
        }
        return value;
    }
}
