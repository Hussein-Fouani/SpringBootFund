package com.hf.springbootfund.Service;

import com.hf.springbootfund.entity.Employee;
import com.hf.springbootfund.repositories.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceJPA implements EmployeeService {


    private EmployeeRepo employeeRepo;


    @Override
    public List<Employee> listAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void deleteall() {
        employeeRepo.deleteAll();
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        Employee employee1 = null;
        if (employee.isPresent()) {
            employee1 = employee.get();
        }
        return employee1;

    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void DeleteById(Integer id) {
        employeeRepo.deleteById(id);
    }
}
