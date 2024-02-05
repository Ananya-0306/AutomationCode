package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;
public class Newsletter {

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
    public void testNewsletterFormSubmission() throws InterruptedException {
        System.out.println("opening PC Chandra site");
        driver.get("https://pcchandraindia.com/");

        Thread.sleep(7000);
        System.out.println("Navigating Newsletter section");
        WebElement emailInput = driver.findElement(By.id("newsletter_email"));

        //Allow Cookie
        driver.findElement(By.xpath("//a[@class='cc-btn cc-allow']")).click();
        Thread.sleep(7000);

        System.out.println("Enter your valid email Id to subscribe our newsletter");
        emailInput.sendKeys("sundew2024happynewyeartest@ananyatest.com");
        Thread.sleep(5000);

        emailInput.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        String expPageTitle = "Great, You are successfully subscribed.";

        boolean flag = false;

        if (driver.getTitle().equalsIgnoreCase(expPageTitle)) {
            WebElement e = driver.findElement(By.id("success_registration"));
            System.out.println(e.getText());

        } else {
            WebElement e = driver.findElement(By.id("error_registration"));
            System.out.println(e.getText());

        }

        driver.quit();

    }
    }
