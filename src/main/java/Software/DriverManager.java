package Software;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mehul on 19/03/2017.
 */
public class DriverManager
{
    protected static WebDriver driver;

    public DriverManager ()
    {
        PageFactory.initElements(driver,this);
    }

    @BeforeMethod
    public  void setUp()

    {
        driver=new FirefoxDriver();
        driver.get("http://www.dixonscarphone.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        System.out.println("setup method pass");

    }
    @AfterMethod
    public  void tearDown()
    {
        driver.quit();
    }
}
