package com.example.demo.controller;

import com.example.demo.domain.entity.Customer;
import com.example.demo.request.customer.CreateRequest;
import com.example.demo.request.customer.UpdateRequest;
import com.example.demo.response.customer.CreateResponse;
import com.example.demo.response.customer.IndexResponse;
import com.example.demo.response.customer.UpdateResponse;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public IndexResponse index() {
        List<Customer> customerList = customerService.findAll();

        return new IndexResponse(customerList);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody @Valid CreateRequest params,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return badRequest(bindingResult.getFieldErrors());
        }

        Customer customer = customerService.create(params);

        return new ResponseEntity(new CreateResponse(customer), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable("id") Long id,
                                 @RequestBody @Valid UpdateRequest params,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return badRequest(bindingResult.getFieldErrors());
        }

        Customer customer = customerService.update(id, params);

        return new ResponseEntity(new UpdateResponse(customer), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        customerService.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
