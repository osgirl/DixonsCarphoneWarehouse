package Software;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import static Software.DriverManager.driver;

/**
 * Created by Mehul on 19/03/2017.
 */
public class Utility
{
    public static void enterText(WebElement element, String text)
    {
        element.clear();
        element.sendKeys(text);
    }
    public static void clickOnElement(WebElement element)
    {
        element.click();
    }

    public static String get_Text (WebElement element)
    {
        return element.getText();
    }

    public static boolean isEliment_Presant (WebElement element)

    {
        return element.isDisplayed();
    }

    public static void actionHover(WebElement element)
    {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

}
