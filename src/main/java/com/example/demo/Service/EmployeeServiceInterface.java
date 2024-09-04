package com.example.demo.Service;

import com.example.demo.employee.Employee;

import java.util.Map;

public interface EmployeeServiceInterface {
    Employee addEmployee(String firstName, String lastName);
    Employee deleteEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Map<String, EmployeeCustom> getEmployees();
}