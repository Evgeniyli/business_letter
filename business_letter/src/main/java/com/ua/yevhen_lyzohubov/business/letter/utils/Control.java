package com.ua.yevhen_lyzohubov.business.letter.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Control {
    private By by;
    private String name;

    public Control(String nameBy, By by) {
        this.name=nameBy;
        this.by = by;
    }

    public WebElement modify(String modifier,WebDriver driver) {
        String modifiedByLocator = by.toString().replaceAll("(By[\\s\\S]*?): ", "");
        modifiedByLocator = String.format(modifiedByLocator, modifier);
        return driver.findElement(By.xpath(modifiedByLocator));
    }
}
