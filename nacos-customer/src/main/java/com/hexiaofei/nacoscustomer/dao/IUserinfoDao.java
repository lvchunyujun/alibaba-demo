package com.hexiaofei.nacoscustomer.dao;

import com.hexiaofei.pubapi.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lcyj
 * @date 2022-04-17 17:20
 * @since
 */
@Mapper
@Repository
public interface IUserinfoDao {

    Integer insertObject(UserInfo userInfo);

    boolean insertList(List<UserInfo> list);
}
