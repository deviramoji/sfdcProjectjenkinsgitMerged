package sfdcWebapgeproj;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.sun.org.apache.xerces.internal.xs.StringList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class sfdcWebpage {

    public static WebDriver driver;
    public static ExtentReports extent = null;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest test = null;
    public static FileInputStream fileInput;
    public static Properties prop;

    static {
        String addDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        extent = new ExtentReports();
        htmlReporter = new ExtentHtmlReporter("/Users/priyaramoji/IdeaProjects/Selenium/Reportsproj/SFDCCReport.html" + addDate + ".html");
        extent.attachReporter(htmlReporter);
    }

    public static void launchChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://Login.salesforce.com");
        test.log(Status.INFO, "Browser is launched");
    }

    public static void closeChromeBrowser() {
        driver.close();
        test.log(Status.INFO, "Browser is closed");
    }

    public static void maximizePage() {
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

    public String property(String filename , String keyName) {
        File file = new File("/Users/priyaramoji/IdeaProjects/Selenium/src/Testdata/datafile.properties/");
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
        return prop.getProperty(keyName);

    }

    public static void sendValue(WebElement a, String input) {
        //WebElement a;
        a.sendKeys(input);

    }

    public static void clicktheElement(WebElement a) {
        //WebElement a;
        a.click();

    }

    // @Test(dataProvider = "valid_loginData", dataProviderClass = dataprovider.class)
   public static void loginsfdc(String usrname, String pwd) throws IOException {
        WebElement a = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement b = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement c = driver.findElement(By.xpath("//input[@id='Login']"));
        WebElement rememberMe = driver.findElement(By.xpath("//input[@id='rememberUn']"));
        sendValue(a, usrname);
        sendValue(b, pwd);
        clicktheElement(rememberMe);
        clicktheElement(c);
        /**explicit wait - to wait for the compose button to be click-able**/
        try {
            WebElement d = driver.findElement(By.id("userNavLabel"));
            WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNavLabel")));
            String z = d.getText();
            System.out.println(z);

            if (z.equals("Devi Ramoji")) {
                System.out.println("User is logged in successfully : " + z);
                //d.click();
            } else {
                System.out.println("User name is incorrect");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred" + e);
        }
    }

       public static void  verifyUsermenu(String ElementXapth) throws IOException {
            List<WebElement> userMenuItems = driver.findElements(By.xpath(ElementXapth));
            String[] ExpectedmenuItems = {"My Profile", "My Settings","Developer Console","Switch to Lightning Experience","Logout"};

            for(int i=0; i<userMenuItems.size();i++) {
                System.out.println(userMenuItems.get(i).getText());
                Assert.assertEquals(userMenuItems.get(i).getText(),ExpectedmenuItems[i]);
                test.log(Status.INFO,ExpectedmenuItems[i]+" is Verified");
            }
        }
        public static void verifytext(String text, String keyName)throws IOException{
            System.out.println(text + ";" + keyName);
        Assert.assertEquals(text, keyName);
        test.log(Status.INFO, text + "is verified" );
        }

    public static String takeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        String addDate= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String destinationPath = "/Users/priyaramoji/IdeaProjects/Selenium/Reportsproj/Screenshots/firstcapture"+addDate+".PNG";
        File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
        File dstfile = new File(destinationPath);
//        File dstFile = new File("/Users/priyaramoji/IdeaProjects/Selenium/Reportsproj/Screenshots/firstcapture.PNG");
        FileUtils.copyFile(srcfile,dstfile);
        test.addScreenCaptureFromPath("/Users/priyaramoji/IdeaProjects/Selenium/Reportsproj/Screenshots/firstcapture"+addDate+".PNG");
//        test.addScreenCaptureFromPath(destinationPath);
//        test.fail("Login to homepage failed");
        return destinationPath;

    }

}


