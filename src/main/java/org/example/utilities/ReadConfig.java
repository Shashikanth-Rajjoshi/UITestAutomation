package org.example.utilities;

import org.apache.log4j.Logger;
import org.example.baseTest.BaseTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    public static final Logger logger = Logger.getLogger(BaseTest.class);
    public static String getConfigValue(String key) throws IOException {
        FileReader fr = new FileReader(System.getProperty("user.dir")+"/testData/config.properties");
        Properties pr = new Properties();
        pr.load(fr);
        logger.info("Getting Config value for key: "+key);
        return pr.getProperty(key);
    }
}
