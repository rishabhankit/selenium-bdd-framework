package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources",glue={"stepDefinitions"},
        tags="@ankit",plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class Runner extends AbstractTestNGCucumberTests
{}