import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumWebDriver {


    @Test
    public void testGoogleSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/pedro/Documents/sw_test/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");
        Thread.sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }

    @Test
    public void radioButton(){

        System.setProperty("webdriver.chrome.driver", "/Users/pedro/Documents/sw_test/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/ajax.html");
        driver.findElement(By.id("no")).click();
        driver.findElement(By.id("buttoncheck")).click();
    }

    @Test
    public void findElements(){

        System.setProperty("webdriver.chrome.driver", "/Users/pedro/Documents/sw_test/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/ajax.html");
        List<WebElement> elements = driver.findElements(By.name("name"));
        System.out.println("Number of elements:" +elements.size());

        for (int i=0; i<elements.size();i++){
            System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
        }
    }

    @Test
    public void Form(){

        System.setProperty("webdriver.chrome.driver", "/Users/pedro/Documents/sw_test/chromedriver");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://demo.guru99.com/test/login.html";
        driver.get(baseUrl);
        // Get the WebElement corresponding to the Email Address(TextField)
        WebElement email = driver.findElement(By.id("email"));
        // Get the WebElement corresponding to the Password Field
        WebElement password = driver.findElement(By.name("passwd"));
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        System.out.println("Text Field Set");
        // Deleting values in the text box
        email.clear();
        password.clear();
        System.out.println("Text Field Cleared");
        // Find the submit button
        WebElement login = driver.findElement(By.id("SubmitLogin"));
        // Using click method to submit form
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        login.click();
        System.out.println("Login Done with Click");
        //using submit method to submit the form. Submit used on password field
        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
        driver.findElement(By.id("SubmitLogin")).submit();
        System.out.println("Login Done with Submit");
        //driver.close();
    }

    @Test
    public void checkBox(){

        System.setProperty("webdriver.chrome.driver", "/Users/pedro/Documents/sw_test/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/test/radio.html");
        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));

        //Radio Button1 is selected
        radio1.click();
        System.out.println("Radio Button Option 1 Selected");

        //Radio Button1 is de-selected and Radio Button2 is selected
        radio2.click();
        System.out.println("Radio Button Option 2 Selected");

        // Selecting CheckBox
        WebElement option1 = driver.findElement(By.id("vfb-6-0"));

        // This will Toggle the Check box
        option1.click();

        // Check whether the Check box is toggled on
        if (option1.isSelected()) {
            System.out.println("Checkbox is Toggled On");

        } else {
            System.out.println("Checkbox is Toggled Off");
        }

        //Selecting Checkbox and using isSelected Method
        driver.get("http://demo.guru99.com/test/facebook.html");
        WebElement chkFBPersist = driver.findElement(By.id("persist_box"));
        for (int i=0; i<2; i++) {
            chkFBPersist.click ();
            System.out.println("Facebook Persists Checkbox Status is -  "+chkFBPersist.isSelected());
        }
        //driver.close();
    }

    @Test
    public void clickOnImage(){

        String baseUrl = "https://www.facebook.com/login/identify?ctx=recover";
        System.setProperty("webdriver.chrome.driver", "/Users/pedro/Documents/sw_test/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get(baseUrl);
        //click on the "Facebook" logo on the upper left portion
        driver.findElement(By.cssSelector("a[title=\"Ir a la página de inicio de Facebook\"]")).click();
        //<a href="https://www.facebook.com/" title="Ir a la página de inicio de Facebook"><i class="fb_logo img sp_lMWDbGC4nGf_2x sx_3bfd4e"><u>Facebook</u></i></a>

        //verify that we are now back on Facebook's homepage
        if (driver.getTitle().equals("Facebook - Inicia sesión o regístrate")) {

            //<title id="pageTitle">Facebook - Inicia sesión o regístrate</title>
            System.out.println("We are back at Facebook's homepage");
        } else {
            System.out.println("We are NOT in Facebook's homepage");
        }
        driver.close();
    }

    @Test
    public void acessDrop(){

        System.setProperty("webdriver.gecko.driver","/Users/pedro/Documents/sw_test/geckodriver");
        String baseURL = "http://demo.guru99.com/test/newtours/register.php";
        WebDriver driver = new FirefoxDriver();
        driver.get(baseURL);

        Select drpCountry = new Select(driver.findElement(By.name("country")));
        drpCountry.selectByVisibleText("ANTARCTICA");

        //Selecting Items in a Multiple SELECT elements
        driver.get("http://jsbin.com/osebed/2");
        Select fruits = new Select(driver.findElement(By.id("fruits")));
        fruits.selectByVisibleText("Banana");
        fruits.selectByIndex(1);
    }
    @Test
    public void byList(){
        String baseUrl = "http://demo.guru99.com/test/link.html";
        System.setProperty("webdriver.gecko.driver","/Users/pedro/Documents/sw_test/geckodriver");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.linkText("click here")).click();
        System.out.println("title of page is: " + driver.getTitle());
        driver.quit();
    }

    @Test
    public void mouseClick(){
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        System.setProperty("webdriver.gecko.driver","/Users/pedro/Documents/sw_test/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl);
        WebElement link_Home = driver.findElement(By.linkText("Home"));
        WebElement td_Home = driver
                .findElement(By
                        .xpath("//html/body/div"
                                + "/table/tbody/tr/td"
                                + "/table/tbody/tr/td"
                                + "/table/tbody/tr/td"
                                + "/table/tbody/tr"));

        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(link_Home)
                .build();

        String bgColor = td_Home.getCssValue("background-color");
        System.out.println("Before hover: " + bgColor);
        mouseOverHome.perform();
        bgColor = td_Home.getCssValue("background-color");
        System.out.println("After hover: " + bgColor);
        driver.close();
    }

    @Test
    public void clickTest(){
        System.setProperty("webdriver.gecko.driver","/Users/pedro/Documents/sw_test/geckodriver");

        String baseUrl = "http://www.facebook.com/";
        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl);
        WebElement txtUsername = driver.findElement(By.id("email"));

        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .moveToElement(txtUsername)
                .click()
                .keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, "hello")
                .keyUp(txtUsername, Keys.SHIFT)
                .doubleClick(txtUsername)
                .contextClick()
                .build();

        seriesOfActions.perform() ;
    }

    @Test
    public void upload(){
        System.setProperty("webdriver.gecko.driver","/Users/pedro/Documents/sw_test/geckodriver");
        String baseUrl = "http://demo.guru99.com/test/upload/";
        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("/Users/pedro/Documents/sw/sample.txt");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
    }

}

