package com.hexiaofei.nacoscustomer.dao.mapper;

import com.hexiaofei.pubapi.entity.UserPartion;
import com.hexiaofei.pubapi.entity.UserPartionExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPartionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_partion
     *
     * @mbggenerated Sun Dec 19 11:11:43 CST 2021
     */
    @SelectProvider(type=UserPartionSqlProvider.class, method="countByExample")
    int countByExample(UserPartionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_partion
     *
     * @mbggenerated Sun Dec 19 11:11:43 CST 2021
     */
    @DeleteProvider(type=UserPartionSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserPartionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_partion
     *
     * @mbggenerated Sun Dec 19 11:11:43 CST 2021
     */
    @Insert({
        "insert into user_partion (id, name, ",
        "age, passwd)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER}, #{passwd,jdbcType=VARCHAR})"
    })
    int insert(UserPartion record);



    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_partion
     *
     * @mbggenerated Sun Dec 19 11:11:43 CST 2021
     */
    @InsertProvider(type=UserPartionSqlProvider.class, method="insertSelective")
    int insertSelective(UserPartion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_partion
     *
     * @mbggenerated Sun Dec 19 11:11:43 CST 2021
     */
    @SelectProvider(type=UserPartionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="passwd", property="passwd", jdbcType=JdbcType.VARCHAR)
    })
    List<UserPartion> selectByExample(UserPartionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_partion
     *
     * @mbggenerated Sun Dec 19 11:11:43 CST 2021
     */
    @UpdateProvider(type=UserPartionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserPartion record, @Param("example") UserPartionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_partion
     *
     * @mbggenerated Sun Dec 19 11:11:43 CST 2021
     */
    @UpdateProvider(type=UserPartionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserPartion record, @Param("example") UserPartionExample example);
}