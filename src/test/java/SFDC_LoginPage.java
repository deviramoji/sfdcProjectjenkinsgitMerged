//import com.sun.tools.javac.util.Assert;
//import com.sun.tools.javac.util.Assert;
import com.aventstack.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import sfdcWebapgeproj.sfdcWebpage;
import com.aventstack.extentreports.Status;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class SFDC_LoginPage extends sfdcWebpage {

//    //@Test
//    public static void main(String[] args) {
////        LogintestError1();
////        checkRememberMe3();
//////          LoginToSalesforce2();
////         forgotPassword4();
////         //validateLoginErrorMsg(String username , String pass);
////        editProfile();
//    }
    @BeforeMethod
   public void launchApplicatn(Method testname){
        //ExtentReports report = ExtentReports.class(TestNGExample.class);
        test = extent.createTest(testname.getName());
        launchChromeBrowser();
        maximizePage();
        implicitWait(10);
    }
   @AfterMethod
   public void closeApp(){
        closeChromeBrowser();
   }

   @AfterTest
   public void endReport(){
        extent.flush();
   }
    public void checkRememberMe3(String usrname, String pwd) throws IOException {
        WebElement a = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement b = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement c = driver.findElement(By.xpath("//input[@id='Login']"));
        WebElement rememberMe = driver.findElement(By.xpath("//input[@id='rememberUn']"));
////      String usrname = prop.getProperty("username");
//        String usrname = "priyaramoji@gmail.com";
//        String pwd ="priya345";
//        DriverBase.driverFindWebElement(HomeWebelement.get_username).sendKeys(usrname);
//        a.sendKeys(prop.getProperty("username"));
        sendValue(a,usrname);
//        b.sendKeys(prop.getProperty("password"));
//        b.sendKeys("priya345");
        sendValue(b,pwd);
        clicktheElement(rememberMe);
        clicktheElement(c);
//        DriverBase.click(HomeWebelement.get_login_Button);
        /**explicit wait - to wait for the compose button to be click-able**/
        try {
            WebElement d = driver.findElement(By.id("userNavLabel"));
            WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNavLabel")));
            String z = d.getText();
            System.out.println(z);

            if (z.equals("Devi Ramoji")) {
                System.out.println("User is logged in successfully : " + z);
                d.click();
            } else {
                System.out.println("User name is incorrect");
            }
            WebElement logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]\n"));
            clicktheElement(logout);
            System.out.println("Logged out successfully");
            WebElement identity = driver.findElement(By.xpath("//*[@id=\'idcard-identity\']"));
            if(usrname.equals(identity.getText())){
                System.out.println("username is displayed " + identity.getText());
            }

        } catch (Exception e) {
            System.out.println("Exception occurred" +e);
        }
    }


        public static void LogintestError1(){
           launchChromeBrowser();
            maximizePage();
            implicitWait(10);
            WebElement a = driver.findElement(By.xpath("//input[@id='username']"));
            WebElement b = driver.findElement(By.xpath("//input[@id='password']"));
            WebElement c = driver.findElement(By.xpath("//input[@id='Login']"));
            WebElement rememberMe = driver.findElement(By.xpath("//input[@id='rememberUn']"));
           sendValue(a,"priyaramoji@gmail.com");
            clicktheElement(rememberMe);
            clicktheElement(c);
            WebElement errormsg = driver.findElement(By.xpath("//div[@id='error']"));
            try {
                if (errormsg.getText().equals("Please enter your password.")) {
                    System.out.println("Error message displayed succesfully : " + errormsg.getText());
                }
            }
            catch(Exception e){
                System.out.println(e);
            }

        }

        public static void forgotPassword4(){
        launchChromeBrowser();
            driver.get("https://xxx-b-dev-ed.my.salesforce.com/");
           maximizePage();
           implicitWait(10);
            WebElement fgtpwd = driver.findElement(By.xpath("//*[@id='forgot_password_link']"));
           clicktheElement(fgtpwd);
            WebElement fgt_usr = driver.findElement(By.xpath("//input[@id='un']"));
            WebElement contnueButn = driver.findElement(By.xpath("//input[@id='continue']"));
            sendValue(fgt_usr, "pvrfamly@gmail.com");
            clicktheElement(contnueButn);
            WebElement emailsent = driver.findElement(By.xpath("//div[@id='content']"));
            System.out.println("Email is sent to reset pwd  " + "' "+ emailsent.getText() + "'");
            driver.close();
        }

        @Test(dataProvider = "Invalid_loginData", dataProviderClass = dataprovider.class, invocationCount = 2)
        public static void validateLoginErrorMsg(String username, String pass){
            WebElement a = driver.findElement(By.xpath("//input[@id='username']"));
            WebElement b = driver.findElement(By.xpath("//input[@id='password']"));
            WebElement c = driver.findElement(By.xpath("//input[@id='Login']"));
           sendValue(a,username);
            sendValue(b,pass);
            clicktheElement(c);
            WebElement errormsg = driver.findElement(By.xpath("//*[@id=\'error\']"));
            System.out.println("Error msg is displayed  " +errormsg.getText());
          //  driver.close();
        }

        public static void editProfile(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://asdfgh-dev-ed.my.salesforce.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement a = driver.findElement(By.xpath("//input[@id='username']"));
            WebElement b = driver.findElement(By.xpath("//input[@id='password']"));
            WebElement c = driver.findElement(By.xpath("//input[@id='Login']"));
            //a.sendKeys("priyaramoji@gmail.com");
            a.sendKeys("pvrfamly@gmail.com");
            b.sendKeys("priya345");
            c.click();
            WebElement Profile = driver.findElement(By.xpath("//*[@id=\"UserProfile_Tab\"]/a"));
            Profile.click();
            WebElement profname = driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']"));
            System.out.println("Profile name is correct" +profname.getText());
            WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement w = driver.findElement(By.xpath("//*[@id='profileTab_sfdc.ProfilePlatformFeed']"));
            ewait.until(ExpectedConditions.visibilityOf(w));
            WebElement editprofile = driver.findElement(By.xpath("//*[@id=\'chatterTab\']/div[2]/div[2]/div[1]/h3/div/div/a/img"));
            editprofile.click();
            WebElement iframeedit = driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
            driver.switchTo().frame(iframeedit);
            WebElement about = driver.findElement(By.xpath("//a[contains(text(), 'About')]"));
            about.click();
            driver.switchTo().parentFrame();
            WebElement saveProfile = driver.findElement(By.xpath("/input[@id='continue']"));
            saveProfile.click();

             }

}