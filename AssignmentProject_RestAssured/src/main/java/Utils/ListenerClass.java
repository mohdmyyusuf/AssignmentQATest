package Utils;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.ITestListener;

public class ListenerClass implements ITestListener{
	
	Screencapturer obj = new Screencapturer();
	

	  public void onTestStart(ITestResult result) {
	   
		  Method method = result.getMethod().getConstructorOrMethod().getMethod();
		     Test test = method.getAnnotation(Test.class);
		     String testname = test.testName();
		  System.out.println(testname+" started");
	  }

	  public void onTestSuccess(ITestResult result) {
		  Method method = result.getMethod().getConstructorOrMethod().getMethod();
		     Test test = method.getAnnotation(Test.class);
		     String testname = test.testName();
		  System.out.println(testname+" Test successful..");
	    // not implemented
	  }

	  public void onTestFailure(ITestResult result) {
		  
		  obj.screenshotTaker();
		  System.out.println("Ohhh!!! Test failed and screenshot is captured");
		  
	    // not implemented
	  }

	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a method fails but has been annotated with successPercentage and this failure
	   * still keeps it within the success percentage requested.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	   */
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a test fails due to a timeout.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   */
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
	   * and calling all their Configuration methods.
	   *
	   * @param context The test context
	   */
	  public void onStart(ITestContext context) {
	    // not implemented
		  
		  
	  }

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
	   * and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	  public void onFinish(ITestContext context) {
	    // not implemented
	  }
}


