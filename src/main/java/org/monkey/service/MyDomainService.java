package org.monkey.service;

import org.monkey.dao.GpDaoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by monkey on 2017/1/6.
 */
@Service
public class MyDomainService {

    @Autowired
    public GpDaoTest gpDaoTest;

    public String getDomainById(int id){
        return gpDaoTest.getDomainById(id);
    }
}
