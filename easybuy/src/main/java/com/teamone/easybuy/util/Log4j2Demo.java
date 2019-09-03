package com.teamone.easybuy.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Demo {
    static Logger logger = LogManager.getLogger("mylog");

    public static void main(String[] args) {
        logger.debug("this is a debug...");
        logger.info("this is a info...");
        logger.warn("this is a warning...");
        logger.error("this  is  a error ...");


    }
}
