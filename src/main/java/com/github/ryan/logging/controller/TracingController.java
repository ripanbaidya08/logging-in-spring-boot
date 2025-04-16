package com.github.ryan.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * We Enable TRACE only during deep debugging in development, not in production unless necessary.
 * TRACE is the most verbose logging level.
 * TRACE is used for very low level flow tracking.
 */
@RestController
@RequestMapping("/trace")
public class TracingController {
    // Logger for TracingController
    private static final Logger logger = LoggerFactory.getLogger(TracingController.class);

    @GetMapping("/transaction-flow")
    public ResponseEntity<String> traceTransactionFlow() {
        logger.trace("Entering traceTransactionFlow method");

        // some business logic

        logger.trace("Fetching user account details");
        logger.trace("Checking transaction limit");
        logger.trace("Transaction approved");
        return new ResponseEntity<>("Transaction completed", HttpStatus.OK);
    }
}
