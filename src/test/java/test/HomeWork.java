package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

public class HomeWork {
    private WebDriver driver;

    @Before
    public  void setUp(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");

    }
    @After
    public void testDown(){
        driver.close();
    }

    @Test
    public void checkingDisplayCategory() {
       WebDriver driver = new ChromeDriver();

       driver.get("https://rozetka.com.ua");
       //3
       WebElement personalCabinet = driver.findElement(By.xpath("//span/a[@name='signin']"));
       personalCabinet.click();

       WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
       login.sendKeys("daryna_horobei1@ukr.net");
       driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

       WebElement password = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
       password.sendKeys("Qwe123");
       driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

       WebElement submitAuth = driver.findElement(By.xpath("//button[@name='auth_submit']"));
       driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
       submitAuth.click();

       //1
       WebElement rozetkaCategory = driver.findElement(By.xpath("//a[contains(text(),'Красота')]"));
       rozetkaCategory.click();

       WebElement displayedCategory = driver.findElement(By.xpath("//h1[contains(text(),'Красота')]"));
       Assert.assertTrue(displayedCategory.isDisplayed());

        //2
       WebElement title = driver.findElement(By.xpath("//title[contains(text(), 'Красота')]"));

       WebElement parfumeBlock = driver.findElement(By.xpath("//p[@class='pab-h3']/a[contains(text(), 'Парфюмерия')]"));
       parfumeBlock.click();

       WebElement womenParfume = driver.findElement(By.xpath("(//a[contains(text(), 'Женская')])[2]"));
       womenParfume.click();

       WebElement dolceGabbanaPerfume = driver.findElement(By.xpath("(//a[contains(text(), 'Gabbana')])[1]"));
       dolceGabbanaPerfume.click();

       WebElement buyButton = driver.findElement(By.xpath("//button[contains(text(), 'Купить')]"));
       buyButton.click();

       driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
       driver.navigate().to("https://rozetka.com.ua");

       WebElement basket = driver.findElement(By.xpath("//span[@class='xhr']"));
       basket.click();

       WebElement goodInBasket = driver.findElement(By.xpath("(//a[contains(text(),'Gabbana')])[1]"));
       Assert.assertTrue(goodInBasket.isDisplayed());
     }
}
