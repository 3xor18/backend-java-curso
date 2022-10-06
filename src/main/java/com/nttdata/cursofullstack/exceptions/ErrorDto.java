package com.nttdata.cursofullstack.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorDto {

    private String name;
    private String value;
}