package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	       //�����ַ���ת��Ϊ���ڸ�ʽ
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
          //����ĳ�����ڸ�ʽת��Ϊ�ַ���
          public static String dateToString(String dateFormat,Date date) {
         
			return new SimpleDateFormat(dateFormat).format(date);
        	  
          }
}
