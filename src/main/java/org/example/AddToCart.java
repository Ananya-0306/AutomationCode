package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCart {
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

//Automate to Navigate Homepage

        driver.get("https://pcchandraindia.com/");
        Thread.sleep(1000);

//Maximize current window

        driver.manage().window().maximize();

// Automate Accept Cookie

        driver.findElement(By.xpath("//a[@class='cc-btn cc-allow']")).click();
        Thread.sleep(7000);

// Find products in search bar

        WebElement searchBtn = driver.findElement(By.xpath("//li[@class='li-search for-desktop']//a"));
        searchBtn.click();

        WebElement searchBox = driver.findElement(By.id("search_keyword"));

        searchBox.	sendKeys("14KTDIJFPA3003");
        searchBox.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

// Add to wishlist

        WebElement wishlist = driver.findElement(By.xpath("//div[@class='product_top']//div[@class='wishlist']"));
        Thread.sleep(3000);

        wishlist.	click();
        Thread.sleep(2000);

// Go to Wishlist page

        driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/ul/li[8]/a")).click();
        Thread.sleep(1000);


// Locating the element

        WebElement e = driver.findElement(By.xpath("/html/body/main/section[2]/div/div/h1"));


//using getText method the retrieve the text of the element

        System.out.println(e.getText());


        driver.quit();

    }

}
