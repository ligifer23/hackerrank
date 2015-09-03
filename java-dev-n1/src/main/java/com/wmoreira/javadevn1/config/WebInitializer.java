package com.wmoreira.javadevn1.config;

import com.wmoreira.javadevn1.presentation.service.filter.ConstraintViolationFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.wmoreira.api.core.exception.filter.ExceptionHandlingFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author wellington.362@gmail.com
 */
@Configuration
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
	//Web app context
	AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();

	//Context listener
	container.addListener(new ContextLoaderListener(webAppContext));

        //Dispatcher
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(DispatcherServlet.class);
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    @Bean
    public FilterRegistrationBean exceptionHandlingFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ExceptionHandlingFilter());
        registration.addUrlPatterns("/*");
        registration.setMatchAfter(false);
        registration.setName("exceptionHandlingFilter");
        return registration;
    }

    @Bean
    public FilterRegistrationBean constraintViolationFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ConstraintViolationFilter());
        registration.addUrlPatterns("/*");
        registration.setMatchAfter(true);
        registration.setName("constraintViolationFilter");
        return registration;
    }
}
