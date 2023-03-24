package com.chj.model;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Appuser implements Serializable {

    private Long id;

    private String name;

    private String email;


    private String phone;

    private int gender;

    private String password;
    private int age;

}