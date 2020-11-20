import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DriverBase {

    /* declare the web driver variable */
    protected static WebDriver driver;

    /* class constructor */
    public DriverBase(WebDriver driver) {
        DriverBase.driver = driver;

        //This INIT elements method will create all web elements
        PageFactory.initElements(driver, this);
    }

    /* maximize the size of the browser window */
    public static void maximizeBrowserWindow() {
        driver.manage().window().maximize();
    }

    /* minimize the size of the browser window */
    public static void hideBrowserTab() {
        Robot robot;
        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_N);
            System.out.println("Browser minimized!!!");
            DriverBase.sleep(2000);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_N);
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

//        /* minimize the size of the browser window */
//        public static void hideBrowserTab(boolean isHidden) {
//
//            driver.manage().window().setPosition(new Point(-2000, 3000));
//        }
//
//        /* minimize the size of the browser window */
//        public static void displayBrowserTab() {
//            driver.manage().window().setPosition(new Point(0, 0));
//        }

    /* maximize the size of the browser window */
    public static void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    /* get the page title*/
    public static String getPageTitle() {
        return driver.getTitle();
    }

    public static boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex) {
            return false;
        }   // catch
    }   // isAlertPresent()

    /* get the page title*/
    public static void acceptAlert() {

        if (isAlertPresent() == true) {
            driver.switchTo().alert().accept();
        }
    }


    /* open a new browser tab */
    public static void openNewBrowserTab(int tabNumber) {

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber)); //switches to new tab
    }

    /* return to main tab */
    public static void switchBackToMainBrowsertab() {

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0)); // switch back to main screen
    }

    /* close focused browser */
    public static void closeFocusedBrowser() {
        driver.close();
    }

    /* return to main tab */
    public static void switchToBrowsertab(int tabNumber) {

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber)); // switch back to main screen
    }

    public static void clearCookies() {
        driver.manage().deleteAllCookies();
        sleep(3000);
    }

    /* find element by different locator */
    public static WebElement driverFindWebElement(By by) {
        return driver.findElement(by);
    }

    /* find element by different locator */
    public static WebElement driverFindWebElement(By by, String scroll) {

        if (scroll.equalsIgnoreCase("right")) {
            DriverBase.moveToElement(by);
        }
        return driver.findElement(by);
    }

    /* find element by different locator over load */
    public static WebElement driverFindWebElement(WebElement element) {
        return element;
    }

    //click on a web element
    public static void click(By element) {
        driverFindWebElement(element).click();
        DriverBase.sleep(1000);
        return;
    }

    public static void sendKeys(WebElement element){
        driverFindWebElement(element).sendKeys();
        DriverBase.sleep(1000);
        return;
    }
    public static void sendKeys(By element){
        driverFindWebElement(element).sendKeys();
        DriverBase.sleep(1000);
        return;
    }

//    public static void sendKeys(String username) {
//        driverFindWebElement(username).sendKeys();
//        DriverBase.sleep(1000);
//        return;
//    }



//    private static DriverBase driverFindWebElement(String username) {
//    }

    //click on a web element
    public static void quickClick(By element) {
        driverFindWebElement(element).click();
        return;
    }

    //click on a web element
    public static void click(WebElement element) {
        element.click();
        DriverBase.sleep(1500);
        return;
    }

    //click on a web element
    public static void doubleClick(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().build().perform();
        DriverBase.sleep(1500);
        return;
    }

    //click on a web element overloading
    public static void doubleClick(By element) {

        WebElement e = driverFindWebElement(element);
        Actions action = new Actions(driver);
        action.moveToElement(e).doubleClick().build().perform();
        DriverBase.sleep(1500);
        return;
    }

    //send text
    public static void write(By element, String text) {
        driverFindWebElement(element).clear();
        driverFindWebElement(element).sendKeys(text);
        return;
    }

    //send text
    public static void writeNoClean(By element, String text) {
        driverFindWebElement(element).sendKeys(text + " ");
        return;
    }

    //clear text
    public static void clearTextBox(By element) {
        driverFindWebElement(element).clear();
        return;
    }

    //send text
    public static void writeNoClean(By element, int text) {
        driverFindWebElement(element).sendKeys(text + " ");
        return;
    }

    //read text
    public static String readText(By element) {
        return driver.findElement(element).getText();
    }

    //read text (over loading)
    public static int readTextAsNumber(By element) {
        return Integer.parseInt(driver.findElement(element).getText());
    }

    //read text (over loading)
    public static String readText(By element, int index) {
        return driver.findElements(element).get(index).getText();
    }

    //read text (over loading)
    public static String readText(WebElement element) {
        return element.getText();
    }

    //get element size
    public static int getSize(By element) {
        return driver.findElements(element).size();
    }

