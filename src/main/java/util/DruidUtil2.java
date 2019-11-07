package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtil2 {
	//线程池对象（其实就是Map,key存储线程Id，value放置连接对象
	private static ThreadLocal<Connection> threadPool =
			new ThreadLocal<Connection>();
	private static DataSource ds;         //--数据源对象（连接池）
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
    /*
     * 获取连接的方法
     */
    public static Connection getConnection() {
    	//如果从线程池中拿不到一个连接，就创建了一个连接，如果拿不到了就创建连接，从线程池中取连接
    	if(threadPool.get()==null) {
    		try {
				Connection  con=ds.getConnection();
				con.setAutoCommit(false);
				threadPool.set(con);
				return con;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		return threadPool.get();
    }
    
    public static void close(Statement stmt,Connection con) {
    	if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	if(con!=null) {
    		threadPool.remove();
    		try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    public static void close() {
    	if(threadPool.get()!=null) {
    		try {
				threadPool.get().commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				threadPool.get().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		threadPool.remove();
    	}
    }
  
}
