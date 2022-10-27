package com.fundamentosplatzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImpl implements ComponentDependency{
    @Override
    public void helloWorld() {
        System.out.println("Hello world from my component");
    }
}
