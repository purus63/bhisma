package com.example.bhisma.BhismaService;

import com.example.bhisma.exception.InvalidOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CService {
    private static final Logger logger = LoggerFactory.getLogger(CService.class);

    public double calculate(double a, double b, String operation) throws InvalidOperationException {
        logger.info("Calculator service called with a: {}, b: {}, operation: {}", a, b, operation);
        switch (operation.toLowerCase()) {
            case "add":
                return a + b;
            case "subtract":
                return a - b;
            case "multiply":
                return a * b;
            case "divide":
                if (b == 0) {
                    logger.error("Division by zero attempted");
                    throw new InvalidOperationException("Division by zero is not allowed.");
                }
                return a / b;
            default:
                logger.error("Invalid operation: {}", operation);
                throw new InvalidOperationException("Invalid operation: " + operation);
        }
    }
}
