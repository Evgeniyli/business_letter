package com.ua.yevhen_lyzohubov.business.letter.pages;

import com.ua.yevhen_lyzohubov.business.letter.utils.Control;
import com.ua.yevhen_lyzohubov.business.letter.utils.HelperWait;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailMainPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(GmailMainPage.class);

    private Control control = new Control("gmail", By.xpath("//span//b[text()='%s']"));
    @FindBy(className = "vh")
    private WebElement letterIsSending;


    @FindBy(className = "aic")
    private WebElement buttonToWriteLetterElement;

    @FindBy(xpath = "/descendant::div[@class='aio UKr6le'][1]//a")
    private WebElement incomingMessageElement;

    @FindBy(xpath = "/descendant::div[@class='aio UKr6le'][3]//a")
    private WebElement sentMessageElement;

    public GmailMainPage(WebDriver driver) {
        super(driver);
    }

    public void signOnButtonWriteLetterToUser() {
        LOGGER.info("You success enter in Google Main Page");
        HelperWait.explicityWait(driver, buttonToWriteLetterElement);
        buttonToWriteLetterElement.click();
    }

    public String receivingSendMessage() {
        HelperWait.explicityWait(driver, letterIsSending);
        return letterIsSending.getText();
    }

    public void makeRefreshReceiviningGmails() {
        HelperWait.explicityWait(driver, incomingMessageElement);
        incomingMessageElement.click();
        sentMessageElement.click();
        HelperWait.sleepWait(3000);
        incomingMessageElement.click();
    }

    public void getGmailSubjectFromReceivingGmails(String getRandomText) {
        WebElement gmailElement = control.modify(getRandomText, driver);
        HelperWait.explicityWaitVisible(driver, gmailElement);
        gmailElement.click();
    }
}
