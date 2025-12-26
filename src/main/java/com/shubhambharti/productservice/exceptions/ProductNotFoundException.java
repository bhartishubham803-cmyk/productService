package com.shubhambharti.productservice.exceptions;

public class ProductNotFoundException extends Exception{

        /*
            Exception types:-
            1. Compile / Checked Exception = needs to be handled
            Throwable
            Exception
            RunTimeException

            2. Runtime / Unchecked Exception
     */
    public ProductNotFoundException(String message) {
        super(message);
    }
}
