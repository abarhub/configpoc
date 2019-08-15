package org.configpoc.util;

import org.configpoc.exception.ConfigIllegalArgumentException;

public class ConfigUtil {

    public static void checkNotNull(Object o,String messageError){
        if(o==null){
            throw new ConfigIllegalArgumentException(messageError);
        }
    }

    public static void checkParameter(boolean test,String messageError){
        if(test){
            throw new ConfigIllegalArgumentException(messageError);
        }
    }
}
