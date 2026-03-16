package PageObjectPages;


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

    @FindBy(xpath="//div[@class='inventory_item_name ']")
    private List<WebElement> productNames;

    public void verifyHomePage()
    {
        Assert.assertFalse(productLabel.isEmpty());
        Helper.log(">> Swag Labs Home Page");
    }


    public void getAllProductNames() {

        Helper.log(">> Product Names:");
        for (WebElement product : productNames) {
            Helper.log("   - " + product.getText());
        }


    }
}
