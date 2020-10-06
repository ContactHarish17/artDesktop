package TestRunner;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"D:\\artDesktop\\Features\\ARTOnBoarding.feature"},
        glue = {"StepDefinition"},
        plugin = {"pretty","html:target/cucumber-html-report", "json:target/cucumber.json"},
        monochrome = true
        )
public class Runner
{

}
