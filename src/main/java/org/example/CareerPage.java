package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CareerPage {
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
        System.out.println("opening PC Chandra Career Page");
        driver.get("https://pcchandraindia.com/career");
        Thread.sleep(5000);

        //Allow Cookie
        driver.findElement(By.xpath("//a[@class='cc-btn cc-allow']")).click();
        Thread.sleep(3000);

        System.out.println("Entering all the required details");

        System.out.println("Entering position applying for");
        driver.findElement(By.id("position"));
        WebElement positionappliedfor=driver.findElement(By.id("position"));
        positionappliedfor.sendKeys("QA Test by sundew solutions");
        Thread.sleep(1000);

        System.out.println("entering the Name");
        driver.findElement(By.id("name"));
        WebElement username=driver.findElement(By.id("name"));
        username.sendKeys("Ananya Sundew Test");
        Thread.sleep(1000);

        System.out.println("entering the Email");
        driver.findElement(By.id("email"));
        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("ananya@sundewsolutions.com");
        Thread.sleep(1000);

        System.out.println("entering the Phone Number");
        driver.findElement(By.id("contact_number"));
        WebElement phoneNumber=driver.findElement(By.id("contact_number"));
        phoneNumber.sendKeys("8987818847");
        Thread.sleep(1000);

        System.out.println("What is your qualifications");
        driver.findElement(By.id("qualification"));
        WebElement qualification=driver.findElement(By.id("qualification"));
        qualification.sendKeys("Hi this is daily checklist from Sundew Solutions by Ananya Chatterjee :D");
        Thread.sleep(1000);

        System.out.println("What is your Comments");
        driver.findElement(By.id("comment"));
        WebElement comments=driver.findElement(By.id("comment"));
        comments.sendKeys("Hi this is daily checklist from Sundew Solutions by Ananya Chatterjee :D");
        Thread.sleep(1000);

        //Uploading file
        driver.findElement(By.className("file1")).click();
        WebElement browse = driver.findElement(By.className("file1"));
        browse.sendKeys("C:/Users/SDS/Downloads/PCC041020234243816719.pdf"); //Uploading the file using sendKeys
        System.out.println("File is Uploaded Successfully");
        Thread.sleep(1000);

        System.out.println("Click On submit Button");
        driver.findElement(By.id("career_submit")).click();
        Thread.sleep(1000);

        //Verify & Validate The Action
        System.out.println("verifying Actual Page URL with the expected URL");
        if(driver.findElement(By.xpath(".//a[text()='image (61).png']")).isDisplayed()) {
            assertTrue(true, "Resume Uploaded");
        }else {
            assertFalse(false, "resume not Uploaded");
        }
        Thread.sleep(5000);

        //Close the browser window
        System.out.println("Form Submitted Successfully :D ");
        driver.quit();

    }
}
