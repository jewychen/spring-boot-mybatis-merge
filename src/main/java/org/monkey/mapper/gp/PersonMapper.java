package org.monkey.mapper.gp;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.monkey.domain.Person;

/**
 * Created by monkey on 2017/1/6.
 */
@Mapper
public interface PersonMapper {

    @Select("select * from cjh_test_person where id = #{id}")
    Person getMydomain(@Param("id") int id);
}
