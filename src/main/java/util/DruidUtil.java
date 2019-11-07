package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 
 *    ���ݿ����ӳع���
 *
 */
public class DruidUtil {
	private static DataSource ds;
         static {
        	 //--1   ���������ļ���Ϣ
        	 Properties ps=new Properties();       //map<Object,Object>
        	 //2.�����������ļ���
        	 InputStream in= DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            //3. ��ȡ�����ļ�������
        	 try {
				ps.load(in);     //--�򵥶�ȡ�����ļ�����Ϣ
				ds= DruidDataSourceFactory.createDataSource(ps);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 //--4.  ͨ��������Ϣ��������ԴDataSource(��ʵ�������ӳض���)
        	
         }
	public static Connection getConnection() {
		Connection con=null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void close(Statement stmt,Connection con) {		
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(con !=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void close(Statement stmt,Connection con,ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(con !=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
         
}
        