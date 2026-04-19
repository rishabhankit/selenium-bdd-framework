package PageObjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class DriverClass {
//    private WebDriver driver;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public WebDriver getDriver()
    {
        if(driver.get() == null)
        {
            ChromeOptions op=new ChromeOptions();
            op.addArguments("--disable-notifications");
            op.addArguments("--start-maximized");
            driver.set(new ChromeDriver(op));
            // Set implicit wait here for better practice
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver.get();
    }

    public void closeDriver()
    {
        if(driver.get() == null)
            System.out.print("Driver not initialised");
        else {
            driver.get().quit();
            driver.remove();
        }
    }
}
