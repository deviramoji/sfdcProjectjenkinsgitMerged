package sfdcWebapgeproj;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class sfdcWebpage {

   public static WebDriver driver;
   public static ExtentReports extent;
   public static ExtentHtmlReporter htmlReporter;
   public static ExtentTest test;
   public static FileInputStream fileInput;
    public static Properties prop;

   public static void  launchChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.get("https://Login.salesforce.com");
//        test.log(Status.INFO,"Browser is launched");
    }
    public static void  closeChromeBrowser(){
        driver.close();
        test.log(Status.INFO,"Browser is closed");
    }
    public static void maximizePage(){
        driver.manage().window().maximize();
    }

    public static void implicitWait(int a) {
        driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
    }

//    public static void driverGet(String key){
//         driver.get(prop.getProperty(key));
////      driver.get(key);
//
//    }

public void property() {
    File file = new File("/Users/priyaramoji/IdeaProjects/Selenium/src/test/java/datafile.properties/");
    try {
        fileInput = new FileInputStream(file);
    } catch (
            FileNotFoundException e) {
        e.printStackTrace();
    }
    prop = new Properties();

    //load properties file
    try {
        prop.load(fileInput);
    } catch (
            IOException e) {
        e.printStackTrace();
    }
    //return prop;
}
    public static void sendValue(WebElement a, String input){
        //WebElement a;
        a.sendKeys(input);

    }

    public static void clicktheElement(WebElement a){
        //WebElement a;
        a.click();

    }
//    public static void closeIt(WebElement a){
//        //WebElement a;
//        a.cl;

//    }

}


