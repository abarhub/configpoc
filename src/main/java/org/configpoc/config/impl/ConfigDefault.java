package org.configpoc.config.impl;

import org.configpoc.builder.Parameters;
import org.configpoc.config.Config;
import org.configpoc.util.ConfigUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConfigDefault extends AbstractConfig implements Config {

    private final Map<String,String> configuration;
    private final Parameters parameters;

    public ConfigDefault(Map<String, String> configuration, Parameters parameters) {
        this.configuration = configuration;
        this.parameters = parameters;
    }

    public ConfigDefault(ConfigDefault configDefault) {
        this.configuration =new HashMap<>(configDefault.configuration);
        this.parameters =new Parameters(configDefault.parameters);
    }

    @Override
    public String getString(String key) {
        return configuration.get(key);
    }

    @Override
    public Set<String> getKeys() {
        return configuration.keySet();
    }

    @Override
    public Config getConfig(String root) {
        ConfigUtil.checkNotNull(root,"root is null");
        ConfigUtil.checkParameter(root.trim().isEmpty(),"root is empty");
        Map<String,String> map=new HashMap<>();
        String rootDot=root+".";
        for(String key:getKeys()){
            if(key.startsWith(rootDot)){
                String s=key.substring(rootDot.length());
                map.put(s,getString(key));
            }
        }
        return new ConfigDefault(map,new Parameters(parameters));
    }

    @Override
    protected Parameters getParameters() {
        return parameters;
    }

    @Override
    public boolean contains(String key) {
        return configuration.containsKey(key);
    }
}
