package ua.gov.nais.dracs.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Person {

    private String name;

    private String surname;

    private String fatherName;

    private String passport;

    private String passportDate;

    private String passportPublisher;

    public Person(){
        this.name = "Робот";
        this.passportDate = "11.11.2012";
        this.passportPublisher = "1234";
    }

    {
        Date date = new Date();
        SimpleDateFormat formatEightNumbersSeconds = new SimpleDateFormat("ddHHmmss");
        this.passport = "9" + formatEightNumbersSeconds.format(date);
    }

    {
        String chars = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
        Random rnd = new Random();
        char [] surname = new char[12];
        char [] fathername = new char[12];
        for (int i = 0; i<surname.length; i++){
            char c = chars.charAt(rnd.nextInt(chars.length()));
            surname[i] = c;
            c = chars.charAt(rnd.nextInt(chars.length()));
            fathername[i] = c;
        }
        this.surname = "Я" + new String(surname);
        this.fatherName = new String(fathername);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getPassport() {
        return passport;
    }

    public String getPassportDate() {
        return passportDate;
    }

    public String getPassportPublisher() {
        return passportPublisher;
    }

}
