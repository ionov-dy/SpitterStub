package ru.ionovsoft.stub.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {

    static {
        properties = new Properties();
        load();
    }

    private static final Properties properties;

    public final static String HOST = properties.getProperty("host");

    public final static int PORT = Integer.valueOf(properties.getProperty("port"));

    public final static String INPUT_QUEUE = properties.getProperty("inputQueue");

    public final static String OUTPUT_QUEUE = properties.getProperty("outputQueue");

    private static void load(){
        try {
            properties.load(new FileInputStream("settings"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