//        //find elements by different locator
//        public static List<WebElement> driverFindWebElements(By element) {
//            return driver.findElements(element);
//        }

    //open URL
    public static void openUrl(String url) {
        driver.get(url);
    }

    //open URL
    public static void refreshBrowser() {
        driver.navigate().refresh();
        sleep(4500);
    }

    //scroll to web element
    public static DriverBase scrollToElement(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        return new DriverBase(driver);
    }

    //scroll to web element
    public static DriverBase scrollToElement(By webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        return new DriverBase(driver);
    }

    //scroll to top
    public static DriverBase scrollToTop() {
        WebElement element = driverFindWebElement(By.tagName("header"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

        return new DriverBase(driver);
    }

    //scroll to top
    public static DriverBase scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        return new DriverBase(driver);
    }

    //scroll to the right
    public static void scrollToRight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(2000,0)");
    }

    //scroll to the right
    public static DriverBase scrollToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(-2000,0)");
        return new DriverBase(driver);
    }

    // nested scroll bar
    public static void nestedScrollToElement() {

        //EventFiringWebDriver event = new EventFiringWebDriver(driver);
    }

    //returns the parent of the requested web element
    public static WebElement findElementParent(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement parentElement = (WebElement) executor.executeScript("return arguments[0].parentNode;", element);
        return parentElement;
    }

    /* move to web element */
    public static DriverBase moveToElement(WebElement webElement) {
        Actions builder = new Actions(driver);
        WebElement element = webElement;
        builder.moveToElement(element).build().perform();

        return new DriverBase(driver);
    }

    /* move to web element */
    public static DriverBase moveToElement(By webElement) {
        Actions builder = new Actions(driver);
        WebElement element = DriverBase.driverFindWebElement(webElement);
        builder.moveToElement(element).build().perform();

        return new DriverBase(driver);
    }

    /* move to web element and click */
    public static DriverBase moveToElementAndClick(WebElement webElement) {
        Actions builder = new Actions(driver);
        WebElement element = webElement;
        builder.moveToElement(element).click().build().perform();

        return new DriverBase(driver);
    }


    //get tool-tip text (for angular application)
    public static String getTooltipText(WebElement parent_element, WebElement child_element) {

        Actions builder = new Actions(driver);
        builder.moveToElement(parent_element).build().perform();

        String tooltipText = child_element.getText();

        return tooltipText;
    }

    //Switch to IFRAME
    public static DriverBase switchToIframe(WebElement webElement) {
        driver.switchTo().frame(webElement);
        return new DriverBase(driver);
    }

    //Switch back to main window
    public static DriverBase switchToMainWindow() {
        driver.switchTo().defaultContent();
        return new DriverBase(driver);
    }

    /* move to the modal dialog*/
    public static DriverBase switchToActiveElement() {
        driver.switchTo().activeElement();
        return new DriverBase(driver);
    }

    //wait for AJAX call
    public static void waitForAjax(WebDriver driver) {
        new WebDriverWait(driver, 180).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }

    //take a nap in mills second
    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //wait for element to be visible
    public static DriverBase elementIsDisplayed(WebElement locator, int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        @SuppressWarnings("unused")
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));

        return new DriverBase(driver);
    }

    //verify if element is displayed overloading
//    public static Boolean elementIsDisplayed(By locator) {
//
//        boolean status = false;
//
//        if (driverFindWebElements(locator).size() > 0) {
//            status = true;
//        }
//        return status;
//    }

