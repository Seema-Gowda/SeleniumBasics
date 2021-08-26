package feature;

import org.apache.commons.io.FileUtils;
import org.apache.maven.shared.utils.cli.CommandLineCallable;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.LinkedList;
import java.util.Set;

public class OpenBrowser {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");


       // selbasic();
       // login();
        // selectdropdown();
        //HoverDragDrop();
       //OpenExcelReadVal();
       //Screenshotss();
        //AlrtPopUp();
        //UploadFilepopup();
        //JSextrScrollDwnandUp();
        //JSDisableleme();
        //Multiplewindows();
    }

   static void  Multiplewindows() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naukri.com");
        Thread.sleep(3000);
        Set<String> ids = driver.getWindowHandles();
        LinkedList<String> windowId = new LinkedList<String>(ids);
        System.out.println(windowId);
        int count = windowId.size();
        for (int i = 0; i < count; i++) {
            String id = windowId.get(i);
            driver.switchTo().window(id)
            ;
            String title = driver.getTitle();
            System.out.println(title);
        }
        driver.switchTo().window(windowId.get(1));
        driver.close();

    }

    static void  JSDisableleme() throws InterruptedException {
        System.out.println("Java clss type cast nd add element to sisable element");
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Seema Sel\\OldFiles\\Locators.html");
        Thread.sleep(3000);
        JavascriptExecutor jis = (JavascriptExecutor) driver;
        jis.executeScript("document.getElementById('a2').value='javasick'");
        Thread.sleep(3000);
        WebElement tbox= driver.findElement(By.xpath("//input[@name='n1']"));
        jis.executeScript("arguments[0].value='Selenium'", tbox);
        Thread.sleep(3000);
        //type cast to sting since jis...is object value
       String  data = (String)jis.executeScript("return arguments[0].value", tbox);
        System.out.println(data);
        //Clear data
        jis.executeScript("arguments[0].value=''", tbox);
        Thread.sleep(3000);
        //Click an element
        WebElement ele = driver.findElement(By.xpath("//input[@class='c1']"));
        jis.executeScript("arguments[0].click",ele);

    }


    static void JSextrScrollDwnandUp() throws InterruptedException {
        System.out.println("Java clss type cast nd scroll up and down");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        Thread.sleep(3000);
        JavascriptExecutor jis = (JavascriptExecutor) driver;
        jis.executeScript("window.scrollBy(0,5000)");
        Thread.sleep(3000);
        jis.executeScript("window.scrollBy(0,-5000)");
        Thread.sleep(3000);
        jis.executeScript("window.scrollBy(300,0)");
        Thread.sleep(3000);
        jis.executeScript("window.scrollBy(-300,0)");
    }

    static void UploadFilepopup()
    {
        System.out.println("file upload pop up close demo");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/upload/");
        driver.findElement(By.xpath("//input[@id='uploadfile_0']")).sendKeys("C:\\Seema Sel\\OldFiles\\Login.jpeg");
        driver.findElement((By.xpath("//button[@id='submitbutton']"))).click();
    }

    static void AlrtPopUp() throws InterruptedException {
        System.out.println("Alert pop up close demo");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/delete_customer.php ");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("12345");
        driver.findElement((By.xpath("//input[@name='submit']"))).click();
        Thread.sleep(3000);
        Alert alt = driver.switchTo().alert();
        String txt = alt.getText();
        System.out.println( txt);
        alt.accept();

    }

    static void Screenshotss() throws InterruptedException, IOException {
        System.out.println("Screenshots demo");
        WebDriver  driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        Thread.sleep(3000);
        TakesScreenshot ts = (TakesScreenshot)driver;
        File x = ts.getScreenshotAs(OutputType.FILE);
        File z = new File("C://Seema Sel//OldFiles//Login.jpeg");
        FileUtils.copyFile(x,z);


    }

    static void OpenExcelReadVal() throws IOException
    {
      //  ChromeDriver driver = new ChromeDriver();
        System.out.println("Excel Sheet pick cell");
        //Step 1 path of excel sheet
        FileInputStream FIS = new FileInputStream("./Excel/Flipkart.xlsx");
        //Step 2 Open document
        Workbook wf = WorkbookFactory.create(FIS);
        //Step 3  : Select sheet
        Sheet sh = wf.getSheet("Login");
        //Step 4 : Select Row
        Row r = sh.getRow(1);
        //Step 5 : Select cell
       Cell c =  r.getCell(0);
       String data =  c.getStringCellValue();
    System.out.println(data);

    }


    static void HoverDragDrop() throws InterruptedException {
         ChromeDriver driver = new ChromeDriver();
        System.out.println("Hover Drag and drop");
        driver.get ("https://www.flipkart.com/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        WebElement ele = driver.findElement(By.xpath("//div[text()='Electronics']"));
        //Action class
        Actions hovr = new Actions(driver);
        hovr.moveToElement(ele).perform();
        driver.findElement(By.xpath("//a[text()='Bluetooth Speakers']")).click();
        driver.get ("http://demo.guru99.com/test/drag_drop.html");
        Thread.sleep(4000);
        //FromSpot and ToSpot
      //  WebElement FromSpot
        WebElement     FromSpot  = driver.findElement(By.xpath("//a[text()=' SALES ']"));
        WebElement     ToSpot  = driver.findElement(By.xpath("(//li[@class ='placeholder'])[1]"));
        //Action class
        Actions dragdrop = new Actions(driver);
        dragdrop.dragAndDrop(FromSpot,ToSpot).perform();
        Thread.sleep(4000);



    }

    static void selectdropdown() throws InterruptedException {
        System.out.println("DropDown");
        ChromeDriver driver = new ChromeDriver();
        driver.get("C:\\Seema Sel\\OldFiles\\select.html");

        WebElement ele = driver.findElement(By.xpath("//select[@id='a1']"));
       Select S =  new Select(ele);
       S.selectByIndex(2);
        S.selectByValue("i");
        S.selectByVisibleText("poori");
        Thread.sleep(3000);

        WebElement ele1 = driver.findElement(By.xpath("//select[@id='a2']"));
        //Select class for drop down list
        Select S1 =  new Select(ele1);
        S1.selectByIndex(1);
        S1.selectByValue("j");
        S1.selectByVisibleText("chutney");
        Thread.sleep(3000);
        S1.deselectByVisibleText("chutney");
        Thread.sleep(3000);

      driver.get ("https://www.plus2net.com/php_tutorial/date-selection.php");
        WebElement Mnt = driver.findElement(By.xpath("//select[@name='month']"));
        WebElement Dt = driver.findElement(By.xpath("//select[@name='dt']"));

        Thread.sleep(5000);
        Select Month = new Select(Mnt);
        Month.selectByVisibleText("April");
        Select Dats = new Select(Dt);
        Dats.selectByValue("10");
        driver.findElement(By.xpath("//input[@name='year']")).clear();
        driver.findElement(By.xpath("//input[@name='year']")).sendKeys("2001");
        Thread.sleep(3000);



    }

    static void login() throws InterruptedException {

        System.out.println("Login");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.gmail.com");
        //driver.findElement(By.xpath("//a[@data-action='sign in']")).click();
        Thread.sleep(3000);
      WebElement ele = driver.findElement(By.id("identifierId"));
      ele.sendKeys("seemag05@gmail.com");
      String emailid = ele.getTagName();
      System.out.println(emailid);
      Boolean chkfield = ele.isDisplayed();
        System.out.println(chkfield);
      String txtchk =  driver.findElement(By.xpath("//button[@type='button']")).getText();
        System.out.println(txtchk);
        driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[1]")).click();
        //driver.findElement(By.xpath("//div[@class='AxOyFc snByac']")).sendKeys("seemag05@gmail.com");

    }
static void selbasic() throws InterruptedException {
    //System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");


    //FirefoxDriver driver = new FirefoxDriver();
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");

    String title  = driver.getTitle();
    System.out.println(title);

    String url  =driver.getCurrentUrl();
    System.out.println(url);

    String   id= driver.getWindowHandle();
    System.out.println(id);

    Set<String> id1 = driver.getWindowHandles();
    System.out.println(id1);

    driver.get("C:\\Seema Sel\\OldFiles\\Locators.html");
    Thread.sleep(3000);

    driver.findElement(By.id("a1")).sendKeys("Selenium1");
    Thread.sleep(3000);
    //driver.findElement(By.name("n1")).sendKeys("SeemajavaSel");
    driver.findElement(By.xpath("html/body/input[3]")).sendKeys("xpathseln");
    driver.findElement(By.className("c1")).click();
    driver.findElement(By.className("c2")).click();
    driver.findElement(By.linkText("Google12345")).click();


    driver.get("https://www.flipkart.com/");
    driver.findElement(By.xpath("//img[@class='_396cs4 _3exPp9']"));
    driver.findElement(By.xpath("//div[@class='_30kJiF']")).click();

// Group BY
    driver.get("C:/Seema Sel/OldFiles/groupbyindex.html");
    driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();

//Independent dependent ..traverse down and back up
    driver.get("C:/Seema%20Sel/OldFiles/ind_dep.html");
    String collection = driver.findElement(By.xpath("//td[text()='Bahubali2']/..//td[3]")).getText();
    System.out.println(collection);



//driver.findElement()
    String url1  =driver.getCurrentUrl();
    Thread.sleep(4000);
//
//        String html= driver.getPageSource();
//        System.out.println(html);
    //driver.close();
    driver.quit();
}

}
