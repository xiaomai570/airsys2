package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
//Tomcat启动的时候会检测是否有WebApplicationInitializer接口的类
//若检测到这个类，就会实例化对象，并调用它的onStartup方法
public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//  构造Spring 容器
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		//  Spring容器加载配置
		ctx.register(AppConfig.class);
		//  Spring容器接管ServletContext应用的上下文对象
		ctx.setServletContext(servletContext);
		//  添加Servlet(至少添加一个Servlet，SpringMVC框架实现的入口Servlet)
		ServletRegistration.Dynamic servlet =
				servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
	
}
     //你想使用Spring,就调用Spring容器的实例
	  //你想使用 Spring MVC ,就得配置DispatcherServlet的实例
	 //还要把这俩个东西放到ServletContext对象里,     因为他们俩都是重量级对象

