package SeleniumWebDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class searchProductAmazon {

    @Test
  public void buyProduct() throws InterruptedException {

      System.setProperty("webdriver.chrome.driver", "/Users/pedro/Documents/sw_test/chromedriver");
      WebDriver driver=new ChromeDriver();
      driver.get("https://www.amazon.com.mx/");
      Thread.sleep(4000);
      WebElement search = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
      search.sendKeys("kindle");
      WebElement clickOnSeach = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-text\"]"));
      clickOnSeach.click();
      //opene new tab for results

        WebElement validateTextOfResults = driver.findElement(By.xpath("//h1//div/span[contains(.,'kindle')]"));
        System.out.println(validateTextOfResults.getText());
        Assert.assertEquals(validateTextOfResults.getText(), "\"kindle\"");

        Thread.sleep(4000);

        WebElement selectProductN2 = driver.findElement(By.xpath("//div[@data-index=2]"));
        selectProductN2.click();

        Thread.sleep(4000);

        WebElement addCart = driver.findElement(By.id("id=\"add-to-cart-button\""));
        addCart.click();

        //agrrgar al carrito pending

        //validar text agregado al carrito (Agregado al carrito) pending

  }


}
