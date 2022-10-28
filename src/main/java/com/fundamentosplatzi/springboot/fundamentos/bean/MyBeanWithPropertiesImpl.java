package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImpl implements MyBeanWithProperties{

    private String name;
    private String lastName;

    public MyBeanWithPropertiesImpl(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String load() {
        return name +"-"+ lastName;
    }
}
