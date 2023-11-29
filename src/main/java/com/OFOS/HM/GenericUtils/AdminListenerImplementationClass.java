package com.OFOS.HM.GenericUtils;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AdminListenerImplementationClass extends AdminBaseClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String METHODNAME=result.getName();
		test=report.createTest(METHODNAME);
		Reporter.log(METHODNAME+"---Testscript execution starts from here---");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String METHODNAME=result.getName();
		test.log(Status.PASS, METHODNAME+"-->PASSED");
		Reporter.log(METHODNAME+"---Testscript executed Successfully---");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//String timeStamp=LocalDateTime.now().toString().replace(':', '-');
		//String FScript=timeStamp+result.getMethod().getMethodName();
		String FS=result.getName();
		String FScript=FS+new JavaUtils().systemDateInFormat();
		test.addScreenCaptureFromPath(FScript);
		
		try {
			WebDriverUtility.getScreenshot(AdminBaseClass.sdriver,FScript);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, FScript+"-->Failed");
		Reporter.log(FScript+"--->Testscript Execution Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String METHODNAME=result.getName();
		test.log(Status.SKIP, METHODNAME+"---Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(METHODNAME+"---Testscript Execution Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
	
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("com.OFOS.Hunger_Mantra");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("OFOS-Hunger_Mantra");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("url", "http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
		report.setSystemInfo("Reporter Name", "Rishav Singh");
	}

	@Override
	public void onFinish(ITestContext context) {
		//Consolidate the report/clean older report
		report.flush();
	}

	
}
