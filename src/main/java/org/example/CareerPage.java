package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

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
        WebElement positionappliedfor=driver.findElement(By.id("position"));
        positionappliedfor.sendKeys("QA Test by sundew solutions");
        Thread.sleep(1000);

        System.out.println("entering the Name");
        WebElement username=driver.findElement(By.id("name"));
        username.sendKeys("Ananya Sundew Test");
        Thread.sleep(1000);

        System.out.println("entering the Email");
        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("ananya@sundewsolutions.com");
        Thread.sleep(1000);

        System.out.println("entering the Phone Number");
        WebElement phoneNumber=driver.findElement(By.id("contact_number"));
        phoneNumber.sendKeys("8987818847");
        Thread.sleep(1000);

        System.out.println("What is your qualifications");
        WebElement qualification=driver.findElement(By.id("qualification"));
        qualification.sendKeys("Hi this is daily checklist from Sundew Solutions by Ananya Chatterjee :D");
        Thread.sleep(1000);

        //Handle dropdown
        driver.findElement(By.id("experience")).click();

        List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));

        String option = "2 - 3 years";

        // Iterate the list using for loop

        for (WebElement allOption : allOptions) {

            if (allOption.getText().contains(option)) {

                allOption.click();

                System.out.println("clicked");

                break;

            }

        }

        System.out.println("What is your Comments");
        driver.findElement(By.id("comment"));
        WebElement comments=driver.findElement(By.id("comment"));
        comments.sendKeys("Hi this is daily checklist from Sundew Solutions by Ananya Chatterjee :D");
        Thread.sleep(1000);

        //Uploading file
//        WebElement element = driver.findElement(By.className("selectedvalue"));
        //element.sendKeys("C://Users//USER//Downloads//IITK Security Testing.pdf");
        driver.findElement(By.id("resume")).sendKeys("C://Users//USER//Downloads//IITK Security Testing.pdf");


        // here we have to verify captcha
        WebElement captchaElement1 = driver.findElement(By.id("dyn_num1"));
        WebElement captchaElement2 = driver.findElement(By.id("dyn_num2"));

        // Get the text of the CAPTCHA mathematical expression
        String captchaText1 = captchaElement1.getText();
        String captchaText2 = captchaElement2.getText();
        int result = solveCaptcha(captchaText1,captchaText2);
        WebElement captchaInput = driver.findElement(By.id("capt"));
        captchaInput.sendKeys(String.valueOf(result));

        //Click on submit button
        System.out.println("Click On submit Button");
//        driver.findElement(By.id("career_submit")).click();

        Thread.sleep(1000); // Add a delay of 1 second before retrying
        driver.findElement(By.id("career_submit")).click();
        //Thread.sleep(9000);

        //Close the browser window
        System.out.println("Form Submitted Successfully :D ");
        driver.quit();

    }
    private static int solveCaptcha(String captchaText1,String captchaText2) {
        // Split the captcha text to separate the operands and operator
//        String[] parts = captchaText.split(" ");
        String onlyNumber = captchaText2.replaceAll("[^0-9]", "");
        int operand1 = Integer.parseInt(captchaText1);
        int operand2 = Integer.parseInt(onlyNumber);
//        char operator = parts[1].charAt(0);
        char operator = '+';

        // Perform the arithmetic operation based on the operator
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

}
