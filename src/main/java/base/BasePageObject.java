package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by pbarbats on 5/6/16.
 */
public class BasePageObject {

    public WebDriver driver;

    public BasePageObject(WebDriver driver){
        this.driver = driver;

    }
}
