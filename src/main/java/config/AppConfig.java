package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/*
 * Ӧ�����ã�Spring����)
 * ���൱��XML�������
 */
@Configuration	
@ComponentScan({"dao","service","controller"})
@Import(DBconfig.class)
@EnableAspectJAutoProxy
//@EnableWebMvc  ���Ҫ�������Ͳ��̳У��粻���ñ�ע���ͼ̳�
public class AppConfig extends WebMvcConfigurationSupport{
	       @Bean
	      public UrlBasedViewResolver setupViewResolver() {
	    	  UrlBasedViewResolver resolver =new UrlBasedViewResolver();
	    	  resolver.setPrefix("/WEB-INF/");
	    	  resolver.setSuffix(".jsp");
	    	  resolver.setViewClass(JstlView.class);
	    	  return resolver;
	      }
	       
	       @Override
	    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	   registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	   super.addResourceHandlers(registry);
	    }
	       
	       
	       
	       
	       
	       
	       
}
