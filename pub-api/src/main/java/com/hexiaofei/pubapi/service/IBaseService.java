package com.hexiaofei.pubapi.service;


import com.hexiaofei.pubapi.entity.PageVo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/13.
 */
public interface IBaseService<T> {

    int addObject(T t);

    List<T> addBatchObject(List<T> t);

    int deleteObjectById(Integer id);

    int updateObjectById(Integer id);

    T getObjectById(Integer id);

    PageVo getListByPageVo(PageVo pageVo, Map<String, Object> paraMap);
}
