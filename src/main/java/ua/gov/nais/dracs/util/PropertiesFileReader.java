package ua.gov.nais.dracs.util;

import java.io.*;
import java.util.Properties;

public class PropertiesFileReader {

    private static File file = new File("src\\main\\resources\\properties.xml");
    private static FileInputStream fileInput;
    private static Properties properties;


    public static String getPropValues(String value) throws IOException {

        try {
            fileInput = new FileInputStream(file);
            properties = new Properties();
            properties.loadFromXML(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileInput.close();
        }
        return properties.getProperty(value);
    }
}
