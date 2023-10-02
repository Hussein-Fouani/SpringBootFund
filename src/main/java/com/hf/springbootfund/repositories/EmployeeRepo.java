package com.hf.springbootfund.repositories;

import com.hf.springbootfund.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
