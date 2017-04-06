package Software;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static Software.DriverManager.driver;


/**
 * Created by Mehul on 04/04/2017.
 */
public class DatePickFromCalander
{


    @Test

        public void setup ()
        {
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("http://www.redbus.in/");


              driver.findElement(By.xpath(".//*[@id='src']")).sendKeys("Ahmedabad");
              driver.findElement(By.xpath(".//*[@id='dest']")).sendKeys("Mumbai");
              driver.findElement(By.xpath(".//*[@id='search']/div/div[3]/span")).click();

              List<WebElement> dates = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table//td")); // make dynamic xpath

           int total_nods =  dates.size();

            for (int i = 0; i < total_nods ; i++)
            {
                  String date =  dates.get(i).getText();
                if (date.equals("5"))
                {
                    dates.get(i).click();
                    break;

                }
                System.out.println("onwards date selected");
            }
            System.out.println("onwards date selected");
            driver.findElement(By.xpath(".//*[@id='search_btn']")).click();
            System.out.println("pass");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            driver.findElement(By.xpath(".//*[@id='buses_viewonward']/div/ul/li[2]/div[1]/div/div[1]/div[7]/div[2]/button")).click();
            driver.findElement(By.xpath(".//*[@id='buses_viewonward']/div/ul/li[2]/div[2]/div[1]/div[1]/div/div/div/div[3]/div/div[3]/canvas")).click();
            driver.findElement(By.xpath(".//*[@id='buses_viewonward']/div/ul/li[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[7]/button")).click();

        }





}

