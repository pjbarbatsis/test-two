package page;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by pbarbats on 5/6/16.
 */
public class HomePage extends BasePageObject {


    /**
     * Verifies that the homepage is the homepage based on its title, with a FluentWait to help ease
     * transitions.
     * @param driver is the current browser
     */

    public HomePage(WebDriver driver) {
        super(driver);
        Wait wait = new FluentWait(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(2, SECONDS);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-lobtab=flight]")));
    }
    /**
     * Elements annotated with FindBy annotation for ease of making Page Objects with PageFactory at some point
     * in the future.
     */


    public ResultsPage clickOnSearch() {
        WebElement searchButton = driver.findElement(By.id("search-button"));
        searchButton.click();
        return new ResultsPage(this.driver);
    }

    public void fillFormWithData() {
        //Click flight tab, fill in flight departure and returning details.
        WebElement flightTab = driver.findElement(By.cssSelector("li[data-lobtab=flight]"));
        flightTab.click();
        WebElement flightOrigin = driver.findElement(By.id("flight-origin"));
        flightOrigin.click();
        flightOrigin.sendKeys("Minneapolis");
        WebElement flightDestination = driver.findElement(By.id("flight-destination"));
        flightDestination.click();
        flightDestination.sendKeys("Atlanta");
        WebElement flightDeparting = driver.findElement(By.id("flight-departing"));
        flightDeparting.click();
        flightDeparting.sendKeys("05/20/2016");
        WebElement flightReturning = driver.findElement(By.id("flight-returning"));
        flightReturning.click();
        // Expedia fills in the text box, so you need to clear it.
        flightReturning.clear();
        flightReturning.sendKeys("05/26/2016");
    }
}
