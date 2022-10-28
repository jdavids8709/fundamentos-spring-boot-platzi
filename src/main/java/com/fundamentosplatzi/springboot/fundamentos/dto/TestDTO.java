package com.fundamentosplatzi.springboot.fundamentos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "testdto")
@ConstructorBinding
@Getter
@Setter
@AllArgsConstructor
@ToString
public class TestDTO {
    private String name;
    private String lastName;
    private String email;
}
