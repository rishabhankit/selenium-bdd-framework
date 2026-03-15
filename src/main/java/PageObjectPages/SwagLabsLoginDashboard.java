package PageObjectPages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SwagLabsLoginDashboard {

    private WebDriver driver;

    @FindBy(xpath="//input[@placeholder='Username']")
    private WebElement username;

    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath="//input[@id='login-button']")
    private WebElement loginButton;

    SwagLabsLoginDashboard(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    public void enterUsernamePassword(String username,String password)
    {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        Helper.log(">> Username and Password Entered");
    }

    public void submitButton()
    {
        this.loginButton.click();
        Helper.log(">> Login Button Clicked");
    }


}
