package ua.gov.nais.dracs.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * describe Person
 */
public class Person {

    private String name;

    private String surname;

    private String fatherName;

    private String passport;

    private String passportDate;

    private String passportPublisher;

    /**
     * constructor - public Person()
     * name, passportDate and passportPublisher has default value
     */
    public Person() {
        this.name = "Робот";
        this.passportDate = "11.11.2012";
        this.passportPublisher = "1234";
    }

    /**
     * initialization block
     * generate passport number
     */ {
        Date date = new Date();
        SimpleDateFormat formatEightNumbersSeconds = new SimpleDateFormat("ddHHmmss");
        this.passport = "9" + formatEightNumbersSeconds.format(date);
    }

    /**
     * initialization block
     * generate person surname and fatherName
     */ {
        String chars = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
        Random rnd = new Random();
        char[] surname = new char[12];
        char[] fathername = new char[12];
        for (int i = 0; i < surname.length; i++) {
            char c = chars.charAt(rnd.nextInt(chars.length()));
            surname[i] = c;
            c = chars.charAt(rnd.nextInt(chars.length()));
            fathername[i] = c;
        }
        this.surname = "Я" + new String(surname);
        this.fatherName = new String(fathername);
    }

    /**
     * @return - name value
     */
    public String getName() {
        return name;
    }

    /**
     * @return - surname value
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return - father name value
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @return - passport number value
     */
    public String getPassport() {
        return passport;
    }

    /**
     * @return - passport date value
     */
    public String getPassportDate() {
        return passportDate;
    }

    /**
     * @return - passport publisher value
     */
    public String getPassportPublisher() {
        return passportPublisher;
    }

}
