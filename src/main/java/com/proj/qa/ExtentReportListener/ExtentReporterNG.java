package com.proj.qa.ExtentReportListener;
	
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;
import java.util.List;

public class ExtentReporterNG implements IReporter {
    private static ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        // Define the report location
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        
        // Initialize ExtentReports and Spark Reporter
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Iterate through suites and tests
        for (ISuite suite : suites) {
            suite.getResults().forEach((testName, result) -> {
                ExtentTest test = extent.createTest(testName);
                
                result.getTestContext().getPassedTests().getAllResults().forEach(tc -> {
                    test.pass("Test Passed: " + tc.getName());
                });

                result.getTestContext().getFailedTests().getAllResults().forEach(tc -> {
                    test.fail("Test Failed: " + tc.getName());
                });

                result.getTestContext().getSkippedTests().getAllResults().forEach(tc -> {
                    test.skip("Test Skipped: " + tc.getName());
                });
            });
        }

        // Save the report
        extent.flush();
        System.out.println("Extent Report Generated: " + reportPath);
    }
}


