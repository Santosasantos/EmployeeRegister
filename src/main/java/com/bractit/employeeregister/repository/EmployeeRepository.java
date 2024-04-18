package com.bractit.employeeregister.repository;

import com.bractit.employeeregister.employeemodule.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
