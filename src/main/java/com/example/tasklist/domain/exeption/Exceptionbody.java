package com.example.tasklist.domain.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Exceptionbody {

    private String message;
    private Map<String, String> errors;

    public Exceptionbody(String message){
        this.message = message;
    }

}
