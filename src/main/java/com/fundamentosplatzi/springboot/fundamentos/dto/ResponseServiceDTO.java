package com.fundamentosplatzi.springboot.fundamentos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseServiceDTO {

    private String code;
    private String message;
    private String detail;
    private Object data;

}
