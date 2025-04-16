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
 * Risky actions that might not break the app but are worth alerting on.
 */
@RestController
@RequestMapping("/warn")
public class WarningController {
    // logger for WarningController class
    private static final Logger logger = LoggerFactory.getLogger(WarningController.class);

    @GetMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam double amount) {
        logger.info("Withdrawal request for amount: {}", amount);

        if(amount < 0) {
            logger.warn("Negative withdrawal amount detected: {}", amount);
        } else if (amount > 100000) {
            logger.warn("Large withdrawal amount detected: {}", amount);
        } else {
            logger.info("Withdrawal processed for amount: {}", amount);
        }

        return new ResponseEntity<>("Withdrawal processed", HttpStatus.OK);
    }
}
