package PageObjectPages;

import org.openqa.selenium.WebDriver;


public class TextContext {

    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public DriverClass driverClass;

    public TextContext()
    {
        this.driverClass=new DriverClass();
        this.driver=this.driverClass.getDriver();
        this.pageObjectManager=new PageObjectManager(driver);

    }
}
