package com.ua.yevhen_lyzohubov.business.letter.tests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseTest {
    private Scenario myScenario;
    private static final Logger LOGGER = Logger.getLogger(Hook.class);

    @Before
    public void before(Scenario scenario) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.myScenario = scenario;
    }

    @After()
    public void after(Scenario scenario) {
        myScenario.write("Finished scenario");
        try {
            iTakeAScreenshot(scenario);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        driver.close();
        driver.quit();
    }

    private void iTakeAScreenshot(Scenario myScenario) throws Throwable {
        try {
            myScenario.write("Current Page URL is " + driver.getCurrentUrl());
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            myScenario.embed(screenshot, "image/png");// Stick it in the report
            LOGGER.info("Was made a screenshot "+screenshot);
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            somePlatformsDontSupportScreenshots.getMessage();
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }
}
