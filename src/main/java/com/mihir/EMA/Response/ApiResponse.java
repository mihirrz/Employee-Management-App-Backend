package com.mihir.EMA.Response;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonInclude; // Ensures optional fields are handled properly
=======
>>>>>>> 1dc18b248809ed59d7b1b1e435046f2901902775
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
@JsonInclude(JsonInclude.Include.NON_NULL)  
=======
>>>>>>> 1dc18b248809ed59d7b1b1e435046f2901902775
public class ApiResponse<T> {
    private boolean success; // Indicates if the operation was successful
    private String message;  // A custom message for the client
    private T data;          // Generic data for flexibility

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

<<<<<<< HEAD

    public String getMessage() {
        return message;
    }
//
    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

=======
>>>>>>> 1dc18b248809ed59d7b1b1e435046f2901902775
    // Static factory method for success responses
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }

<<<<<<< HEAD
    // Static factory method for failure responses with optional data
    public static <T> ApiResponse<T> failure(String message, T data) {
        return new ApiResponse<>(false, message, data);
    }

    // Overloaded failure method for message-only responses
    public static <T> ApiResponse<T> failure(String message) {
        return failure(message, null);
=======
    // Static factory method for failure responses
    public static <T> ApiResponse<T> failure(String message) {
        return new ApiResponse<>(false, message, null);
>>>>>>> 1dc18b248809ed59d7b1b1e435046f2901902775
    }
}
