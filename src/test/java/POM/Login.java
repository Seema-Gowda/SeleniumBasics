package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    //Declaration
    @FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
    private WebElement uname;

    @FindBy(xpath = "//input[@class='_2IX_2- _3mctLh VJZDxU']")
    private WebElement Paswrd;

    @FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
    private WebElement Submit;

    @FindBy(xpath = "//a[@class='_2QKxJ- _2_DUc_']")
    private WebElement Forgot;

    @FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
    private WebElement Cls ;


        //Initialisation
            //Create a constructor same name as class
    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    //Utilization
        //  Real Actions happen here
    public void username()
    {
      uname.sendKeys("pallavadhikary6@gmail.com");
    }

    public  void password()
    {
        Paswrd.sendKeys("Honor@123");
    }
    public void Login()
    {
        Submit.click();
    }
    public void Close()
    {
        Cls.click();
    }

    }