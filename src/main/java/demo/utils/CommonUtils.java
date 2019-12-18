package demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CommonUtils {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    /**
     * 获取 uuid
     *
     * @return
     */
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }

    public static String getDateByFormat(Date date){

        return dateFormat.format(date);
    }
}
