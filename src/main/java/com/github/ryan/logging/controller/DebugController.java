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
 *  DEBUG is use for Logs logic decisions, input/output during development.
 */
@RestController
@RequestMapping("/debug")
public class DebugController {
    // Logger for DebugController class
    private static final Logger logger = LoggerFactory.getLogger(DebugController.class);

    @GetMapping("/validate-account")
    public ResponseEntity<String> validateAccount(@RequestParam String accountId) {
        logger.debug("Validating account: {}", accountId);

        // account validation logic
        boolean isValid = accountId.startsWith("ACC");
        logger.debug("Validation result: {}", isValid);
        return new ResponseEntity<>("Account validation complete", HttpStatus.OK);
    }
}
