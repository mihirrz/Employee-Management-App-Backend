package com.mihir.EMA.Controller;

import com.mihir.EMA.DTO.EmployeeDTO;
import com.mihir.EMA.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.mihir.EMA.Response.ApiResponse;
<<<<<<< HEAD
=======
import com.mihir.EMA.Response.ApiErrorResponse;
>>>>>>> 1dc18b248809ed59d7b1b1e435046f2901902775
import com.mihir.EMA.Response.ErrorDetails;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Endpoint for creating a new employee
<<<<<<< HEAD
    @PostMapping(value = "/createNewEmployee", produces = "application/json")
    public ResponseEntity<ApiResponse<?>> createNewEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ErrorDetails> errorDetails = bindingResult.getFieldErrors().stream()
                    .map(error -> new ErrorDetails(error.getField(), error.getDefaultMessage()))
                    .toList();
            return ResponseEntity.badRequest()
                    .body(ApiResponse.failure("Validation failed", errorDetails));
=======
    @PostMapping("/createNewEmployee")
    public ResponseEntity<String> createNewEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        // Validate the input DTO
        if (bindingResult.hasErrors()) {
            String errorMessages = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation failed: " + errorMessages);
>>>>>>> 1dc18b248809ed59d7b1b1e435046f2901902775
        }

        employeeService.createAndSaveEmployee(employeeDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Employee created successfully", null));
    }


    @GetMapping("/employeesList")
    public ResponseEntity<ApiResponse<List<EmployeeDTO>>> getAllEmployees() {
        return ResponseEntity.ok(ApiResponse.success("Employees fetched successfully", employeeService.getAllEmployees()));
    }


}
