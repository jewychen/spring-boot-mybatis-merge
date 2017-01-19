package org.monkey.schedule;

import org.monkey.service.PersonService;
import org.monkey.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by monkey on 2017/1/5.
 */

@Component
public class MySchedule {
    private static Logger logger = LoggerFactory.getLogger(MySchedule.class);


    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    @Scheduled(fixedRate = 5000)
    public void testTwoDatasources(){
        System.out.println("testing...........");

        //Mysql DS Test
        String mysqlUserName = userService.getUserByName("jerry");
        logger.info(".... userName from [mysql]:" + mysqlUserName);

        //Mysql batch Insert Test
//        userService.testBatchInsertUser();

        //GreenPlum DS Test
        String gpUserName = personService.getPersonNameById(1);
        logger.info(".... userName from [GP]:   " + gpUserName );




    }
}
