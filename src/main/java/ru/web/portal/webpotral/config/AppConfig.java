/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.web.portal.webpotral.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Настройка поддержки асинхронности 
 * Выполнение заданий по расписанию 
 * @author Igor Salnikov <igor.salnikov@stoloto.ru>
 */

@Configuration
@EnableAsync
@EnableScheduling
public class AppConfig {
    
}
