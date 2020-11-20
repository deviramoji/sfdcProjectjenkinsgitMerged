import net.bytebuddy.build.Plugin;
//import org.junit.Before;
//import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.annotations.test;

public class TestNG {

    @BeforeMethod
    public void launchBrowser(){
        System.out.println("Open");
    }
    @Test(priority = 1)
    public void method1(){
        System.out.println("Hi,");
    }

    @Test(priority = 0)
    public void method2(){
        System.out.println("How are you");
    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("close");
    }
}
