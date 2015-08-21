/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.web.portal.webpotral.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@ComponentScan({
    "ru.web.portal.webpotral.config",
    "ru.web.portal.webpotral.services",
    "ru.web.portal.webpotral.controllers"
})

@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder encoder = passwordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(encoder);
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "USER");
        auth.inMemoryAuthentication().withUser("support").password("support").roles("SUPPORT", "USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/about", " /resources/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/support/**").hasRole("SUPPORT")
                .anyRequest().authenticated()
                .and().rememberMe()
                .and().formLogin()
                .permitAll().defaultSuccessUrl("/", true);

        http
                .sessionManagement().maximumSessions(1);
        http
                .logout().deleteCookies("JSESSIONID").permitAll();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**"); // #3
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    public static class WebConfig extends WebMvcConfigurerAdapter {

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/favicon.ico").addResourceLocations("/favicon.ico").setCachePeriod(31556926);
            registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
        }

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/401").setViewName("500");
            registry.addViewController("/about").setViewName("about");
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

}
