/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.web.portal.webpotral.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Igor Salnikov <igor.salnikov@stoloto.ru>
 */
@Configuration
@EnableWebMvc
@ComponentScan({"ru.web.portal.webpotral.config",
    "ru.web.portal.webpotral.services",
    "ru.web.portal.webpotral.controllers"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/401").setViewName("500");
    }


    @Bean(name = "jspViewResolver")
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
    
//    @Bean(name = "velocityViewResolver")
//    public VelocityViewResolver velocityViewResolver() {
//        VelocityViewResolver resolver = new VelocityViewResolver();
//        resolver.setViewClass(VelocityToolboxView.class);
//        resolver.setPrefix("/WEB-INF/velocity/");
//        resolver.setSuffix(".vm");
//        resolver.setCache(true);
//        resolver.setOrder(1);
//        return resolver;
//    }
//    
//    @Bean(name = "velocityConfig")
//    public VelocityConfig velocityConfig(){
//        VelocityConfigurer configurer = new VelocityConfigurer();
//        
//        configurer.setConfigLocation("velocity.properties");
//        configurer.setResourceLoaderPath("/WEB-INF/velocity/");
//        return (VelocityConfig) configurer;
//                
//    }

}
