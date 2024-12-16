package com.mihir.EMA.DTO;

import com.mihir.EMA.Entity.EmployeeRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeDTO {

    private final Long employeeId;

    private final String employeeFirstName;

    private final String employeeLastName;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String employeeContactNumber;

    @Email
    private String employeeEmail;

    private final EmployeeRole employeeRole;

    private final String employeeDesignation;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    // No-argument constructor
    public EmployeeDTO() {
        this.employeeId = null;
        this.employeeFirstName = "";
        this.employeeLastName = "";
        this.employeeContactNumber = "";
        this.employeeEmail = "";
        this.employeeRole = EmployeeRole.USER; // Default role
        this.employeeDesignation = "";
        this.password = "";
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
        this.employeeRole = employeeRole;
        this.employeeDesignation = employeeDesignation;
        this.password = password;
    }

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
