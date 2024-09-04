package com.example.demo.Service;

import com.example.demo.employee.Employee;

public class EmployeeCustom extends Employee implements EmployeeInterface {

    public EmployeeCustom(String firstName, String lastName) {
        super(firstName, lastName);
        if (!(firstName != null && lastName !=  null && !firstName.isBlank() && !lastName.isBlank())) {
            throw new RuntimeException("Имя и фамилия должны быть заполнены!");
        }
    }

    public EmployeeCustom() {
        super(null,null);
        throw new RuntimeException("Используйте имя и фамилию в параметрах!");
    }


    public String id() {
        return (getFirstName() + getLastName()).toLowerCase();
    }
    @Override
    public void setFirstName(String firstName) {
        if (getFirstName() == null) {
            super.setFirstName(firstName);
        } else {
            throw new RuntimeException("Нельзя менять имя в этом проекте!");
        }
    }
    @Override
    public void setLastName(String lastName) {
        if (getLastName() == null) {
            super.setLastName(lastName);
        } else {
            throw new RuntimeException("Нельзя менять фамилию в этом проекте!");
        }
    }
}