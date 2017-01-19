package org.monkey.config;

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

import javax.sql.DataSource;

/**
 * Created by monkey on 2017/1/5.
 */
@Configuration
@MapperScan(basePackages = "org.monkey.mapper.mysql", sqlSessionTemplateRef = MysqlDsConfig.MYSQL_SQL_SESSION_TEMPLATE)
public class MysqlDsConfig {

    public static final String MYSQL_SQL_SESSION_TEMPLATE = "mysqlSqlSessionTemplate";
//    public static final String mysql_BATCH_SQL_SESSION_TEMPLATE = "mysqlBatchSqlSessionTemplate"; //--testing, not working yet

    private Logger logger = LoggerFactory.getLogger(MysqlDsConfig.class);

    //mysql JdbcTemplate
    @ConfigurationProperties(prefix = "datasource.mysql")
    @Bean(name="mysqlDs")
    @Primary //----!! It's very important to add @Primary on one of the datasources!-----------
    public DataSource mysqlDataSource() {
        logger.info("-------------------- Initializing jdbcDataSource --------------------");
        return DataSourceBuilder.create().build();
    }

    @Bean(name="mysqlSqlSessionFactory")
    @Primary
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier(value="mysqlDs") DataSource mysqlDatasource)throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(mysqlDatasource);
        // if you want to configure mybatis by the XML way.
//        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mapper/mybatis-config.xml"));

        return bean.getObject();
    }

    @Bean(name = MysqlDsConfig.MYSQL_SQL_SESSION_TEMPLATE)
    @Primary
    public SqlSessionTemplate mysqlSqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

//    @Bean(name = FirtstDsConfig.mysql_BATCH_SQL_SESSION_TEMPLATE)
//    @Primary
//    public SqlSessionTemplate mysqlBatchSqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
//
//    }


}
