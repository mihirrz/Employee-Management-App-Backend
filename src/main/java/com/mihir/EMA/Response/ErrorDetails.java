package com.mihir.EMA.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private String fieldName; // The field where the error occurred
    private String message;   // Validation error message
}
