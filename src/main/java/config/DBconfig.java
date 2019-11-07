package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/*
 * ���ݿ�����
 * (1).�������������������Ϣ��λ��    @PropetySource
 * (2)����Ioc����ע��������Ϣ      
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DBconfig {
       //--1.������Ϣ
	     @Value("${jdbc.driverClass}")
	   private String driver;
	     @Value("${jdbc.url}")
	   private String url;
	     @Value("${jdbc.username}")
	   private String username;
	     @Value("${jdbc.password}")
	   private String password;
	   //--2.DataSource Bean
	     @Bean(name="dataSource")
	   public DataSource createDataSource() {
		   DruidDataSource ds=new DruidDataSource();
		   ds.setDriverClassName(driver);
		   ds.setUrl(url);
		   ds.setUsername(username);
		   ds.setPassword(password);
		   return ds;
	   }
	  //3.JdbcTemplate
	     @Bean(name="jdbcTemplate")
	     public JdbcTemplate createJdbcTemplate(DataSource ds) {
			return new JdbcTemplate(ds);
	    	 
	     }
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
}
