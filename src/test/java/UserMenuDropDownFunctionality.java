import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sfdcWebapgeproj.sfdcWebpage;

import java.io.IOException;
import java.lang.reflect.Method;

public class UserMenuDropDownFunctionality extends sfdcWebpage {
    @BeforeMethod(groups = "smoke")
    public void launchApplicatn(Method testname) {
        //ExtentReports report = ExtentReports.class(TestNGExample.class);
        test = extent.createTest(testname.getName());
        launchChromeBrowser();
        maximizePage();
        implicitWait(10);
    }

    @AfterMethod(groups = "smoke")
    public void closeApp() {
        closeChromeBrowser();
    }

//    @AfterTest(groups = "smoke")
//    public void endReport() {
//        extent.flush();
//    }

    @Test(groups = "smoke",dataProvider = "valid_loginData", dataProviderClass = dataprovider.class, enabled = false)
    public void userMenudrpdwn(String username, String pwd) throws IOException {
        sfdcWebapgeproj.sfdcWebpage.loginsfdc(username, pwd);
//        WebElement identity = driver.findElement(By.xpath("//*[@id=\'idcard-identity\']"));
        WebElement d = driver.findElement(By.id("userNavLabel"));
        System.out.println(d.getText());
        clicktheElement(d);
        implicitWait(3000);
        verifyUsermenu(property("dataFile", "usermenu.xpath"));
    }

    @Test(groups = "smoke", dataProvider = "valid_loginData", dataProviderClass = dataprovider.class)
    public void logoutUserMenu(String username, String pwd) throws IOException {
        sfdcWebapgeproj.sfdcWebpage.loginsfdc(username, pwd);
//        WebElement identity = driver.findElement(By.xpath("//*[@id=\'idcard-identity\']"));
        WebElement d = driver.findElement(By.id("userNavLabel"));
        System.out.println(d.getText());
        clicktheElement(d);
        implicitWait(30);
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]\n"));
        clicktheElement(logout);
        implicitWait(1000000);
        System.out.println("Logged out successfully");
        System.out.println(driver.getTitle());
//        verifytext(driver.getTitle(), property("dataFile","loginpage.title"));
    }
}