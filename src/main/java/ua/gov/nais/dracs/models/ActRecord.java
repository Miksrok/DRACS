package ua.gov.nais.dracs.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActRecord {

    private String actNumber;

    private String actDate;

    {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss");
        SimpleDateFormat formatEightNumbers = new SimpleDateFormat("ddMMYYYY");
        this.actNumber = format.format(date);
        this.actDate = formatEightNumbers.format(date);
    }

    public String getActNumber(){
        return actNumber;
    }
    public String getActDate(){
        return actDate;
    }


}
