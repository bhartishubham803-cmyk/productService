package com.shubhambharti.productservice.advice;

import com.shubhambharti.productservice.dtos.ProductNotFoundErrorDTO;
import com.shubhambharti.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundErrorDTO> handleProductNotFoundException(ProductNotFoundException exception) {
        ProductNotFoundErrorDTO errorDto = new ProductNotFoundErrorDTO();
        errorDto.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(404));
    }
}
