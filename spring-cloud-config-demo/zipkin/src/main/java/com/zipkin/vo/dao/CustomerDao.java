package com.zipkin.vo.dao;

import com.zipkin.vo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author: movie
 * @Date: 2018/10/14 16:54
 */
public interface CustomerDao extends MongoRepository<Customer, String> {
    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);
}
