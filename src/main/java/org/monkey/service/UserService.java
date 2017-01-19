package org.monkey.service;

import org.monkey.dao.MysqlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by monkey on 2017/1/6.
 */
@Service
public class UserService {

    @Autowired
    private MysqlDao firstDao;


    public String getUserByName(String name){
        return firstDao.getUserByName(name);
    }

    public void testBatchInsertUser(){
        firstDao.testBatchInsert();
    }


}
