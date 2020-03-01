package com.example.demo.service;

import com.example.demo.domain.entity.Customer;
import com.example.demo.exception.NotExistException;
import com.example.demo.request.customer.CreateRequest;
import com.example.demo.request.customer.UpdateRequest;
import io.ebean.annotation.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    public List<Customer> findAll() {
        return Customer.find.all();
    }

    public Customer getWithLock(Long id) {
        return Customer.find.query()
                .forUpdate()
                .where()
                .eq("id", id)
                .findOne();
    }

    @Transactional
    public Customer create(CreateRequest params) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(params, customer);

        customer.save();

        return customer;
    }

    @Transactional
    public Customer update(Long id, UpdateRequest params) throws NotExistException {
        Customer customer = getWithLock(id);

        if (customer == null) {
            throw new NotExistException(String.format("No customer exists(id = %d)", id));
        }

        BeanUtils.copyProperties(params, customer);
        customer.update();

        return customer;
    }

    public void delete(Long id) {
        Customer customer = getWithLock(id);

        if (customer == null) {
            throw new NotExistException(String.format("No customer exists(id = %d)", id));
        }

        customer.delete();
    }
}
