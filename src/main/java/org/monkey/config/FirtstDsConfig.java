package org.monkey.config;

import org.apache.ibatis.session.ExecutorType;
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
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by monkey on 2017/1/5.
 */
@Configuration
@MapperScan(basePackages = "org.monkey.mapper.mysql", sqlSessionTemplateRef = FirtstDsConfig.FIRST_SQL_SESSION_TEMPLATE)
//@MapperScan(basePackages = "org.monkey.mapper.mysql", sqlSessionTemplateRef = FirtstDsConfig.FIRST_BATCH_SQL_SESSION_TEMPLATE)
public class FirtstDsConfig {

    public static final String FIRST_SQL_SESSION_TEMPLATE = "firstSqlSessionTemplate";
    public static final String FIRST_BATCH_SQL_SESSION_TEMPLATE = "firstBatchSqlSessionTemplate";

    private Logger logger = LoggerFactory.getLogger(FirtstDsConfig.class);

    //rdbms JdbcTemplate
    @ConfigurationProperties(prefix = "datasource.first")
    @Bean(name="firstDs")
    @Primary
    public DataSource rdbmsDataSource() {
        logger.info("-------------------- 初始化 jdbcDataSource --------------------");
        return DataSourceBuilder.create().build();
    }

    @Bean(name="firstSqlSessionFactory")
    @Primary
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier(value="firstDs") DataSource firstDatasource)throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(firstDatasource);
//        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mapper/mybatis-config.xml"));

        return bean.getObject();
    }

    @Bean(name = FirtstDsConfig.FIRST_SQL_SESSION_TEMPLATE)
    @Primary
    public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

//    @Bean(name = FirtstDsConfig.FIRST_BATCH_SQL_SESSION_TEMPLATE)
//    @Primary
//    public SqlSessionTemplate firstBatchSqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
//
//    }


}
