/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.web.portal.webpotral.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Настройки Безопасности 
 * (Spring Security — SecurityConfig.java, SecurityWebApplicationInitializer.java)
 * Нужно настроить все так чтобы определенный URL паттерн (путь к определенному ресурсу) 
 * проходил через уровень безопасности (проходил бы проверку фильтрами Spring Security)
  * AbstractAnnotationConfigDispatcherServletInitializer
 * 
 * @author Igor Salnikov <igor.salnikov@stoloto.ru>
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer{
    
}
