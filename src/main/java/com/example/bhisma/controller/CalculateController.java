package com.example.bhisma.controller;


import com.example.bhisma.bhishmaservice.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bhisma.exception.InvalidOperationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/v1")
public class CalculateController {

    private static final Logger logger = LoggerFactory.getLogger(CalculateController.class);

    @Autowired
    private CalculateService calculateService;

    @GetMapping("/calculate")
    public ResponseEntity<?> calculate(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam String operation) {

        logger.info("Received request - a: {}, b: {}, operation: {}", a, b, operation);

        try {
            double result = calculateService.calculate(a, b, operation);
            logger.info("Calculation successful - Result: {}", result);

            return ResponseEntity.ok(new CalculatorResponse(
                    a, b, operation, result, "Success"
            ));

        } catch (InvalidOperationException e) {
            logger.error("Error occurred - {}", e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage(), a, b, operation));
        }
    }

    @PostMapping("/calculate")
    public ResponseEntity<?> calculatePost(@RequestBody CalculatorRequest request) {

        logger.info("Received POST request - a: {}, b: {}, operation: {}",
                request.getA(), request.getB(), request.getOperation());

        try {
            double result = calculateService.calculate(request.getA(), request.getB(), request.getOperation());

            logger.info("Calculation successful - Result: {}", result);

            return ResponseEntity.ok(new CalculatorResponse(request.getA(), request.getB(), request.getOperation(), result, "Success"));

        } catch (InvalidOperationException e) {
            logger.error("Error occurred - {}", e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage(), request.getA(), request.getB(), request.getOperation()));
        }
    }

    // Request DTO
    static class CalculatorRequest {
        private double a;
        private double b;
        private String operation;

        public CalculatorRequest() {}

        public CalculatorRequest(double a, double b, String operation) {
            this.a = a;
            this.b = b;
            this.operation = operation;
        }

        public double getA() { return a; }
        public void setA(double a) { this.a = a; }

        public double getB() { return b; }
        public void setB(double b) { this.b = b; }

        public String getOperation() { return operation; }
        public void setOperation(String operation) { this.operation = operation; }
    }

    // Response DTO
    static class CalculatorResponse {
        private double a;
        private double b;
        private String operation;
        private double result;
        private String status;

        public CalculatorResponse(double a, double b, String operation, double result, String status) {
            this.a = a;
            this.b = b;
            this.operation = operation;
            this.result = result;
            this.status = status;
        }

        public double getA() { return a; }
        public double getB() { return b; }
        public String getOperation() { return operation; }
        public double getResult() { return result; }
        public String getStatus() { return status; }
    }

    // Error Response DTO
    static class ErrorResponse {
        private String error;
        private double a;
        private double b;
        private String operation;

        public ErrorResponse(String error, double a, double b, String operation) {
            this.error = error;
            this.a = a;
            this.b = b;
            this.operation = operation;
        }

        public String getError() { return error; }
        public double getA() { return a; }
        public double getB() { return b; }
        public String getOperation() { return operation; }
    }
}

