import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class Acessbrowser {
    public static void main(String args[]){

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","/Users/priyaramoji/Downloads/chromedriver" );
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }
}
