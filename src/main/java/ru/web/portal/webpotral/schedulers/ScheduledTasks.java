/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.web.portal.webpotral.schedulers;

import java.time.LocalTime;
import java.util.Date;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author Igor Salnikov <igor.salnikov@stoloto.ru>
 */
@EnableScheduling
@Service
public class ScheduledTasks {
    
    
     @Scheduled(fixedRate = 5000)
     public void currentTime()  {
          System.out.printf( "time : %s\n" ,LocalTime.now());
         }
}
