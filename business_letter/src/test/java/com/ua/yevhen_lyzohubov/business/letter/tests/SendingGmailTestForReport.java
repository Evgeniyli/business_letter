package com.ua.yevhen_lyzohubov.business.letter.tests;

import com.ua.yevhen_lyzohubov.business.letter.modules.NewEmailWindow;
import com.ua.yevhen_lyzohubov.business.letter.pages.GmailEmailPage;
import com.ua.yevhen_lyzohubov.business.letter.pages.GmailMainPage;
import com.ua.yevhen_lyzohubov.business.letter.pages.GoogleSearchPage;
import com.ua.yevhen_lyzohubov.business.letter.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class SendingGmailTestForReport extends BaseTest {

    @Given("^I am on Google Search Page$")
    public void iAmOnGoogleSearchPage() throws Throwable {
        driver.get("https://www.google.com.ua/");
    }

    @When("^I am logging in Google with \"([^\"]*)\" username and \"([^\"]*)\" password$")
    public void iAmLogInGoogleWithUsernameAndPasswordPassword(String gmail, String password) throws Throwable {
        GoogleSearchPage homeGooglePage=new GoogleSearchPage(driver);
        homeGooglePage.signOnServiceLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPasswordInTheField(gmail, password);
    }

    @And("^I navigate to Gmail$")
    public void navigateToGmail() throws Throwable {
        GoogleSearchPage homeGooglePage=new GoogleSearchPage(driver);
        homeGooglePage.clickOnGmail();
    }

    @And("^I create and send an email to  \"([^\"]*)\" with \"([^\"]*)\" subject and the following text:$")
    public void iCreateAndSendAnEmailToWithSubjectAndTheFollowingText(String userEmail, String subject,String message) throws Throwable {
        GmailMainPage gmailPage = new GmailMainPage(driver);
        gmailPage.signOnButtonWriteLetterToUser();
        NewEmailWindow newLetterModule = new NewEmailWindow(driver);
        newLetterModule.enterInFieldAddressUser(userEmail, getRandomText(subject), message);
    }


    @Then("^I should see the tooltip with \"([^\"]*)\" message$")
    public void iShouldSeeTheTooltipWithMessage(String receivingLetter) throws Throwable {
        GmailMainPage gmailPage = new GmailMainPage(driver);
        String textFromLocator = gmailPage.receivingSendMessage();
        Assert.assertEquals(textFromLocator,receivingLetter);
    }

    @When("^I search for inbox email with  subject and open it$")
    public void iSearchForInboxEmailWithSubjectAndOpenIt() throws Throwable {
        GmailMainPage gmailPage = new GmailMainPage(driver);
        gmailPage.makeRefreshReceiviningGmails();
        gmailPage.getGmailSubjectFromReceivingGmails(gmailText);
    }

    @Then("^I should see the following email text:$")
    public void iShouldSeeTheFollowingEmailText(String message) throws Throwable {
        GmailEmailPage gmailEmailPage=new GmailEmailPage(driver);
        String gmailText = gmailEmailPage.getGmalText();
        Assert.assertEquals(gmailText,message);
    }
}