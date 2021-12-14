package com.company.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/* <context:component-scan base-package="com.company.controller" /> */
@ComponentScan("com.company.controller")

/* <!-- Enables the Spring MVC @Controller programming model -->
<annotation-driven /> */
@EnableWebMvc
@Configuration
public class ServletConfig implements WebMvcConfigurer {
	
		/* <!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
		<resources mapping="/resources/**" location="/resources/" /> */
	
	   @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
	      registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	   }
	   
		/* <!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
		<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<beans:property name="prefix" value="/WEB-INF/views/" />
			<beans:property name="suffix" value=".jsp" />
		</beans:bean> */
	
	   @Override
	   public void configureViewResolvers(ViewResolverRegistry registry) {
	       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	       viewResolver.setViewClass(JstlView.class);
	       viewResolver.setPrefix("/WEB-INF/views/");
	       viewResolver.setSuffix(".jsp");
	       registry.viewResolver(viewResolver);
	    }
	
}
