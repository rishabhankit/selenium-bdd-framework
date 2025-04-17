package PageObjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverClass {
    private WebDriver driver;


    public WebDriver getDriver()
    {
        if(driver==null)
        {
            ChromeOptions op=new ChromeOptions();
            op.addArguments("--disable-notifications");
            op.addArguments("--start-maximized");
            driver=new ChromeDriver(op);
        }

        return driver;
    }

    public void closeDriver()
    {
        if(driver==null)
            System.out.print("Driver not initialised");
        else
            driver.quit();
    }
}
