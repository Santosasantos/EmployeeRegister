package com.bractit.employeeregister.employeemodule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String fullName;
    private String pin;
    private String employeeCategory;
    private String employeeJobStatus;
    private String employeeStatus;
    private String domainStatus;
    private String hrStatus;

    // Constructor to map from Employee entity to DTO
    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.fullName=employee.getFullName();
        this.pin = employee.getPin();
        this.employeeCategory = employee.getEmployee_Category();
        this.employeeJobStatus = employee.getEmployee_Job_Status();
        this.employeeStatus = employee.getEmployee_Status();
        this.domainStatus = employee.getDomain_Status();
        this.hrStatus = employee.getHr_Status();
    }
}
