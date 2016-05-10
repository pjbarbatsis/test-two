package tests;

import base.BasePageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.HomePage;

import java.util.concurrent.TimeUnit;

/**
 * Created by pbarbats on 5/6/16.
 */
public class SearchFlightTest {
    private WebDriver driver;

    /**
     * Setting up framework for testing
     */
    @Before
    public void testSetUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void testShutDown() {
        driver.close();
    }

    @Test
    /**
     * Searches for flights between MSP and ATL.
     */
    public void searchForFlights() {
        driver.get("https://www.expedia.com/");
        HomePage homePage = new HomePage(driver);
        homePage.fillFormWithData(driver);
        homePage.clickOnSearch();
        //TODO: Assert results
    }
}
