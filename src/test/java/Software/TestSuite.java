package Software;

import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by Mehul on 19/03/2017.
 */
public class TestSuite extends DriverManager
{
   @Test
    public static void homePagePopupHandling ()
    {
        HomePage homePage = new HomePage();       // methord called
        homePage.homePagePouUp();
    }


//    @Test
//        public static void verifySearchBox()
//        {
//            SearchBox searchBox = new SearchBox();
//
//            try {
//                searchBox.searchBoxCheck();
//            } catch (AWTException e) {
//                e.printStackTrace();
//            }
//    }
}
