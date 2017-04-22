package Software;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static sun.security.pkcs.PKCS8Key.version;

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
    public  void setUp() throws MalformedURLException

    {

        String USERNAME = "mehulkbhimani";
        String ACCESS_KEY = "62092933-9704-4aa8-9761-c928fbbe848b";
        String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";


        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows XP");
        caps.setCapability("version", "43.0");
        caps.setCapability("name", " Carphone Sauce Test");

        driver = new RemoteWebDriver(new URL(URL), caps);

//       * Goes to Sauce Lab's guinea-pig page and prints title

        driver.get("https://saucelabs.com/test/guinea-pig");
        System.out.println("title of page is: " + driver.getTitle());

                  driver.get("http://www.dixonscarphone.com/");
                  System.out.println("title of page is: " + driver.getTitle());

                  //  driver=new FirefoxDriver();
                  //  driver.get("http://www.dixonscarphone.com/");
                  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                  driver.manage().window().maximize();
                  driver.manage().deleteAllCookies();
                  System.out.println("setup method pass..");

                  }
          @AfterMethod
              public  void tearDown()
            {
                 driver.quit();
            }
        }
