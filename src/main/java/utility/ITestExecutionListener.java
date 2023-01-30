package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

public class ITestExecutionListener implements ISuiteListener, ITestListener {

    private ExtentReports extent;
    private ExtentTest testcase;
    private ExtentSparkReporter spark;

    // ===== TEST SUITES ====== //

    public void onStart(ISuite suite) {
        String reportPath = System.getProperty("user.dir") + "/reports/";
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(reportPath);
        spark.config().setTheme(Theme.STANDARD);
        extent.attachReporter(spark);

    }

    public void onFinish(ISuite suite) {
        extent.flush();
    }

    // ===== TEST  ====== //
    public void onStart(ITestContext test) {
    }

    public void onFinish(ITestContext test) {
    }


    // ===== TEST CASE  ====== //
    public void onTestStart(ITestResult result) {
        testcase = extent.createTest(result.getName());
        Steps.init(testcase);
    }

    public void onTestSuccess(ITestResult result) {
        testcase.pass("Test Case Passed");
    }

    public void onTestFailure(ITestResult result) {
        testcase.fail("Test execution resulted in failure");
    }

    public void onTestSkipped(ITestResult result) {
        testcase.skip("Test execution was skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        testcase.fail(result.getThrowable().getStackTrace().toString());
        this.onTestFailure(result);
    }

    private void attachScreenshot(String message) {
        String screenshot = ((TakesScreenshot)UIActions.driver).getScreenshotAs(OutputType.BASE64);
        testcase.addScreenCaptureFromBase64String(screenshot, message);
    }
}