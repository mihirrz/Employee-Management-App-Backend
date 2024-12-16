package com.mihir.EMA.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
    private String errorCode; // Unique error code
    private String errorMessage; // Description of the error
    private Object details; // Additional error details (optional)

    public ApiErrorResponse(String errorCode, String errorMessage, Object details) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.details = details;
    }

    // Static factory method
    public static ApiErrorResponse from(String errorCode, String errorMessage, Object details) {
        return new ApiErrorResponse(errorCode, errorMessage, details);
    }

    public static ApiErrorResponse from(String errorCode, String errorMessage) {
        return new ApiErrorResponse(errorCode, errorMessage, null);
    }
}
