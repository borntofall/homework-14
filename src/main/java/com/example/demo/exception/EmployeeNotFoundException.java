package com.example.demo.exception;


public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("EmployeeNotFound");
    }
}