package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTests {
    private static final Logger logger = LogManager.getLogger(LoggerTests.class);
    @Test
    public void logTest() {
        logger.trace("Trace Message: Начало теста...");//simple information
        logger.debug("Debug Message: ...");
        logger.info("Info Message: ...");
        logger.error("Error Message: ...");
        logger.fatal("Fatal Message: ...");
    }
}
