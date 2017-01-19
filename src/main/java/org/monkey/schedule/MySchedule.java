package org.monkey.schedule;

import org.monkey.service.MyDomainService;
import org.monkey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by monkey on 2017/1/5.
 */

@Component
public class MySchedule {

//    @Autowired
//    @Qualifier(value = "firstDs")
//    private DataSource firstDs;

    @Autowired
    private UserService userService;

    @Autowired
    private MyDomainService myDomainService;

    @Scheduled(fixedRate = 5000)
    public void TestSomething(){
        System.out.println("testing...........");
//        System.out.println(firstDs);
//        System.out.println(firstDs.getClass());


//        String username = userService.getUserByName("jerry");
//        System.out.println("username:" + username);
//
//        String mydomain = myDomainService.getDomainById(1);
//        System.out.println("mydomain:" + mydomain);

        userService.testBatchInsertUser();



    }
}
