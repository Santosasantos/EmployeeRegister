package com.bractit.employeeregister.service;

import com.bractit.employeeregister.employeemodule.Employee;
import com.bractit.employeeregister.employeemodule.EmployeeDTO;
import com.bractit.employeeregister.employeemodule.EmployeeMapper;
import com.bractit.employeeregister.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;
    @Autowired
    public EmployeeServiceImplementation(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository){
        this.employeeMapper=employeeMapper;
        this.employeeRepository=employeeRepository;
    }

    //Create Operation
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toEmployeeDTO(savedEmployee);
    }

    //READ Operation
    @Override
    public EmployeeDTO getEmployeeById(Long employeeid) throws ResolutionException {
        Employee response=employeeRepository.findById(employeeid)
                .orElseThrow(()-> new ResolutionException("The following id with this "+employeeid+" id is not found"));
        return EmployeeMapper.toEmployeeDTO(response);
    }

    //READ-All Operation
    @Override
    public List<EmployeeDTO> getAllEmployeeInfo() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map(employee -> EmployeeMapper.toEmployeeDTO(employee))
                .collect(Collectors.toList());
    }
    //UPDATE Operation
    @Override
    public EmployeeDTO updateEmployeeInfo(Long employeeid, EmployeeDTO updatedinfo) {
       Employee employee=employeeRepository.findById(employeeid)
               .orElseThrow(()-> new ResolutionException("The following id with this "+employeeid+" id is not found"));
       if(updatedinfo.getFullName()!= null){
           employee.setFullName(updatedinfo.getFullName());
       }
       if(updatedinfo.getPin()!=null){
           employee.setPin(updatedinfo.getPin());
       }
       if(updatedinfo.getEmployeeCategory()!=null){
           employee.setEmployee_Category(updatedinfo.getEmployeeCategory());
       }
       if(updatedinfo.getEmployeeJobStatus()!=null){
           employee.setEmployee_Job_Status(updatedinfo.getEmployeeJobStatus());
       }
       if(updatedinfo.getEmployeeStatus()!=null){
           employee.setEmployee_Status(updatedinfo.getEmployeeStatus());
       }
       if(updatedinfo.getDomainStatus()!=null){
           employee.setDomain_Status(updatedinfo.getDomainStatus());
       }
       if(updatedinfo.getHrStatus()!=null){
           employee.setHr_Status(updatedinfo.getHrStatus());
       }

        // Update domainStatus and hrStatus if employeeJobStatus is "Resignation"
        if ("Resignation".equals(updatedinfo.getEmployeeJobStatus())) {
            employee.setDomain_Status("Inactive");
            employee.setHr_Status("Rejected");
        }
        Employee updatedemp=employeeRepository.save(employee);
        return EmployeeMapper.toEmployeeDTO(updatedemp);
    }

    //DELETE Operations
    @Override
    public void deleteEmployeeInfo(Long employeeId) throws ResolutionException {
        Employee employeeToDelete = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResolutionException("Employee with ID " + employeeId + " not found"));

        // Store current values of other fields
//        String fullName = employeeToDelete.getFullName();
//        String pin = employeeToDelete.getPin();
        // Store values of other fields similarly...

        // Update specific fields before deletion
        employeeToDelete.setDomain_Status("Inactive");
        employeeToDelete.setEmployee_Category("Unknown");
        employeeToDelete.setEmployee_Job_Status("Resignation");
        employeeToDelete.setEmployee_Status("NonConfirm");
        employeeToDelete.setHr_Status("Rejected");

        // Save updated employee entity
        Employee updatedEmployee = employeeRepository.save(employeeToDelete);

//        // Restore previous values of other fields
//        updatedEmployee.setFullName(fullName);
//        updatedEmployee.setPin(pin);
        // Restore values of other fields similarly...

        // Map updated employee entity to DTO and return
        EmployeeMapper.toEmployeeDTO(updatedEmployee);

    }
}
