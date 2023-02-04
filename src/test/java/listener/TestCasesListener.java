package listener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestCasesListener extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult tr) {
    log("Test Started....");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
    log("Test '" + tr.getName() + "' PASSED");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
    log("Test '" + tr.getName() + "' FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
    log("Test '" + tr.getName() + "' SKIPPED");
    }

    private void log(String methodName) {
    System.out.println(methodName);
    }

}
