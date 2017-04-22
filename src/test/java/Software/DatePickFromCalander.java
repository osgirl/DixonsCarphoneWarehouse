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

        public void setup () throws InterruptedException {
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
                System.out.println(date);
                if (date.equals("22"))
                {
                    dates.get(i).click();
                    break;

                }
              //  System.out.println(dates);
            }
            System.out.println("onwards date selected");
            driver.findElement(By.xpath(".//*[@id='search_btn']")).click();
            System.out.println("pass");


            Thread.sleep(3000);

            driver.findElement(By.xpath(".//*[@id='buses_viewonward']/div/ul/li[2]/div[1]/div/div[1]/div[7]/div[2]/button")).click();
            driver.findElement(By.xpath(".//*[@id='buses_viewonward']/div/ul/li[2]/div[2]/div[1]/div[1]/div/div/div/div[3]/div/div[3]/canvas")).click();
            driver.findElement(By.xpath(".//*[@id='buses_viewonward']/div/ul/li[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[7]/button")).click();

        }

  //  now = Calendar.getInstance();
  //  now.add(Calendar.DATE, +50);
   // String FromDate =(now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.DATE) + "/" + now.get(Calendar.YEAR);



}

