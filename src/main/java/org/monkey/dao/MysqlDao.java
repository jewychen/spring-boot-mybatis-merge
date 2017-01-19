package org.monkey.dao;

import org.monkey.domain.User;
import org.monkey.mapper.mysql.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by monkey on 2017/1/5.
 */
@Repository
public class MysqlDao {

    private Logger logger = LoggerFactory.getLogger(MysqlDao.class);

    @Autowired
    public UserMapper userMapper;

    public String getUserByName(String name){
        User user = userMapper.findByUsername(name);

        return user.toString();
    }

    public void testBatchInsert(){
        List<User> userList = new ArrayList<User>();
        for(int i=1; i<=5; i++){
            User user = new User();
            user.setId((long)i);
            user.setUsername("usr" + i);
            user.setPassword("ssss" + i);
            userList.add(user);
        }

        long startTime = System.currentTimeMillis();

        //Executor.BATCH 效率测试

//        userList.forEach( userObj -> {
//            userMapper.insertUser(userObj.getId(), userObj.getUsername(), userObj.getPassword());
//        });

        userMapper.insertUser(userList);

        logger.info("Before Batch Insert .......................");

//        userMapper.flush();

        long endTime = System.currentTimeMillis();

        System.out.println(String.format("执行时间 [%d] ms" , endTime - startTime) );


    }

}
