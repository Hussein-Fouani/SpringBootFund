package com.hf.springbootfund.repositories;

import com.hf.springbootfund.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  EmployeeRepo extends JpaRepository<Employee,Integer> {
}
