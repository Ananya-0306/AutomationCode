package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class GetInTouch {
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
        System.out.println("opening PC Chandra Contact Us Page");
        driver.get("https://pcchandraindia.com/contact-us");
        Thread.sleep(5000);

        //Allow Cookie
        driver.findElement(By.xpath("//a[@class='cc-btn cc-allow']")).click();
        Thread.sleep(5000);

        System.out.println("Entering all the required details");

        driver.findElement(By.id("name"));
        WebElement username=driver.findElement(By.id("name"));
        WebElement email=driver.findElement(By.id("email"));
        WebElement phoneNumber=driver.findElement(By.id("contact_number"));
        WebElement subject=driver.findElement(By.id("subject"));
        WebElement message=driver.findElement(By.id("message"));
        Thread.sleep(5000);

        System.out.println("entering the Name");
        username.sendKeys("Ananya Sundew Test");
        Thread.sleep(5000);

        System.out.println("entering the Email");
        email.sendKeys("ananya@sundewsolutions.com");
        Thread.sleep(5000);

        System.out.println("entering the Phone Number");
        phoneNumber.sendKeys("8987818847");
        Thread.sleep(5000);

        System.out.println("entering the Subject");
        subject.sendKeys("Hi this is daily checklist from Sundew Solutions by Ananya Chatterjee :D ");
        Thread.sleep(5000);

        System.out.println("entering the Message");
        message.sendKeys("Hi this is daily checklist from Sundew Solutions by Ananya Chatterjee :D");
        Thread.sleep(5000);

        /// here we have to verify captcha
        // Math Captcha value
        // Find the element that contains the CAPTCHA mathematical expression
        WebElement captchaElement1 = driver.findElement(By.id("dyn_num1"));
        WebElement captchaElement2 = driver.findElement(By.id("dyn_num2"));

        // Get the text of the CAPTCHA mathematical expression
        String captchaText1 = captchaElement1.getText();
        String captchaText2 = captchaElement2.getText();

        // Solve the CAPTCHA mathematical expression
        int result = solveCaptcha(captchaText1,captchaText2);
        // Find the input field for the CAPTCHA solution
        WebElement captchaInput = driver.findElement(By.id("capt"));
        // Enter the solution into the input field
        captchaInput.sendKeys(String.valueOf(result));

        Thread.sleep(3000); // Add a delay of 1 second before retrying
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/form/div[7]/div/button")).click();
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        //element.click();

        //Verify & Validate The Action
        System.out.println("verifying Actual Page URL with the expected URL");
        String actualURL = "https://pcchandraindia.com/contact-us";
        String expectedURL = driver.getCurrentUrl(); // It will fetch the current URL
        Assert.assertEquals(expectedURL, actualURL); // It will verify both the URL are equal
        Thread.sleep(5000);

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

