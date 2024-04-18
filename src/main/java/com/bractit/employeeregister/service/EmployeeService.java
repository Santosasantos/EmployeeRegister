package com.bractit.employeeregister.service;

import com.bractit.employeeregister.employeemodule.EmployeeDTO;

import java.lang.module.ResolutionException;
import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long employeeid) throws ResolutionException;
    List<EmployeeDTO> getAllEmployeeInfo();
    EmployeeDTO updateEmployeeInfo(Long employeeid, EmployeeDTO updatedinfo);
    void deleteEmployeeInfo(Long employeeid) throws ResolutionException;
}
