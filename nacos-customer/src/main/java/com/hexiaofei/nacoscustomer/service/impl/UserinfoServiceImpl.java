package com.hexiaofei.nacoscustomer.service.impl;

import com.hexiaofei.nacoscustomer.dao.IUserinfoDao;
import com.hexiaofei.nacoscustomer.service.IUserinfoService;
import com.hexiaofei.pubapi.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lcyj
 * @date 2021-12-19 11:37
 * @since
 */
@Slf4j
@Service
public class UserinfoServiceImpl implements IUserinfoService {

    @Autowired
    private IUserinfoDao userinfoDao;

    @Override
    public int addObject(UserInfo userInfo) {
        return userinfoDao.insertObject(userInfo);
    }

    /**
     *
     * @param userinfoList
     * @return
     */
    @Override
    public List<UserInfo> addBatchObject(List<UserInfo> userinfoList) {
        long start = System.currentTimeMillis();
        boolean resout = userinfoDao.insertList(userinfoList);
        log.info("耗时： "+(System.currentTimeMillis()-start));
        return null;
    }

    @Override
    public int deleteObjectById(Integer id) {
        return 0;
    }

    @Override
    public int updateObjectById(Integer id) {
        return 0;
    }

    @Override
    public UserInfo getObjectById(Integer id) {
        return null;
    }

    @Override
    public com.hexiaofei.pubapi.entity.PageVo getListByPageVo(com.hexiaofei.pubapi.entity.PageVo pageVo, Map<String, Object> paraMap) {
        return null;
    }

}
