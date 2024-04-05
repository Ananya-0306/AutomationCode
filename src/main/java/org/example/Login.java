package org.example;
//prepared by Ananya Chatterjee
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;
public class Login {

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
        driver.get("https://pcchandraindia.com/");
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/ul/li[4]/a")).click();
        System.out.println("Navigate to Account Login");
        driver.findElement(By.id("login_email"));
        WebElement username=driver.findElement(By.id("login_email"));
        WebElement password=driver.findElement(By.id("password"));

        System.out.println("entering the email");
        username.sendKeys("ananya@sundewsolutions.com");
        Thread.sleep(5000);

        System.out.println("entering the Password");
        password.sendKeys("WZos+&72");
        Thread.sleep(5000);

        System.out.println("Click On submit Button");
        driver.findElement(By.id("login_btn")).click();

//Verify & Validate The Action
        System.out.println("verifying Login Credentials");
        String actualURL = "https://pcchandraindia.com/";
        String expectedURL = driver.getCurrentUrl(); // It will fetch the current URL
        Assert.assertEquals(expectedURL, actualURL); // It will verify both the URL are equal
        Thread.sleep(5000);

// Locating the element
        WebElement e = driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/ul/li[4]/div/span[1]/span"));

//using getText method the retrieve the text of the element
        System.out.println(e.getText());

//Close the browser window
        System.out.println("Loggedin Sucessfully :) ");
        driver.quit();

    }

}
