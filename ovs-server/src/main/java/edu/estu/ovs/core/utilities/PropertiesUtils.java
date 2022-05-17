package edu.estu.ovs.core.utilities;

import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    @SneakyThrows
    public static String getElement(String fileName, String key) {
        Properties props = new Properties();
        InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) return null;
        props.load(inputStream); // load
        inputStream.close();
        return props.getProperty(key); // get by prop name
    }

    @SneakyThrows
    public static String updateElement(String fileName, String key, String newValue) {
        String path = String.format("./ovs-server/src/main/resources/%s", fileName);
        InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) return "";
        FileOutputStream outputStream = new FileOutputStream(path);
        Properties props = new Properties();
        props.load(inputStream); // load
        String oldValue = props.getProperty(key); // get old value that will be returned
        props.replace(key, newValue); // change
        props.store(outputStream, null); // save
        inputStream.close();
        outputStream.close();
        return oldValue;
    }

}
