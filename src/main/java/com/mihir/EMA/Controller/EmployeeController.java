package com.mihir.EMA.Controller;

import com.mihir.EMA.DTO.EmployeeDTO;
import com.mihir.EMA.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.mihir.EMA.Response.ApiResponse;
import com.mihir.EMA.Response.ErrorDetails;


import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Endpoint for creating a new employee
    @PostMapping(value = "/createNewEmployee", produces = "application/json")
    public ResponseEntity<ApiResponse<?>> createNewEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ErrorDetails> errorDetails = bindingResult.getFieldErrors().stream()
                    .map(error -> new ErrorDetails(error.getField(), error.getDefaultMessage()))
                    .toList();
            return ResponseEntity.badRequest()
                    .body(ApiResponse.failure("Validation failed", errorDetails));
        }

        employeeService.createAndSaveEmployee(employeeDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Employee created successfully", null));
    }


    @GetMapping("/employeesList")
    public ResponseEntity<ApiResponse<List<EmployeeDTO>>> getAllEmployees() {
        return ResponseEntity.ok(ApiResponse.success("Employees fetched successfully", employeeService.getAllEmployees()));
    }


    @PutMapping(value = "/updateEmployee/{id}", produces = "application/json")
    public ResponseEntity<ApiResponse<?>> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeDTO employeeDTO,
            
            BindingResult bindingResult) {

        if(bindingResult.hasErrors())
        {
            List<ErrorDetails> errorDetails = bindingResult.getFieldErrors().stream()
                    .map(error -> new ErrorDetails(error.getField(), error.getDefaultMessage()))
                    .toList();
            return ResponseEntity.badRequest()
                    .body(ApiResponse.failure("Validation failed", errorDetails));
        }

        employeeService.updateEmployee(id, employeeDTO);

        return ResponseEntity.ok()
                .body(ApiResponse.success("Employee updated successfully", null));
    }

}
