package ua.gov.nais.dracs.util;

import org.testng.Reporter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CustomReporter {

    public static void log(String text){
        Reporter.log(String.format("[%-12s] ACTION: %s",
                LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME),
                "<font size='5'><b>"+text + "</b></font><br>"));
    }

}
