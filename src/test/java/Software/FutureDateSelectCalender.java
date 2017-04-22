package Software;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mehul on 22/04/2017.
 */
public class FutureDateSelectCalender
{

    @Test

    public void setup () throws InterruptedException, AWTException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://www.redbus.in/");


        driver.findElement(By.xpath(".//*[@id='src']")).sendKeys("Ahmedabad");
        driver.findElement(By.xpath(".//*[@id='dest']")).sendKeys("Mumbai");
        driver.findElement(By.xpath(".//*[@id='search']/div/div[3]/span")).click();

        List<WebElement> dates = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table//td"));

        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, +7);  // add 7 days on current date

      //  String FromDate =(now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.DATE) + "/" + now.get(Calendar.YEAR);

        String FromDate = String.valueOf(now.get(Calendar.DATE));  // store after 7 days date on String
        System.out.println(FromDate);

        int total_nods =  dates.size();

        for (int i = 0; i < total_nods ; i++)
        {
            String date =  dates.get(i).getText();
            if (date.equals(FromDate))
            {
                dates.get(i).click();
                break;

            }


        }
        System.out.println("After 7 day date selected");
        Thread.sleep(4000);

       // driver.findElement(By.xpath(".//*[@id='search_btn']")).click();  // Search button location

        Robot enter = new Robot();           // Create object of Robot class for press enter this throes exception AWTException
        enter.keyPress(KeyEvent.VK_ENTER); // Press Enter

        System.out.println("Search Button selected");

    }
}
