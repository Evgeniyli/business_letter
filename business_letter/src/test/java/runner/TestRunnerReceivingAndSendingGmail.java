package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ={"src\\test\\resources\\features"},glue = {"com/ua/yevhen_lyzohubov/business/letter/tests"},format={"pretty","html:reports/test-report"},
        tags = "@sendingGmailTest")

public class TestRunnerReceivingAndSendingGmail{
}
