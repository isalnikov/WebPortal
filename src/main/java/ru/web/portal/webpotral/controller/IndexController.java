/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.web.portal.webpotral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Igor Salnikov <isalnikov1@gmail.com>
 */
@Controller
public class IndexController {
    
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return String.format(" random : %s", Math.random());
    }

}
