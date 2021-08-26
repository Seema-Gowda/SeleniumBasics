package Scripts;

import POM.HomePage;
import POM.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTV
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");
        Thread.sleep(3000);

        Login L = new Login(driver);
        L.username();
        L.password();
        L.Login();

        HomePage Hm = new HomePage(driver);
        Hm.Serchbox("Sony TV");
        Thread.sleep(3000);
        Hm.Serchclcik();

    }

}
