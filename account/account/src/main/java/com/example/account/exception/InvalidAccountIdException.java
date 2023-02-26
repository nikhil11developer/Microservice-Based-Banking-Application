package com.example.account.exception;

public class InvalidAccountIdException  extends Exception {
     private String message;
     
     public InvalidAccountIdException(String message) {this.message=message;}
     
     public String getMessage() {return this.message;}
}
