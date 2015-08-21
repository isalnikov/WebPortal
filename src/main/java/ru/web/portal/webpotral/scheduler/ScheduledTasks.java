/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.web.portal.webpotral.scheduler;

import java.time.LocalTime;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author Igor Salnikov <isalnikov1@gmail.com>
 */
@Service
public class ScheduledTasks {
    
    @Autowired
    MessageSource messageSource;
    
    @Scheduled(fixedDelay = 10 * 1000)
    public void currentTime() {
        String time =  messageSource.getMessage("time",null, Locale.getDefault());
        System.out.printf("%s : %s\n",time, LocalTime.now());
    }

}
