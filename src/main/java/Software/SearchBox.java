package Software;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Mehul on 19/03/2017.
 */
public class SearchBox extends DriverManager
{

    @FindBy(xpath = ".//*[@id='SearchButtonContainer']")
    private WebElement _searchButton;

    @FindBy(xpath = ".//*[@id='searchTextbox']")
    private WebElement _searchBoxText;

    @FindBy(xpath = ".//*[@id='twoColWrapper']/div/div/div[5]/table/tbody/tr[1]/td/p[1]/a/strong")
    private WebElement _assertForCurrySearch;

    @FindBy (xpath = ".//*[@id='twoColWrapper']/div/div/div[5]/table/tbody/tr[1]/td/p[1]/a/strong")
    private  WebElement _assertForCarphoneWarehouseSearch;



    public  void searchBoxCheck () throws AWTException    // Robot class exception
    {
        Utility.clickOnElement(_searchButton);       // click on seachbutton

        Utility.enterText(_searchBoxText,"currys");  // type curry in search box for searching

        Robot enter = new Robot();           // Create object of Robot class for press enter
        enter.keyPress(KeyEvent.VK_ENTER); // Press Enter

        Assert.assertEquals(_assertForCurrySearch.getText(),"currys-wisbech.pdf");


        Utility.clickOnElement(_searchButton);       // click on seachbutton

        Utility.enterText(_searchBoxText,"carphone warehouse");  // type carphone warehouse in search box for searching

        enter.keyPress(KeyEvent.VK_ENTER); // Used Robte class object for Press Enter

        Utility.isEliment_Presant(_assertForCarphoneWarehouseSearch);
    }



}
