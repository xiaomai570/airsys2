package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	       //跟据字符串转化为日期格式
          public static Date ToDate(String DataFormat,String date) {
        	  SimpleDateFormat sdf =new SimpleDateFormat(DataFormat);
        	  try {
				return sdf.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;  	  
          }
          //根据某种日期格式转化为字符串
          public static String dateToString(String dateFormat,Date date) {
         
			return new SimpleDateFormat(dateFormat).format(date);
        	  
          }
}
