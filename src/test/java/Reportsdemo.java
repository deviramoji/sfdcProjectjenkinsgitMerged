import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reportsdemo {

 static WebDriver driver;
 static ExtentReports extent;
 static  ExtentHtmlReporter htmlReporter;

    static {
        String addDate= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        extent = new ExtentReports();
        htmlReporter = new ExtentHtmlReporter("/Users/priyaramoji/IdeaProjects/Selenium/Reportsproj/SFDCCReport.html"+addDate+".html");
        extent.attachReporter(htmlReporter);
    }


public static void main(String args[]) throws IOException {
 testcase_login();

   }

   public static void testcase_login() throws IOException{
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       ExtentTest test = extent.createTest("Login_error_Msg01");
       driver.get("https://xxx-b-dev-ed.my.salesforce.com/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       WebElement a = driver.findElement(By.xpath("//input[@id='username']"));
       WebElement b = driver.findElement(By.xpath("//input[@id='password']"));
       WebElement c = driver.findElement(By.xpath("//input[@id='Login']"));
       WebElement rememberMe = driver.findElement(By.xpath("//input[@id='rememberUn']"));
       a.sendKeys("priyaramoji@gmail.com");
       test.log(Status.INFO, "Username has been entered");
       b.sendKeys("priya34");
       test.log(Status.INFO, "Pwd has been entered");
       rememberMe.click();
       c.click();
       System.out.println("clicked succesfully");
       test.pass("test pssed");
       WebElement errormsg = driver.findElement(By.xpath("//div[@id='error']"));
           if (errormsg.getText().equals("Please enter your password.")) {
               System.out.println("Error message displayed succesfully : " + errormsg.getText());
               test.pass("error message is displayed successfully");
           }
           else {
               TakesScreenshot screenshot = (TakesScreenshot)driver;
               File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
               File dstFile = new File("/Users/priyaramoji/IdeaProjects/Selenium/Reportsproj/Screenshots/firstcapture.PNG");
               FileUtils.copyFile(srcfile,dstFile);
               test.addScreenCaptureFromPath("/Users/priyaramoji/IdeaProjects/Selenium/Reportsproj/Screenshots/firstcapture.PNG");
               test.fail("invalid error msg is displayed");
           }
       driver.close();
       extent.flush();
   }


}


