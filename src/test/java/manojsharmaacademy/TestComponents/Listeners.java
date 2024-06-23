package manojsharmaacademy.TestComponents;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("i am started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println("Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test is failed");
	}

}
