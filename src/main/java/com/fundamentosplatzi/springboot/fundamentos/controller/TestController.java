package com.fundamentosplatzi.springboot.fundamentos.controller;

import com.fundamentosplatzi.springboot.fundamentos.configuration.MyConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private MyConfigurationProperties prop;

    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>("Hello From Controller: " + prop.getName() + " " + prop.getLastName(), HttpStatus.OK);
    }
}
