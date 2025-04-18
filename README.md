# Logging in the Project

This document outlines the logging mechanism implemented in this project, including configuration, logging levels, and details about how logs are generated and managed.

## Table of Contents

- [Overview](#overview)
- [Implementation Details](#implementation-details)
    - [Logging Framework Used](#logging-framework-used)
    - [Basic Login Usage in Spring Boot](#code-snippet)
    - [Configuration](#configuration)
- [Logging Levels](#logging-levels)
- [Log Output](#log-output)
- [How to Modify Logging](#how-to-modify-logging)
- [Best Practices](#best-practices)


## Overview

Logging is a crucial aspect for monitoring and debugging a Java application. This project uses a comprehensive logging setup to ensure that all critical operations and potential issues are recorded and available for analysis.

## Implementation Details

### Logging Framework Used

This project utilizes **Spring Boot's** built-in logging framework powered by SLF4J (Simple Logging Facade for Java) in conjunction with Logback by default.

### Basic Logging Usage in Your Code
To log messages in your application, you can use the `Logger` provided by SLF4J.

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping
    public String hello() {
        logger.info("Handling /hello request");
        logger.debug("Debugging info");
        logger.warn("Warning message");
        logger.error("Error message");
        logger.trace("Trace message");
        return "Hello, Spring Boot Logging!";
    }
}
```

### Configuration

The configuration for logging is defined in the `application.properties` or `application.yml` file. You can also find advanced configurations in the `logback-spring.xml` (if customized). Key configurations include:

- Logging levels for various packages
- Location of log files
- Log rotation policies
- Availability of console and/or file-based logging

Example (from `application.properties`):
```properties
# Root logging level
logging.level.root=INFO

# Custom logging levels for specific packages
logging.level.com.example=DEBUG

# Log file output (optional)
logging.file.name=logs/application.log
logging.file.path=logs/

# Pattern for console output
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
```

Additional structured configurations might be added to `logback-spring.xml`.

## Logging Levels

The following logging levels are available for better categorization and filtering of log messages:

- `TRACE`: Finest-grained information, often used for debugging.
- `DEBUG`: Information mostly useful for developers to debug the application.
- `INFO`: Standard logging level indicating general application flow.
- `WARN`: Potential issues that are not necessarily errors.
- `ERROR`: Error events that might still allow the application to continue running.

Default level: **INFO**

### Setting a Logging Level

To change the logging level for a specific package, update the configuration:
```properties
logging.level.<package-name>=<level>
```

For example:
```properties
logging.level.org.springframework=DEBUG
logging.level.com.example.myapp=ERROR
```

## Log Output

Logs in this project are output to the following locations:

1. **Console**: For real-time debugging and tracking during development or runtime.
2. **File** (if configured): Saved in the directory specified in `logging.file.name` or `logging.file.path`.

The log files are rotated periodically to manage disk space utilization.

## How to Modify Logging

1. **Change Log Level**:
   Modify the `application.properties` file.

2. **Change Log Format or Pattern**:
   Update the `logback-spring.xml` file for advanced formatting using PatternLayout.

3. **Enable/Disable File Logging**:
   Set `logging.file.name` or remove it to disable file logging.

Example XML configuration in `logback-spring.xml`:
```xml
<configuration>
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} - %-5level - %msg%n</pattern>
        </encoder>
    </appender>
    <root level="INFO">
        <appender-ref ref="CONSOLE" />
    </root>
</configuration>
```

## Best Practices

- Use `DEBUG` level only during development and testing to avoid performance impacts in production.
- Log contextual information for better issue tracking (e.g., transaction IDs, user IDs).
- Avoid logging sensitive information (e.g., passwords, tokens).
- Set up log rotation to manage storage.

---

## Summary

Logging in this project is designed to be simple yet flexible, using Spring Boot's built-in configuration properties along with customizable Logback configurations. Logs provide essential insights into the application's behavior and are easy to manage or extend based on evolving project requirements.

For more details on configuration options and additional customizations, please refer to the official [Spring Boot Logging Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.logging).