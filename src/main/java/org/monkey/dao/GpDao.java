package org.monkey.dao;

import org.monkey.mapper.gp.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by monkey on 2017/1/6.
 */
@Repository
public class GpDao {


    @Autowired
    public PersonMapper domainMapper;


    public String getDomainById(int id){

        return domainMapper.getMydomain(id).toString();
    }

}
