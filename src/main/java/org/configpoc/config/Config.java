package org.configpoc.config;

import java.util.Set;

public interface Config {

    String getString(String key);

    int getInt(String key);

    long getLong(String key);

    boolean getBoolean(String key);

    char getChar(String key);

    float getFloat(String key);

    double getDouble(String key);

    Set<String> getKeys();

    Config getConfig(String root);

    boolean contains(String key);
}
