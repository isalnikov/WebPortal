/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.web.portal.webpotral.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Igor Salnikov <igor.salnikov@stoloto.ru>
 */
@Controller
public class SupportController {
    
    @RequestMapping("/support")
    public String index() {
        return "support";
    }
    
}
