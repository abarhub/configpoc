package org.configpoc.exception;

public class ConfigConvertionException extends ConfigException {

    public ConfigConvertionException(String message) {
        super(message);
    }

    public ConfigConvertionException(String message, Throwable cause) {
        super(message, cause);
    }
}
