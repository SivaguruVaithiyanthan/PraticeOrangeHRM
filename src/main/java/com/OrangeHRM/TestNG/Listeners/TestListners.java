package com.OrangeHRM.TestNG.Listeners;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.OrangeHRM.Reports.Report;
import com.OrangeHRM.base.DriverIntialization;
import com.OrnageHRM.web.commons.WebCommons;

public class TestListners extends Report implements ITestListener, IAnnotationTransformer {
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryListners.class);
	}

	@Override
	public void onTestStart(ITestResult result) {
		Report.startReporting(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Report.test.pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		IRetryAnalyzer retryAnalyzer = result.getMethod().getRetryAnalyzer(result);

		if (retryAnalyzer != null && retryAnalyzer.retry(result)) {
			return;
		}
		Report.test.fail("Test Failed : " + result.getThrowable());

		try {
			test.addScreenCaptureFromPath(WebCommons.CaptureScreenShot(new DriverIntialization().Getdriver(),
					result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stopReporting();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Report.test.skip("Test Skipped");
	}

}
