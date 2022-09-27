package com.hexiaofei.nacoscustomer.service.impl;

import com.hexiaofei.nacoscustomer.dao.mapper.EmployeesMapper;
import com.hexiaofei.nacoscustomer.service.IEmployeesService;
import com.hexiaofei.pubapi.entity.Employees;
import com.lcyj.common.vo.PageVo;
import com.lcyj.exception.PlatformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lcyj
 * @date 2021-12-19 11:50
 * @since
 */
@Service
public class EmployeesServiceImpl implements IEmployeesService {

    @Autowired
    EmployeesMapper employeesMapper;

    @Override
    public int addObject(Employees employees) throws PlatformException {

        employeesMapper.insert(employees);

        return 0;
    }

    @Override
    public int deleteObjectById(int i) throws PlatformException {
        return 0;
    }

    @Override
    public int updateObject(Employees employees) throws PlatformException {
        return 0;
    }

    @Override
    public Employees getObjectById(int i) throws PlatformException {
        return null;
    }

    @Override
    public PageVo<Employees> getPageVoObject(PageVo<Employees> pageVo) throws PlatformException {
        return null;
    }

    @Override
    public List<Employees> getAllObject() throws PlatformException {
        return null;
    }
}
