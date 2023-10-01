package com.hf.springbootfund.model;


import com.hf.springbootfund.Service.EmployeeServiceJPA;
import com.hf.springbootfund.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeServiceJPA serviceJPA;

    @GetMapping("/employees")
    public List<Employee> listemployees() {
        return serviceJPA.listAllEmployees();
    }

}
