package CompleteProj.E2EProj;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.base;
import Resources.extenetReportNg;

public class Listeners extends base implements ITestListener{
	ExtentReports extent = extenetReportNg.getReportObject();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		test = extent.createTest("Initial Demo");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Case Passed!");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		String testName = result.getMethod().getMethodName();
		ITestContext context = result.getTestContext();
	    driver = (WebDriver) context.getAttribute("WebDriver");
		try {
			screenshot(testName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		extent.flush();
		
	}

}
