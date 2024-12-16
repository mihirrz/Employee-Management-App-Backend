package com.mihir.EMA.Service;

import com.mihir.EMA.DTO.EmployeeDTO;
import com.mihir.EMA.Entity.Employee;
import com.mihir.EMA.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createAndSaveEmployee(EmployeeDTO employeeDTO)
    {
        Employee employee = new Employee();

        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setEmployeeFirstName(employeeDTO.getEmployeeFirstName());
        employee.setEmployeeLastName(employeeDTO.getEmployeeLastName());
        employee.setEmployeeContactNumber(employeeDTO.getEmployeeContactNumber());
        employee.setEmployeeEmail(employeeDTO.getEmployeeEmail());
        employee.setEmployeeRole(employeeDTO.getEmployeeRole());
        employee.setEmployeeDesignation(employeeDTO.getEmployeeDesignation());

        employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword())); // Hashing the password

        employeeRepository.save(employee);
    }

public List<EmployeeDTO> getAllEmployees() {
    return employeeRepository.findAll().stream()
            .map(employee -> new EmployeeDTO(
                    employee.getEmployeeId(),
                    employee.getEmployeeFirstName(),
                    employee.getEmployeeLastName(),
                    employee.getEmployeeContactNumber(),
                    employee.getEmployeeEmail(),
                    employee.getEmployeeRole(),
                    employee.getEmployeeDesignation(),
                    employee.getPassword()))
            .collect(Collectors.toList());
}

}
