package com.example.demo.Service;

import com.example.demo.exception.EmployeeAlreadyAddedException;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final Map<String, EmployeeCustom> employeesBook = new HashMap<>(Map.of());
    private int maxEmployees = Integer.MAX_VALUE;

    public EmployeeService() {
        demoFill();
    }

    public void demoFill() {
        employeesBook.clear();
        addEmployee("Константинов", "Игнатий");
        addEmployee("Осип", "Михеев");
        addEmployee("Казимир", "Попов");
        addEmployee("Гордей", "Лихачёв");
        addEmployee("Антон", "Тимофеев");
        addEmployee("Никифор", "Хохлов");
        addEmployee("Валерий", "Молчанов");
        addEmployee("Роман", "Мышкин");
        addEmployee("Адольф", "Лаврентьев");
        addEmployee("Юлий", "Ерфремов");
        setMaxEmployees(10);
    }

    public Map<String, EmployeeCustom> getEmployees() {
        return employeesBook;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) {
        if (employeesBook.size() > maxEmployees) throw new EmployeeStorageIsFullException();
        this.maxEmployees = maxEmployees;
    }

    @Override
    public EmployeeCustom addEmployee(String firstName, String lastName) {
        if (employeesBook.size() >= maxEmployees) throw new EmployeeStorageIsFullException();
        try {
            findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            EmployeeCustom employee = new EmployeeCustom(firstName, lastName);
            employeesBook.put(employee.id(),employee);
            return employee;
        }
        throw new EmployeeAlreadyAddedException();
    }

    @Override
    public EmployeeCustom deleteEmployee(String firstName, String lastName) {
        EmployeeCustom employee = findEmployee(firstName,lastName);
        employeesBook.remove(employee.id());
        return employee;
    }

    @Override
    public EmployeeCustom findEmployee(String firstName, String lastName) {
        String id = new EmployeeCustom(firstName, lastName).id();
        if(employeesBook.containsKey(id) )
        {
            return employeesBook.get(id);
        }
        throw new EmployeeNotFoundException();
    }
}