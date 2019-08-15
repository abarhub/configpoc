package org.configpoc.exception;

public class ConfigIllegalArgumentException extends ConfigException {

    public ConfigIllegalArgumentException(String message) {
        super(message);
    }

    public ConfigIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
