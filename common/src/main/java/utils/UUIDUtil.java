package utils;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID(){
        String uuidStr = UUID.randomUUID().toString();
        return uuidStr.replaceAll("-", "");

    }

}
