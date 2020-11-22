import org.testng.annotations.DataProvider;

public class dataprovider {

    @DataProvider(name = "Invalid_loginData")
    public Object[][] data_login(){

        return new String[][] {{"dsdsds", "dsdsds"}};

    }

    @DataProvider(name = "valid_loginData")
    public Object[][] data_validlogin(){

        return new String[][] {{"priyaramoji@gmail.com", "priya345"}};

    }
}