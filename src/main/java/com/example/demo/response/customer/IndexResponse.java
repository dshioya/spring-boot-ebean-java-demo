package com.example.demo.response.customer;

import com.example.demo.domain.bean.Item;
import com.example.demo.domain.entity.Customer;
import com.example.demo.response.Response;

import java.util.List;
import java.util.stream.Collectors;

public class IndexResponse extends Response {

    public IndexResponse(List<Customer> customerList) {
        put("items", customerList.stream().map(customer -> {
            Item item = new Item();
            item.put("id", customer.getId());
            item.put("name", customer.getName());
            return item;
        }).collect(Collectors.toList()));
    }
}
