package com.example.jpa_demo.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.persistence.SecondaryTable;

@Getter
@Setter
public class ResponseDto<T> {

    T data;
    HttpStatus httpStatus;

    public ResponseDto(T data, HttpStatus httpStatus) {
        this.data = data;
        this.httpStatus = httpStatus;
    }
}
