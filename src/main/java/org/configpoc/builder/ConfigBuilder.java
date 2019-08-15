package org.configpoc.builder;

import org.configpoc.config.Config;
import org.configpoc.config.impl.ConfigDefault;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ConfigBuilder {

    private final Map<String,String> configuration;
    private final Parameters parameters;

    public ConfigBuilder() {
        this.configuration = new HashMap<>();
        this.parameters = new Parameters();
    }

    public ConfigBuilder addPropertyFile(Path propertyfile) throws IOException {
        Properties properties=new Properties();
        properties.load(Files.newBufferedReader(propertyfile, StandardCharsets.UTF_8));
        Set<Object> set=properties.keySet();
        if(set!=null&&!set.isEmpty()){
            for(Object key:set) {
                String keyStr= (String) key;
                configuration.put(keyStr,properties.getProperty(keyStr));
            }
        }
        return this;
    }

    public ConfigBuilder setExceptionOnMissingProperty(boolean value){
        parameters.setExceptionOnMissingProperty(value);
        return this;
    }

    public ConfigBuilder setProperty(String key, String value){
        configuration.put(key, value);
        return this;
    }

    public Config build(){
        return new ConfigDefault(new HashMap<>(configuration), new Parameters(parameters));
    }
}
