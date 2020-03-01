package com.example.demo.domain.entity;

import io.ebean.Finder;
import io.ebean.Model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customer")
public class Customer extends Model {

    @Id
    private Long id;

    private String name;

    public static final Finder<Long, Customer> find = new Finder<>(Customer.class);
}
