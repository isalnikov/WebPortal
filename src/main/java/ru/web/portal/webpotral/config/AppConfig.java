/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.web.portal.webpotral.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Настройка поддержки асинхронности Выполнение заданий по расписанию
 *
 * @author Igor Salnikov <igor.salnikov@stoloto.ru>
 */
@Configuration
@EnableAsync
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        return configurer;
    }

    @Configuration
    @PropertySources({
        @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "classpath:messages.properties", ignoreResourceNotFound = true),
    })
    public static class JpaAppConfig {
        
    }
}
