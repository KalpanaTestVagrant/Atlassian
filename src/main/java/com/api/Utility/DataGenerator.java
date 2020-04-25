package com.api.Utility;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataGenerator {

    protected Faker faker;
    private RandomStringUtils randomStringUtils;

    public DataGenerator() {
        this.faker = new Faker();
    }

    public String name() { return faker.name().firstName(); }
    public String age() { return String.valueOf(faker.number().numberBetween(23,80));}
    public String salary() { return String.valueOf(faker.number().numberBetween(10000,450000));}
    public String gender() {
        return faker.random().nextInt(2) == 0 ? "male" : "female";

    }
}
