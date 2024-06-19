package TestNGListener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tutorialNinja.qa.base.BaseClass;

public class CustomListener extends BaseClass implements ITestListener {

		public void onTestStart(ITestResult result) {
			
		}
		
		public void onTestSuccess(ITestResult result) {
		
		}

		public void onTestFailure(ITestResult result) {
			System.out.println("onTestFailure Method" +result.getName());
			failed(result.getMethod().getMethodName());
		}

		public void onTestSkipped(ITestResult result) {
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
		}
}
