package com.example.demo.request.customer;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UpdateRequest {

    @NotBlank
    @Size(max = 100)
    private String name;
}
