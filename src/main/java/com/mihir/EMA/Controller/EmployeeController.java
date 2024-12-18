package com.mihir.EMA.Controller;

import com.mihir.EMA.DTO.EmployeeDTO;
import com.mihir.EMA.Service.EmployeeService;
import jakarta.validation.Valid;
import org.apache.kafka.common.errors.ResourceNotFoundException;
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

    // Endpoint to list down all the employees
    @GetMapping("/employeesList")
    public ResponseEntity<ApiResponse<List<EmployeeDTO>>> getAllEmployees() {
        List<EmployeeDTO> employeeList = employeeService.getAllEmployees();

        if(employeeList.isEmpty())
            return ResponseEntity.ok(ApiResponse.success("No employees found", null));

        return ResponseEntity.ok(ApiResponse.success("Employees fetched successfully", employeeList));
    }


    // Endpoint to update the existing employee using id
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

    // Endpoint to delete an existing employee
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<ApiResponse<?>> deleteEmployee(@PathVariable Long id) {
        try {
            // Call the service to delete the employee
            employeeService.deleteEmployee(id);

            // Return success response
            return ResponseEntity.ok(ApiResponse.success("Successfully deleted employee"));
        } catch (ResourceNotFoundException ex) {
            // Handle case when employee is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.failure(STR."Employee not found with ID: \{id}"));
        } catch (Exception ex) {
            // Handle any unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.failure(STR."An error occurred: \{ex.getMessage()}"));
        }
    }

}
