package com.ua.yevhen_lyzohubov.business.letter.pages;

import com.ua.yevhen_lyzohubov.business.letter.utils.HelperWait;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePage {

    @FindBy(linkText = "Войти")
    private WebElement enterInGmailElement;
    @FindBy(linkText = "русский")
    private WebElement changeRussiaLanguageElement;

    @FindBy(linkText = "Почта")
    private WebElement mailElement;

    @FindBy(linkText = "Gmail")
    private WebElement gmailElement;
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void signOnServiceLogin() {
        checkEnterOnGmailService(enterInGmailElement);
    }

    private void checkEnterOnGmailService(WebElement getMailElement) {
        try {
            getMailElement.click();
        } catch (NoSuchElementException ex) {
            System.out.println("----------Language changed to Russian---------");
            changeRussiaLanguageElement.click();
            HelperWait.explicityWaitVisible(driver, enterInGmailElement);
            enterInGmailElement.click();
        }
    }

    private static final Logger LOGGER = Logger.getLogger(LoginPage.class);

    public void clickOnGmail() {
        HelperWait.explicityWaitVisible(driver, mailElement);
        checkButtonEnterGmailService(mailElement);
        LOGGER.info("Successful login on Gmail Page");
        new GmailMainPage(driver);
    }

    private void checkButtonEnterGmailService(WebElement getMailElement) {
        try {
            getMailElement.click();
        } catch (NoSuchElementException ex) {
            gmailElement.click();
        }
    }
}
