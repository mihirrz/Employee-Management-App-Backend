package com.mihir.EMA.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mihir.EMA.Entity.EmployeeRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeDTO {

    private Long employeeId;

    @NotBlank(message = "First name cannot be blank")
    private String employeeFirstName;

    @NotBlank(message = "Last name cannot be blank")
    private String employeeLastName;

    @NotBlank(message = "Contact number cannot be blank")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String employeeContactNumber;

    @Email(message = "Email should be valid")
    private String employeeEmail;

    private EmployeeRole employeeRole;

    @NotBlank(message = "Designation cannot be blank")
    private String employeeDesignation;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    // Default constructor
    public EmployeeDTO() {
    }

    // Parameterized constructor
    public EmployeeDTO(Long employeeId, String employeeFirstName, String employeeLastName,
                       String employeeContactNumber, String employeeEmail,
                       EmployeeRole employeeRole, String employeeDesignation, String password) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeContactNumber = employeeContactNumber;
        this.employeeEmail = employeeEmail;
        this.employeeRole = (employeeRole != null) ? employeeRole : EmployeeRole.USER;
        this.employeeDesignation = employeeDesignation;
        this.password = password;
    }

    // Custom Setter for Employee Role
    @JsonProperty("employeeRole")
    public void setEmployeeRole(String role) {
        if (role == null || role.trim().isEmpty()) {
            this.employeeRole = EmployeeRole.USER; // Default to USER
        } else {
            this.employeeRole = EmployeeRole.valueOf(role);
        }
    }

    // Getters and Setters

    public Long getEmployeeId() {
        return employeeId;
    }


    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public String getPassword() {
        return password;
    }
}
