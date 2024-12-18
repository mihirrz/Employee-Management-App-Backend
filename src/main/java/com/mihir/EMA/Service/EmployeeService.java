package com.mihir.EMA.Service;

import com.mihir.EMA.DTO.EmployeeDTO;
import com.mihir.EMA.Entity.Employee;
import com.mihir.EMA.Repository.EmployeeRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
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

    public void updateEmployee(Long id, EmployeeDTO employeeDTO) {
        // Find the existing employee by ID
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(STR."Employee not found with ID: \{id}"));

        // Update the fields
        existingEmployee.setEmployeeFirstName(employeeDTO.getEmployeeFirstName());
        existingEmployee.setEmployeeLastName(employeeDTO.getEmployeeLastName());
        existingEmployee.setEmployeeContactNumber(employeeDTO.getEmployeeContactNumber());
        existingEmployee.setEmployeeEmail(employeeDTO.getEmployeeEmail());
        existingEmployee.setEmployeeRole(employeeDTO.getEmployeeRole());
        existingEmployee.setEmployeeDesignation(employeeDTO.getEmployeeDesignation());
        existingEmployee.setPassword(employeeDTO.getPassword());

        // Save the updated employee back to the database
        employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        // Check if the employee exists
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Employee not found with ID: %d", id)
                ));

        // Delete the employee
        employeeRepository.delete(existingEmployee);
    }


}
