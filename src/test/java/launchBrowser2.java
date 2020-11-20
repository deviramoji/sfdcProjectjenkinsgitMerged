import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class launchBrowser2 {

        public static void main(String args[]) throws Exception {
            //BasicConfigurator.configure();
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            //System.setProperty("webdriver.chrome.driver","/Users/priyaramoji/Downloads/chromedriver" );
            driver.get("https://qa-tekarch.firebaseapp.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Thread.sleep(100);
            WebElement a = driver.findElement(By.xpath("//input[@id='email_field']"));
            WebElement b = driver.findElement(By.id("password_field"));
            WebElement c = driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]"));
            a.sendKeys("admin123@gmail.com");
            b.sendKeys("admin123");
            c.click();
            //Thread.sleep(1000);
            //driver.close();

            WebElement d = driver.findElement(By.xpath("//input[@id='name']"));
            d.sendKeys("Priya");
            WebElement e = driver.findElement(By.id("lname"));
            e.sendKeys("Ramoji");
            driver.findElement(By.id("postaladdress")).sendKeys("217 Preston wodds");
            driver.findElement(By.id("personaladdress")).sendKeys("Dunwoody, Georgia");
            driver.findElement(By.xpath("//body/div[@id='user_div']/div[2]/form[1]/div[5]/span[1]/input[1]")).click();

            WebElement f = driver.findElement(By.id("city"));
            Select city = new Select(f);
            city.selectByVisibleText("NEW DELHI");
            city.selectByIndex(2);
            //Thread.sleep(1000);
            WebElement g = driver.findElement(By.id("course"));
            Select course = new Select(g);
            city.selectByVisibleText("btech");
            //city.selectByIndex(2);


        }
    public static void readFromProp() {
        File file = new File("/Users/priyaramoji/IdeaProjects/Selenium/src/test/java/datafile.properties/");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    }





