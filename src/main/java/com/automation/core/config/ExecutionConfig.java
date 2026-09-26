package com.automation.core.config;

import com.automation.core.driver.ExecutionType;
import com.automation.core.exception.FrameworkException;

public final class ExecutionConfig {

    private ExecutionConfig(){}

    public static ExecutionType getExecutionType(){
        String value = ConfigManager.get("execution.type", "remote");
        try{
            return ExecutionType.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new FrameworkException("Unsupported execution type: "+value, e);
        }
    }

    public static String getRemoteURL(){
        return ConfigManager.get("remote.url", "http://localhost:4444");
    }
}
