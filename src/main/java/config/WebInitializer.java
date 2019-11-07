package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
//Tomcat������ʱ������Ƿ���WebApplicationInitializer�ӿڵ���
//����⵽����࣬�ͻ�ʵ�������󣬲���������onStartup����
public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//  ����Spring ����
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		//  Spring������������
		ctx.register(AppConfig.class);
		//  Spring�����ӹ�ServletContextӦ�õ������Ķ���
		ctx.setServletContext(servletContext);
		//  ���Servlet(�������һ��Servlet��SpringMVC���ʵ�ֵ����Servlet)
		ServletRegistration.Dynamic servlet =
				servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
	
}
     //����ʹ��Spring,�͵���Spring������ʵ��
	  //����ʹ�� Spring MVC ,�͵�����DispatcherServlet��ʵ��
	 //��Ҫ�������������ŵ�ServletContext������,     ��Ϊ��������������������

