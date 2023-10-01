package com.hf.springbootfund.Service;

import com.hf.springbootfund.entity.Employee;
import com.hf.springbootfund.repositories.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceJPA implements EmployeeService {
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> listAllEmployees() {
        return employeeRepo.findAll();
    }
}
