package com.springHello.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Created by mar1 on 2/17/17.
 */
public class DateFormate {

    private static SimpleDateFormat makeDateFomat(String format){
        return new SimpleDateFormat("dd/MM/yyyy");
    }

    public static Date StringToDate(String Sdate,String dateFormat){
        Date date = null;
        try {
            date = makeDateFomat(dateFormat).parse(Sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
