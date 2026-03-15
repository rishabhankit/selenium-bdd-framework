package stepDefinitions;

import PageObjectPages.StepTracker;
import PageObjectPages.WordReportUtil;
import io.cucumber.java.AfterStep;
import java.io.File;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;

import PageObjectPages.TextContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;

public class Hooks {

    WebDriver driver;
    TextContext textContext;


    public Hooks(TextContext textContext)
    {
        this.textContext=textContext;
    }

    @Before
    public void launchPage(Scenario scenario)
    {
        StepTracker.stepName.set("Given user launches SwagLabs website");
        driver=textContext.driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WordReportUtil.createWordFile(scenario.getName());

    }
    
    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        driver=textContext.driver;
//        File sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        byte[] fileContent=FileUtils.readFileToByteArray(sourcepath);
//        scenario.attach(fileContent,"image/png","snapname");

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", "snapname");

        String step = StepTracker.stepName.get();

        WordReportUtil.addScreenshot(screenshot, step);
    }

    @After
    public void closeDriver()
    {
        WordReportUtil.saveWordFile();
        textContext.driverClass.closeDriver();
    }

}
