package com.example.demo.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("EmployeeAlreadyAdded");
    }
}