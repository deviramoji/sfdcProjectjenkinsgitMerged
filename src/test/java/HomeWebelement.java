import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWebelement extends DriverBase{

    //WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();

    @CacheLookup
    public static By get_username = By.xpath("//input[@id='username']");
    @CacheLookup
    public static By get_password = By.xpath("//input[@id='password']");
    @CacheLookup
    public static By get_login_Button = By.xpath("//input[@id='Login']");

    public HomeWebelement(WebDriver driver) {
        super(driver);
    }
}
