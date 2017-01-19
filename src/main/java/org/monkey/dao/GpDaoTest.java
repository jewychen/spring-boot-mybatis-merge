package org.monkey.dao;

import org.apache.ibatis.session.SqlSession;
import org.monkey.mapper.gp.DomainMapper;
import org.monkey.support.DaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by monkey on 2017/1/6.
 */
@Repository
public class GpDaoTest{

//    @Resource
//    @Qualifier("gpSqlSessionTemplate")
//    protected SqlSession gpSqlSession;

    @Autowired
    public DomainMapper domainMapper;

//    public String getDomainById(int id){
//        return domainMapper.getMydomain(id).toString();
//    }

    public String getDomainById(int id){
//        return (String)gpSqlSession.selectOne(gpSqlSession, domainMapper.getMydomain(id).toString());

        return domainMapper.getMydomain(id).toString();
    }

}
