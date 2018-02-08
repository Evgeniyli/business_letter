package com.ua.yevhen_lyzohubov.business.letter.pages;

import com.ua.yevhen_lyzohubov.business.letter.utils.HelperWait;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@type='email']")
    private WebElement fieldEmailElement;

    @FindBy(xpath = "//*[@id='identifierNext']")
    private WebElement loginNextElement;

    @FindBy(xpath = "//*[@id='passwordNext']")
    private WebElement passwordNextElement;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement fieldPasswordElement;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement transferOnLinkElement;

    @FindBy(xpath = "//*[contains(text(),'Business letter for my partner')]")
    private WebElement subjectElement;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAndPasswordInTheField(String email, String password) {
        LOGGER.info("click in sign login form");
        fieldEmailElement.sendKeys(email);
        loginNextElement.click();
        HelperWait.explicityWait(driver, fieldPasswordElement);
        fieldPasswordElement.sendKeys(password);
        passwordNextElement.click();
        LOGGER.info("Run: LoginPageTest");
    }
}
