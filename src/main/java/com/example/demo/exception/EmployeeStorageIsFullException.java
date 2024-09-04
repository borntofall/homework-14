package com.example.demo.exception;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("ArrayIsFull");
    }
}