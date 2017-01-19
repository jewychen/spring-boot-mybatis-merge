package org.monkey.support;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by monkey on 2017/1/5.
 */
public class DaoSupport<T> {

    private static Logger logger = LoggerFactory.getLogger(DaoSupport.class);

    @Resource
    @Qualifier("firstSqlSessionTemplate")
    protected SqlSession firstSqlSession;

    @Resource
    @Qualifier("gpSqlSessionTemplate")
    protected SqlSession gpSqlSession;

    public void getSqlSession(SqlSession sqlSession){
        System.out.println("sqlSession: -------------" + sqlSession);
    }

    protected T selectOne(SqlSession sqlSession,String statement,Object parameter){

        return sqlSession.selectOne(statement,parameter);
    }


}
