/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.web.portal.webpotral.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Igor Salnikov <igor.salnikov@stoloto.ru>
 */
@ControllerAdvice
public class ExceptionHandlerController {
    
    
    
    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handelException(Exception e) {
        return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
