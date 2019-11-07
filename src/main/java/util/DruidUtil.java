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
 *    数据库连接池工具
 *
 */
public class DruidUtil {
	private static DataSource ds;
         static {
        	 //--1   加载配置文件信息
        	 Properties ps=new Properties();       //map<Object,Object>
        	 //2.建立到配置文件流
        	 InputStream in= DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            //3. 读取配置文件的数据
        	 try {
				ps.load(in);     //--简单读取配置文件的信息
				ds= DruidDataSourceFactory.createDataSource(ps);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 //--4.  通过配置信息建立数据源DataSource(其实就是连接池对象)
        	
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
        