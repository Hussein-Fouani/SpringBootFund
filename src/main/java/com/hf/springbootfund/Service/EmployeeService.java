package com.hf.springbootfund.Service;

import com.hf.springbootfund.entity.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> listAllEmployees();

    void deleteall();

    Employee findEmployeeById(Integer id);

    Employee save(Employee employee);

    void DeleteById(Integer id);
}
