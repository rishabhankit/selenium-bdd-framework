package PageObjectPages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IRCTC {

    private WebDriver driver;

    @FindBy(xpath="(//label[text()='PNR STATUS'])[1]")
    private WebElement pnrLocator;

    @FindBy(xpath="(//label[text()='CHARTS / VACANCY'])[1]")
    private WebElement chartLocator;

    @Getter
    @FindBy(xpath="(//button[@type='submit'])[1]")
    private List<WebElement> okButton;

    IRCTC(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    public void getPNR()
    {
       Helper.log(">> "+pnrLocator.getText());
    }

    public void getChart()
    {
        Helper.log(">> "+chartLocator.getText());
    }

}
