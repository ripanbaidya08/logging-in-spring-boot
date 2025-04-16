package com.github.ryan.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * INFO: this is widely used in production environment.
 * Used to monitor and understand the behavior of the application.
 */
@RestController
@RequestMapping("/info")
public class InfoController {
    // logger for InfoController class
    private static final Logger logger = LoggerFactory.getLogger(InfoController.class);

    @PostMapping("/create-account")
    public ResponseEntity<String> createAccount(@RequestBody String username) {
        logger.info("Creating account for user: {}", username);
        return new ResponseEntity<>("Account creation initiated", HttpStatus.OK);
    }
}
