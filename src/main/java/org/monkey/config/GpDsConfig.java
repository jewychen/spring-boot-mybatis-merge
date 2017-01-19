package org.monkey.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by monkey on 2017/1/6.
 */

@Configuration
@MapperScan(basePackages = "org.monkey.mapper.gp", sqlSessionTemplateRef = "gpSqlSessionTemplate")
public class GpDsConfig {

    private Logger logger = LoggerFactory.getLogger(GpDsConfig.class);
    @ConfigurationProperties(prefix = "datasource.gp")
    @Bean(name = "gpDs")
    public DataSource gpDataSource(){
        logger.info("-------------------- 初始化   gpDataSource --------------------");

        return DataSourceBuilder.create().build();
    }

    @Bean(name = "gpSqlSessionFactory")
    public SqlSessionFactory gpSqlSessionFactory(@Qualifier(value = "gpDs") DataSource gpDs) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(gpDs);

        return bean.getObject();
    }

    @Bean(name = "gpSqlSessionTemplate")
    public SqlSessionTemplate gpSqlSessionTemplate(@Qualifier(value  = "gpSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
