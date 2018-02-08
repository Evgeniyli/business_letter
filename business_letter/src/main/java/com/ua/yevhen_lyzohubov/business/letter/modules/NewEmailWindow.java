package com.ua.yevhen_lyzohubov.business.letter.modules;

import com.ua.yevhen_lyzohubov.business.letter.pages.BasePage;
import com.ua.yevhen_lyzohubov.business.letter.utils.HelperWait;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewEmailWindow extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(NewEmailWindow.class);

    public NewEmailWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@aria-label='Кому']")
    private WebElement inputFieldUserElement;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectElement;

    @FindBy(xpath = "//div[@aria-label='Тело письма']")
    private WebElement bodyLetterElement;

    @FindBy(xpath = "//div[text()='Отправить']")
    private WebElement buttonSendElement;

    public void enterInFieldAddressUser(String gmailUser, String subject, String getMessage) {
        LOGGER.info("You enter the New Email Window Page");
        HelperWait.explicityWait(driver, bodyLetterElement);
        inputFieldUserElement.sendKeys(gmailUser);
        subjectElement.sendKeys(subject);
        bodyLetterElement.sendKeys(getMessage);
        HelperWait.explicityWait(driver, buttonSendElement);
        buttonSendElement.click();
        LOGGER.info("You success receiving your letter");
    }
}
