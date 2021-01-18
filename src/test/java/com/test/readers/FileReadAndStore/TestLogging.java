package com.test.readers.FileReadAndStore;

import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLogging {

	private static Logger LOGGER = null;
    
    @BeforeClass
    public static void setLogger() throws MalformedURLException
    {
        System.setProperty("log4j.configurationFile","log4j2-test.xml");
        LOGGER = LogManager.getLogger(TestLogging.class);
    }
     
    @Test
    public void testLoggerIfLogging()
    {
    	LOGGER.info("Info Message Logged !!!");
        LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
    }
    
}
