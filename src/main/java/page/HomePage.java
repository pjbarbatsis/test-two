package page;

import base.BasePageObject;
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
        super();
        Wait wait = new FluentWait(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(2, SECONDS);

        wait.until(ExpectedConditions.titleContains("Expedia Travel"));
    }
    /**
     * Elements annotated with FindBy annotation for ease of making Page Objects with PageFactory at some point
     * in the future.
     */

    @FindBy(id = "flight-origin")
    private static WebElement flightOrigin;

    @FindBy(id = "flight-destination")
    private WebElement flightDestination;

    @FindBy(id = "flight-departing")
    private WebElement flightDeparting;

    @FindBy(id = "flight-returning")
    private WebElement flightReturning;

    @FindBy(xpath = ".//*[@id='home-page']/div[18]/div/div/section[1]/ul/li[20]/a")
    private WebElement departDate;

    @FindBy(xpath = ".//*[@id='home-page']/div[18]/div/div/section[1]/ul/li[26]/a")
    private WebElement returnDate;

    @FindBy(id = "search-button")
    private WebElement searchButton;


    public ResultsPage clickOnSearch() {
        searchButton.click();
        return new ResultsPage();
    }

    public void fillFormWithData(WebDriver driver) {

        //Fill data here
        flightOrigin.click();
        flightOrigin.sendKeys("Minneapolis");
        flightDestination.click();
        flightDestination.sendKeys("Atlanta");
        flightDeparting.click();
        departDate.click();
        flightReturning.click();
        returnDate.click();
    }
}
