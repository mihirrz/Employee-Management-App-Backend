package com.mihir.EMA.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
<<<<<<< HEAD
//@AllArgsConstructor
public class ErrorDetails {
    private String fieldName; // The field where the error occurred
    private String message;   // Validation error message

    public ErrorDetails(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
=======
@AllArgsConstructor
public class ErrorDetails {
    private String fieldName; // The field where the error occurred
    private String message;   // Validation error message
>>>>>>> 1dc18b248809ed59d7b1b1e435046f2901902775
}
