package ExtentReporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener
{
    public static ExtentReports extent;

    public ExtentSparkReporter spark;

    String reportName;

    public void onStart(ITestContext testContext)
    {
        reportName = "Test-Report.html";
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("./Reports/" + reportName);
        extent.attachReporter(spark);

        spark.config().setDocumentTitle("OrangeHRM Project");
        spark.config().setReportName("Smoke Test Report");

        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Thapelo Matji");
    }
    public void onTestSuccess(ITestResult result)
    {
        extent.createTest(result.getName())
                .assignAuthor("Thapelo Matji")
                .assignCategory(result.getMethod().getGroups())
                .createNode(result.getName())
                .log(Status.PASS, "Test Passed");
    }

    public void OnTestFailure(ITestResult result)
    {
        extent.createTest(result.getName())
                .assignAuthor("Thapelo Matji")
                .assignCategory(result.getMethod().getGroups())
                .createNode(result.getName())
                .log(Status.FAIL, "Test Failed");
    }

    public void onTestSkipped(ITestResult result)
    {
        extent.createTest(result.getName())
                .assignAuthor("Thapelo Matji")
                .assignCategory(result.getMethod().getGroups())
                .createNode(result.getName())
                .log(Status.SKIP, "Test Skipped");
    }

    public void onTestFinish(ITestContext testContext)
    {
        extent.flush();
    }






    

}
