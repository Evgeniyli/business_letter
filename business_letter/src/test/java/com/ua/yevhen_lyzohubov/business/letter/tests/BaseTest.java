package com.ua.yevhen_lyzohubov.business.letter.tests;

import org.openqa.selenium.WebDriver;

import java.util.Random;

public class BaseTest {
    protected static WebDriver driver;
    protected static String gmailText = null;

    static String getRandomText(String getSubjectText) {
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(10000 - 1000);
        gmailText=getSubjectText+" "+randomNumber;
        return gmailText;
    }
}
