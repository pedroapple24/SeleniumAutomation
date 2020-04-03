import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;

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





}


