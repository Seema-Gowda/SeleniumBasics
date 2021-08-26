package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    //Declaration
    @FindBy(xpath = "//input[@class='_3704LK']")
    private WebElement Serchbox;

    @FindBy(xpath="//button[@class='L0Z3Pu']")
    private WebElement Serchclcik;

    //Initialisation
    //Create a constructor same name as class
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    //Utilization

    //  Real Actions happen here
    public void Serchbox (String SearchTxt)
    {
        Serchbox.sendKeys(SearchTxt);
    }
        public void Serchclcik()
        {
            Serchclcik.click();
        }

}