/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.web.portal.webpotral.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author Igor Salnikov <igor.salnikov@stoloto.ru>
 */
public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    
    
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
         return new Class[] {SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SecurityConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
        
    }
    
}
