package com.example.bhisma.exception;

import org.springframework.http.ResponseEntity;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestControllerAdvice
public class GlobleExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobleExceptionHandler.class);
@ExceptionHandler(InvalidOperationException.class)
public ResponseEntity<ErrorResponse> handleInvalidOperationException(InvalidOperationException ex) {
    logger.error("InvalidOperationException caught: {}", ex.getMessage());

    ErrorResponse errorResponse = new ErrorResponse(
            ex.getMessage(),
            HttpStatus.BAD_REQUEST.value(),
            "INVALID_OPERATION"
    );

    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errorResponse);
}

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        logger.error("Unexpected error occurred: {}", ex.getMessage(), ex);

        ErrorResponse errorResponse = new ErrorResponse(
                "An unexpected error occurred",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "INTERNAL_ERROR"
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

    static class ErrorResponse {
        private String message;
        private int status;
        private String errorCode;

        public ErrorResponse(String message, int status, String errorCode) {
            this.message = message;
            this.status = status;
            this.errorCode = errorCode;
        }

        public String getMessage() { return message; }
        public int getStatus() { return status; }
        public String getErrorCode() { return errorCode; }
    }

}
