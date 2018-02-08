package com.ua.yevhen_lyzohubov.business.letter.pages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailEmailPage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(GmailEmailPage.class);
    @FindBy(css = ".ii div[dir='ltr']")
    private WebElement textGmailElement;

    public GmailEmailPage(WebDriver driver) {
        super(driver);
    }
    public String getGmalText() {
        LOGGER.info("You success enter the Gmail Email Page");
        return textGmailElement.getText();
    }
}
