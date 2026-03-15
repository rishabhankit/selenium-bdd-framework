package PageObjectPages;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SwagLabsHomePage {
    private WebDriver driver;

    public SwagLabsHomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath="//span[text()='Products']")
    private List<WebElement> productLabel;

    public void verifyHomePage()
    {
        Assert.assertFalse(productLabel.isEmpty());
        Helper.log(">> Swag Labs Home Page");
    }


}
