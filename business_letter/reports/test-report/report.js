$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SendingGmailTest.feature");
formatter.feature({
  "line": 2,
  "name": "Business letter",
  "description": "",
  "id": "business-letter",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@sendingGmailTest"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Send email from google account to the same account and check for received email",
  "description": "",
  "id": "business-letter;send-email-from-google-account-to-the-same-account-and-check-for-received-email",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I am on Google Search Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I am logging in Google with \"\u003cusername\u003e\" username and \"\u003cpassword\u003e\" password",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I navigate to Gmail",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I create and send an email to  \"\u003creceiverEmail\u003e\" with \"\u003csubject\u003e\" subject and the following text:",
  "keyword": "And ",
  "doc_string": {
    "content_type": "",
    "line": 9,
    "value": "Dear James 2017 BUSINESS CONFERENCE 10/11 DECEMBER 2017\nI have pleasure in inviting you to attend our special conference\nto be held at Sheraton Hotel, London on Thursday/Friday 10/11 December 2017.\nThis intensive, practical conference for businessmen aims to:increase your\nbusiness productivity enable networking with business partners"
  }
});
formatter.step({
  "line": 16,
  "name": "I should see the tooltip with \"Письмо отправлено. Просмотреть сообщение\" message",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I search for inbox email with  subject and open it",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I should see the following email text:",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 19,
    "value": "Dear James 2017 BUSINESS CONFERENCE 10/11 DECEMBER 2017\nI have pleasure in inviting you to attend our special conference\nto be held at Sheraton Hotel, London on Thursday/Friday 10/11 December 2017.\nThis intensive, practical conference for businessmen aims to:increase your\nbusiness productivity enable networking with business partners"
  }
});
formatter.examples({
  "line": 26,
  "name": "",
  "description": "",
  "id": "business-letter;send-email-from-google-account-to-the-same-account-and-check-for-received-email;",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "receiverEmail",
        "subject"
      ],
      "line": 27,
      "id": "business-letter;send-email-from-google-account-to-the-same-account-and-check-for-received-email;;1"
    },
    {
      "cells": [
        "userJeck777@gmail.com",
        "user2012",
        "userJeck777@gmail.com",
        "Business letter for my partner"
      ],
      "line": 28,
      "id": "business-letter;send-email-from-google-account-to-the-same-account-and-check-for-received-email;;2"
    }
  ],
  "keyword": "Examples"
});
