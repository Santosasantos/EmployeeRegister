package com.bractit.employeeregister.employeemodule;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String fullName;
    @Column(name = "pin")
    private String pin;
    @Column(name = "employee_category")
    private String employee_Category;
    @Column(name = "employee_job_status")
    private String employee_Job_Status;
    @Column(name = "employee_status")
    private String employee_Status;
    @Column(name = "domain_status")
    private String domain_Status;
    @Column(name = "hr_status")
    private String hr_Status;

}
