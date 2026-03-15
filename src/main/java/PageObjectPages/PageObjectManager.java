package PageObjectPages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    WebDriver driver;

    PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }

    public SwagLabsLoginDashboard getSwagLabsLoginDashboard()
    {
        return new SwagLabsLoginDashboard(driver);
    }

    public SwagLabsHomePage getSwagLabsHomePage()
    {
        return new SwagLabsHomePage(driver);
    }


}
