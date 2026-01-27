package com.example.ecom.exception;

/* the purpose of creating this class is you are going to create a domain specific signal
    that a product with requested id does not exist.

* */

// Runtime Exception (Unchecked Exception)
/*  Why extend RuntimeException?
   the moment u do it, marks it an unchecked exception.
    benefit -> Callers are not forced to declare or catch it.
* */


/*
You are taking a constructor (ProductNotFoundException) and you are passing
whatever exception you got in the message to RuntimeException Base so getMessage() returns it and
returns it's stack trace
*/
public class ProductNotFoundException extends  RuntimeException{

    public ProductNotFoundException(String message) {
        super(message);
    }
}

// then go to the Controller folder and add @ExceptionHandler at the Bottom
// does not work cross controller


