package org.configpoc.config.impl;

import org.configpoc.builder.Parameters;
import org.configpoc.config.Config;
import org.configpoc.exception.ConfigConvertionException;

import java.util.Set;

public abstract class AbstractConfig implements Config {

    protected abstract Parameters getParameters();

    public abstract String getString(String key);

    public int getInt(String key){
        String s=getString(key);
        if(s==null){
            return 0;
        } else {
            try {
                return Integer.parseInt(s.trim());
            }catch(NumberFormatException e){
                if(getParameters().isExceptionOnMissingProperty()) {
                    throw new ConfigConvertionException("Bad int value for key '" + key + "' (value='"+s+"')", e);
                } else {
                    return 0;
                }
            }
        }
    }

    public long getLong(String key){
        String s=getString(key);
        if(s==null){
            return 0;
        } else {
            try {
                return Long.parseLong(s.trim());
            }catch(NumberFormatException e){
                if(getParameters().isExceptionOnMissingProperty()) {
                    throw new ConfigConvertionException("Bad long value for key '" + key + "' (value='"+s+"')", e);
                } else {
                    return 0;
                }
            }
        }
    }

    public boolean getBoolean(String key){
        String s=getString(key);
        if(s==null){
            return false;
        } else {
            String s2=s.trim();
            if(s2.toLowerCase().equals("true")){
                return true;
            } else if(s2.toLowerCase().equals("false")){
                return false;
            } else {
                if(getParameters().isExceptionOnMissingProperty()) {
                    throw new ConfigConvertionException("Bad boolean value for key '" + key + "' (value='"+s+"'<>[true/false])");
                } else {
                    return false;
                }
            }
        }
    }

    public char getChar(String key){
        String s=getString(key);
        if(s==null){
            return 0;
        } else {
            if(s.length()==1){
                return s.charAt(0);
            } else {
                String s2 = s.trim();
                if (s2.length() == 1) {
                    return s2.charAt(0);
                } else {
                    if(getParameters().isExceptionOnMissingProperty()) {
                        throw new ConfigConvertionException("Bad char value for key '" + key + "' (value='"+s+"')");
                    } else {
                        return Character.MIN_VALUE;
                    }
                }
            }
        }
    }

    @Override
    public float getFloat(String key) {
        String s=getString(key);
        if(s==null){
            return 0;
        } else {
            if(s.length()==1){
                return s.charAt(0);
            } else {
                try {
                    return Float.parseFloat(s.trim());
                }catch(NumberFormatException e){
                    if(getParameters().isExceptionOnMissingProperty()) {
                        throw new ConfigConvertionException("Bad float value for key '" + key + "' (value='"+s+"')", e);
                    } else {
                        return 0;
                    }
                }
            }
        }
    }

    @Override
    public double getDouble(String key) {
        String s=getString(key);
        if(s==null){
            return 0;
        } else {
            if(s.length()==1){
                return s.charAt(0);
            } else {
                try {
                    return Double.parseDouble(s.trim());
                }catch(NumberFormatException e){
                    if(getParameters().isExceptionOnMissingProperty()) {
                        throw new ConfigConvertionException("Bad float value for key '" + key + "' (value='"+s+"')", e);
                    } else {
                        return 0;
                    }
                }
            }
        }
    }

    public abstract Set<String> getKeys();

    public abstract Config getConfig(String root);

    public abstract boolean contains(String key);

}
