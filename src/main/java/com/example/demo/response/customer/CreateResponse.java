package com.example.demo.response.customer;

import com.example.demo.domain.bean.Item;
import com.example.demo.domain.entity.Customer;
import com.example.demo.response.Response;

public class CreateResponse extends Response {

    public CreateResponse(Customer customer) {
        Item item = new Item();
        item.put("id", customer.getId());
        item.put("name", customer.getName());
        put("item", item);
    }
}
