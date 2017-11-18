package ru.ionovsoft.stub;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MAIN {

    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(MAIN.class.getName());
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        logger.info("Stub started.. ");
    }

}
