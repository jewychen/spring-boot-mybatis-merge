package org.monkey.service;

import org.monkey.dao.FirstDaoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by monkey on 2017/1/6.
 */
@Service
public class UserService {

    @Autowired
    private FirstDaoTest firstDaoTest;


    public String getUserByName(String name){
        return firstDaoTest.getUserByName(name);
    }

    public void testBatchInsertUser(){
        firstDaoTest.testBatchInsert();
    }


}
