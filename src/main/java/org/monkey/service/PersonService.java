package org.monkey.service;

import org.monkey.dao.GpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by monkey on 2017/1/6.
 */
@Service
public class PersonService {

    @Autowired
    public GpDao gpDao;

    public String getPersonNameById(int id){
        return gpDao.getDomainById(id);
    }
}
