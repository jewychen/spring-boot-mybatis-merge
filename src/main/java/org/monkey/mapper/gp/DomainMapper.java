package org.monkey.mapper.gp;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.monkey.domain.MyDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by monkey on 2017/1/6.
 */
@Mapper
public interface DomainMapper {


    @Select("select * from cjh_test_mybatis where id = #{id}")
    MyDomain getMydomain(@Param("id") int id);
}
