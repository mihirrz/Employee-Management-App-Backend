package com.mihir.EMA.Controller;

import com.mihir.EMA.DTO.EmployeeDTO;
import com.mihir.EMA.Entity.Employee;
import com.mihir.EMA.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Signup endpoint for creating a new employee
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        // Validate the input DTO
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Invalid employee data", HttpStatus.BAD_REQUEST);
        }

        try {
            // Call service to create and save the employee
            employeeService.createAndSaveEmployee(employeeDTO);
            return new ResponseEntity<>("Employee created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle any exceptions that may occur
            return new ResponseEntity<>("Error creating employee: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeesList")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

}
