package com.hexiaofei.nacoscustomer.service.impl;

import com.hexiaofei.nacoscustomer.service.IEmployeesService;
import com.hexiaofei.pubapi.entity.Employees;
import com.lcyj.exception.PlatformException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesServiceImplTest {

    @Autowired
    private IEmployeesService employeesService;

    private final static String F_NAME = "ZHANG";
    private final static String L_NAME = "SAN";
    private final static int TC = 5;

    @Test
    public void addObject() throws InterruptedException {

        CountDownLatch cd = new CountDownLatch(TC);

        ExecutorService es = Executors.newFixedThreadPool(TC);
        for(int i=1611543 ; i< 1711543 ; i++) {
            Employees employees = new Employees();
            employees.setId(i);
            employees.setFname(F_NAME + ":" + i);
            employees.setLname(L_NAME);
            employees.setJob_code(100);
            employees.setHired(new Date());
            employees.setSeparated(new Date());
            employees.setStore_id(i % 21);

            es.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        employeesService.addObject(employees);
                    } catch (PlatformException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        TimeUnit.SECONDS.sleep(2000);


    }
}