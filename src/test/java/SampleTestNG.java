import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleTestNG {

    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "/Users/pedro/Documents/sw_test/geckodriver";
    public WebDriver driver;

    @Test
    public void verifyHomepageTitle() {

        System.out.println("launching firefox browser");
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.close();
    }
}
