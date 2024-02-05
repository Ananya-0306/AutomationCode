package org.example;  

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;
public class CorporateGiftPage {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {

        //Setting system properties of ChromeDriver
        System.setProperty("web-driver.chrome.driver", "C://Users//SDS//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe/");
        System.setProperty("web-driver.http.factory", "jdk-http-client");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testLogin() throws InterruptedException {
        System.out.println("opening PC Chandra site");
        driver.get("https://pcchandraindia.com/corporate-gifting");
        Thread.sleep(5000);

// Locating the element

        WebElement e = driver.findElement(By.xpath("/html/body/section[1]/div/div/h3/i"));


//using getText method the retrieve the text of the element

        System.out.println(e.getText());


        driver.quit();

    }

}