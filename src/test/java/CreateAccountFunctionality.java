import freemarker.template.Template;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sfdcWebapgeproj.sfdcWebpage;

import java.io.IOException;
import java.lang.reflect.Method;

public class CreateAccountFunctionality extends sfdcWebpage {
    @BeforeMethod(groups ="functional")
    public void launchApplicatn(Method testname) {
        //ExtentReports report = ExtentReports.class(TestNGExample.class);
        test = extent.createTest(testname.getName());
        launchChromeBrowser();
        maximizePage();
        implicitWait(10);
    }

    @AfterMethod(groups ="functional")
    public void closeApp() {
        closeChromeBrowser();
    }

    @AfterTest(groups ="functional")
    public void endReport() {
        extent.flush();
    }
    @Test(groups = "functional",dataProvider = "valid_loginData", dataProviderClass = dataprovider.class)
    public void AccountsTab_TC08(String username , String pwd) throws IOException{
        sfdcWebpage.loginsfdc(username, pwd);
        WebElement accountTab = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
        clicktheElement(accountTab);
        String Expectedtext = "Accountsdfdfd";
        WebElement AccountElement = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1"));
        verifytext(Expectedtext, AccountElement.getText());
    }

    @Test(groups ="functional",dataProvider = "valid_loginData", dataProviderClass = dataprovider.class)
    public void CreateAccountsTab_TC10(String username , String pwd) throws IOException {
        loginsfdc(username,pwd);

    }
    }
