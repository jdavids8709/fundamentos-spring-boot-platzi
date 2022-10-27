package com.fundamentosplatzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImpl implements ComponentDependency{

    @Override
    public void helloWorld() {
        System.out.println("Hello world from my component two");
    }
}
