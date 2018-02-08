@sendingGmailTest
Feature: Business letter

  Scenario Outline: Send email from google account to the same account and check for received email
    Given I am on Google Search Page
    When  I am logging in Google with "<username>" username and "<password>" password
    And   I navigate to Gmail
    And   I create and send an email to  "<receiverEmail>" with "<subject>" subject and the following text:
  """
 Dear James 2017 BUSINESS CONFERENCE 10/11 DECEMBER 2017
 I have pleasure in inviting you to attend our special conference
 to be held at Sheraton Hotel, London on Thursday/Friday 10/11 December 2017.
 This intensive, practical conference for businessmen aims to:increase your
 business productivity enable networking with business partners
  """
    Then I should see the tooltip with "Письмо отправлено. Просмотреть сообщение" message
    When I search for inbox email with  subject and open it
    Then I should see the following email text:
 """
 Dear James 2017 BUSINESS CONFERENCE 10/11 DECEMBER 2017
 I have pleasure in inviting you to attend our special conference
 to be held at Sheraton Hotel, London on Thursday/Friday 10/11 December 2017.
 This intensive, practical conference for businessmen aims to:increase your
 business productivity enable networking with business partners
  """
    Examples:
      | username              | password | receiverEmail         | subject                        |
      | userJeck777@gmail.com | user2012 | userJeck777@gmail.com | Business letter for my partner |


