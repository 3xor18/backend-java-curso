package com.nttdata.cursofullstack.exceptions.personalizados;

import com.nttdata.cursofullstack.exceptions.GlobalExceptionApp;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorInternoException  extends GlobalExceptionApp {

    public ErrorInternoException(String mensaje){
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(),mensaje);
    }
}
