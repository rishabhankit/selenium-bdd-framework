package PageObjectPages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    WebDriver driver;

    PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }

    public IRCTC getIRCTC()
    {
        return new IRCTC(driver);
    }


}
