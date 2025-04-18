package com.github.ryan.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    // Logger for TestController class
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * Endpoint to handle test requests.
     *
     * @return A string indicating that the endpoint was successfully reached.
     */
    @RequestMapping
    public ResponseEntity<String> test() {
        // Here, i have used all the log levels
        // The log levels are: trace, debug, info, warn, error
        logger.info("Handling test request");
        logger.debug("Test request endpoint is being processed");
        logger.error("Test request endpoint encountered an error");
        logger.warn("Test request endpoint encountered a warning");
        logger.trace("Returning successful response");

        return new ResponseEntity<>("Test endpoint reached", HttpStatus.OK);
    }
}
