package com.nttdata.cursofullstack.exceptions;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GlobalExceptionApp extends Exception {

    private  final int responseCode;

    private final List<ErrorDto> errorDtoList=new ArrayList<>();

    public GlobalExceptionApp(int responseCode, String message){
        super(message);
        this.responseCode=responseCode;
    }
}