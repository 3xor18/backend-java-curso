package com.nttdata.cursofullstack.exceptions.personalizados;

import com.nttdata.cursofullstack.exceptions.GlobalExceptionApp;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorAlGuardarException  extends GlobalExceptionApp {

    public ErrorAlGuardarException(String mensaje){
        super(HttpStatus.BAD_REQUEST.value(),mensaje);
    }
}
