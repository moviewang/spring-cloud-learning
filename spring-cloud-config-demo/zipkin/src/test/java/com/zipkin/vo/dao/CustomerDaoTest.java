package com.zipkin.vo.dao;

import com.zipkin.vo.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: movie
 * @Date: 2018/10/14 17:00
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerDaoTest {
    @Resource
    private CustomerDao customerDao;

    @Test
    public void findByFirstName() {
        Customer customer = new Customer("hello", "world");
        customerDao.save(customer);
        Customer hello = customerDao.findByFirstName("hello");
        Assert.assertNotNull(hello);
        System.out.println(hello);
    }

    @Test
    public void findByLastName() {
    }
}