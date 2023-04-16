package org.rahulshettyacademy;

import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.PageObjects.TravelHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

// Testcase -> TravelHomePage -> PageComponent -> AbstractComponent
public class DemoTest extends BaseTest {
    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setUp(){
        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }

       //Todo: Locators for multitrip and roundtrip still failing
    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String> reservationDetails)
    {
        travelHomePage.goTo();
        System.out.println("From Footer : "+travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println("From Footer : "+travelHomePage.getFooterNav().getLinkCount());

        System.out.println("From NavBar : "+travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println("From NavBar : "+travelHomePage.getNavigationBar().getLinkCount());

        // Using Strategy Design Pattern. The class to be called is decided at runtime
        //travelHomePage.setBookingStrategy(new RoundTrip(driver,sectionElement));
        //travelHomePage.checkAvail("MAA","GOI");

        //travelHomePage.setBookingStrategy(new MultiTrip(driver,sectionElement));
        //travelHomePage.checkAvail("MAA","GOI");

        // Using Factory design pattern allow us to create objects without specifying the exact class of the object it has to create
        travelHomePage.setBookingStrategy("multitrip");
        //travelHomePage.checkAvail(reservationDetails);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        /*HashMap<String,String> reservationDetails = new HashMap<>();
        reservationDetails.put("origin","MAA");
        reservationDetails.put("destination","GOI");
        reservationDetails.put("destination2","DEL");

        HashMap<String,String> reservationDetails1 = new HashMap<>();
        reservationDetails1.put("origin","DEL");
        reservationDetails1.put("destination","HYD");
        reservationDetails1.put("destination2","MAA");

        List<HashMap<String,String>> lis = new ArrayList<>();
        lis.add(reservationDetails);
        lis.add(reservationDetails1);*/

        // Replaced the above messy implementation with the cleaner getJsonData using json file
        String jsonFilePath = (System.getProperty("user.dir")+"/src/test/resources/reservationDetails.json");
        List<HashMap<String,String>> lis = getJsonData(jsonFilePath);

        return new Object[][]
                {
                        {lis.get(0)},{lis.get(1)}
                };
    }
}
