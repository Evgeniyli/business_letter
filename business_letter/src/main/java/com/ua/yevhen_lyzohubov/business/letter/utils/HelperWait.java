package com.ua.yevhen_lyzohubov.business.letter.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperWait {
    private HelperWait() {
        throw new IllegalStateException("Class can not be instantiated");
    }

    public static void explicityWait(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void explicityWaitVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 45).until(ExpectedConditions.visibilityOf(element));
    }

    public static void sleepWait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
