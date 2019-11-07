package config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/*
 * Ӧ�����ã�Spring����)
 * ���൱��XML�������
 */
@Configuration	
@ComponentScan({"dao","service","controller"})
@Import(DBconfig.class)
@EnableAspectJAutoProxy

public class TestConfig {
	     
}