//        /* wait until the web element is displayed */
//        public static void waitForElementToBeDisplayed(By locator) {
//
//            int timeout        = Integer.parseInt(ReadPropertyFiles.readConfigurationFile("waiting_limit"));                                            /* read time out from the configuration file */
//            int waitingSeconds = 0;
//            int elementSize    = DriverBase.driverFindWebElements(locator).size();
//
//            while (elementSize < 1) {
//
//                waitingSeconds += 1;
//                DriverBase.sleep(1000);
//                System.out.println("Waiting second: " + waitingSeconds);
//
//                elementSize = DriverBase.driverFindWebElements(locator).size();
//
//                if (waitingSeconds == timeout) {
//                    System.out.println("Error Element not displayed!");
//                    break;
//                }
//            }
//        }

//        /* wait until the web element is no longer displayed */
//        public static void waitForElementNotToBeDisplayed(By locator) {
//
//            int timeout        = Integer.parseInt(ReadPropertyFiles.readConfigurationFile("waiting_limit"));                                            /* read time out from the configuration file */
//            int waitingSeconds = 0;
//            int elementSize    = DriverBase.driverFindWebElements(locator).size();
//
//            while (elementSize > 1) {
//
//                waitingSeconds += 1;
//                DriverBase.sleep(1000);
//                System.out.println("Waiting second: " + waitingSeconds);
//
//                elementSize = DriverBase.driverFindWebElements(locator).size();
//
//                if (waitingSeconds == timeout) {
//                    System.out.println("Error Element not displayed!");
//                    break;
//                }
//            }
//        }

    //wait for page to load
    public static void waitPageToLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(pageLoadCondition);
    }

    //select By index from drop-down
    public static DriverBase dropDownSelectByIndex(WebElement webElement, int index) {
        WebElement element = webElement;
        Select uiElement = new Select(element);
        uiElement.selectByIndex(index);

        return new DriverBase(driver);
    }

    //select By index from drop-down
    public static DriverBase dropDownSelectByIndex(By webElement, int index) {
        WebElement element = DriverBase.driverFindWebElement(webElement);
        Select uiElement = new Select(element);
        uiElement.selectByIndex(index);

        return new DriverBase(driver);
    }

    //select By Visible Text from drop down
    public static DriverBase dropDownSelectByVisibleText(By webElement, String data) {
        By element = webElement;
        Select uiElement = new Select(driverFindWebElement(element));
        uiElement.selectByVisibleText(data);

        return new DriverBase(driver);
    }

    //select By Visible Text from drop down	(overload)
    public static DriverBase dropDownSelectByVisibleText(WebElement webElement, String data) {
        Select uiElement = new Select(webElement);
        uiElement.selectByVisibleText(data);

        return new DriverBase(driver);
    }

    //select By value from drop-down
    public static DriverBase dropDownSelectByValue(WebElement webElement, String value) {
        WebElement element = webElement;
        Select uiElement = new Select(element);
        uiElement.selectByValue(value);

        return new DriverBase(driver);
    }

    /*verify if the check box attribute is checked
     * return true if checked, retun false if not checked
     */
    public static boolean checkBoxChecked(WebElement webElement) {

        if (webElement.isSelected()) {
            return true;
        }
        return false;
    }
//
//        /* throw exception (will be changed to a customed exception)*/
//        public static void throwException(String description) {
//            throw new InvalidParameterException(ReadPropertyFiles.displayWarning(description));
//        }

    /*
     * remove duplicate element in array list
     */
    public static <T> ArrayList<T> removeListDuplicateElement(ArrayList<T> list) {

        Set<T> set = new LinkedHashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);

        // return the list
        return list;
    }

    /*
     * use a character to split a string
     * return the index of the separator
     */
    public static int splitStringGetSeparatorIndex(String text, char separator) {

        int indexSeparator = 0;

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == separator) {
                indexSeparator = i + 1;
                break;
            }
        }
        return indexSeparator;
    }



//    protected static void sendKeys(String username) {
//    }

//        public static void main(String[] args) {
//            String sampleString = "Cat,Dog,Elephant";
//            String[] items = sampleString.split(",");
//            List<String> itemList = Arrays.asList(items);
//            System.out.println(itemList.get(1));
//        }

    /*
     * String to array using a delimitter
     */
//        public static List<String> stringToArray(String delimiter, String text) {
//
//            System.out.println(delimiter);
//            System.out.println(text);
//            String convertedText = text.replace(delimiter, ",");
//
//            String[] items = convertedText.split(",");
//            List<String> itemList = Arrays.asList(items);
//            System.out.println(itemList);
//
//            return itemList;
//        }

}
