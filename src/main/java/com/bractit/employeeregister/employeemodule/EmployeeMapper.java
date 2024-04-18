package com.bractit.employeeregister.employeemodule;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public static EmployeeDTO toEmployeeDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setFullName(employee.getFullName());
        dto.setPin(employee.getPin());
        dto.setEmployeeCategory(employee.getEmployee_Category());
        dto.setEmployeeJobStatus(employee.getEmployee_Job_Status());
        dto.setEmployeeStatus(employee.getEmployee_Status());
        dto.setDomainStatus(employee.getDomain_Status());
        dto.setHrStatus(employee.getHr_Status());
        return dto;
    }

    public static Employee toEmployee(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setFullName(dto.getFullName());
        employee.setPin(dto.getPin());
        employee.setEmployee_Category(dto.getEmployeeCategory());
        employee.setEmployee_Job_Status(dto.getEmployeeJobStatus());
        employee.setEmployee_Status(dto.getEmployeeStatus());
        employee.setDomain_Status(dto.getDomainStatus());
        employee.setHr_Status(dto.getHrStatus());
        return employee;
    }
}
