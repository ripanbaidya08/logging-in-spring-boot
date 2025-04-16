package com.github.ryan.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ERROR: this is used to handle errors that occur during the execution of the application.
 * Always log exceptions with ERROR level and full stack trace.
 * Must be used in production environment.
 */
@RestController
@RequestMapping("/error")
public class ErrorController {
    // logger for ErrorController class
    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @GetMapping("/division")
    public ResponseEntity<String> divide(@RequestParam int a, @RequestParam int b) {
        try {
            int result = a / b;
            return new ResponseEntity<>("Result: " + result, HttpStatus.OK);
        } catch (ArithmeticException e) {
            logger.error("Division by zero error: a={}, b={}", a, b, e);
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
