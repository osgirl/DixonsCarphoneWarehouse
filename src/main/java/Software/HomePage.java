package Software;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;


/**
 * Created by Mehul on 19/03/2017.
 */
public class HomePage extends DriverManager
{
     @FindBy (xpath = ".//*[@id='headerlinks']/ul/li[1]/a/span")   // storing location and will use in below method
      public WebElement _SelectShopWithUsDropDown;



    @FindBy  (xpath = ".//*[@id='headerlinks']/ul/li[1]/ul/li[1]/a/span")
       private WebElement _UKandIreland;

      @FindBy (xpath = ".//*[@id='headerlinks']/div/span")
       private WebElement _PopUpClose;




    public  void homePagePouUp() throws InterruptedException {


       Utility.clickOnElement(_SelectShopWithUsDropDown);  // select shop with us drop down manu
                                                          // clickOnElmnt method call for Utility class.
       Utility.clickOnElement(_UKandIreland);             //  click on UK&Ireland

           // popUp Window will come with different company website

       String homepage = driver.getWindowHandle();  // Pop up closing code
       String currentWindowId = null;
       System.out.println(homepage);

       Set<String> windows = driver.getWindowHandles();
       System.out.println(windows.size());

       Iterator<String> iterator = windows.iterator();

       while (iterator.hasNext())
       {
           currentWindowId = iterator.next();
           System.out.println(currentWindowId);
       }

       driver.switchTo().window(currentWindowId);

       Utility.clickOnElement(_PopUpClose);      // popup closing location

       System.out.println("Pop Up is closed");
   }
}
