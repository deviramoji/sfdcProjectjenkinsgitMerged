import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import sfdcWebapgeproj.sfdcWebpage;

import java.io.IOException;

public class ListenerClass extends sfdcWebpage implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("close report");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("capture screenshot");
        try {
            test.addScreenCaptureFromPath(takeScreenshot());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("send email to manager");
        extent.flush();
    }
}