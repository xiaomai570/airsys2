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
 * 应用配置（Spring配置)
 * 它相当于XML的替代者
 */
@Configuration	
@ComponentScan({"dao","service","controller"})
@Import(DBconfig.class)
@EnableAspectJAutoProxy
//@EnableWebMvc  如果要启动，就不继承，如不不用标注，就继承
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
