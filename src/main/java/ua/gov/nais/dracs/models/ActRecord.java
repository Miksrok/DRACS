package ua.gov.nais.dracs.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * class generate acts number and date
 */
public class ActRecord {

    private String actNumber;

    private String actDate;

    /**
     * constructor - by default
     *
     * initialization block
     * generate act record number and date
     */ {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss");
        SimpleDateFormat formatEightNumbers = new SimpleDateFormat("ddMMYYYY");
        this.actNumber = format.format(date);
        this.actDate = formatEightNumbers.format(date);
    }

    /**
     *
     * @return - act number value
     */
    public String getActNumber() {
        return actNumber;
    }

    /**
     *
     * @return - act date value
     */
    public String getActDate() {
        return actDate;
    }


}
