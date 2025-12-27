package project_orangehrm.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SimpleListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("  ▶ STARTING: " + result.getMethod().getMethodName()
                + " in " + result.getTestClass().getRealClass().getSimpleName());
        System.out.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        long duration = (result.getEndMillis() - result.getStartMillis()) / 1000;
        System.out.println("  ✓ PASSED (" + duration + "s)");
        System.out.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        long duration = (result.getEndMillis() - result.getStartMillis()) / 1000;
        System.out.println("  ✗ FAILED (" + duration + "s)");
        System.out.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("  ⊗ SKIPPED");
        System.out.flush();
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(" SUITE: " + context.getName() + " (" + context.getAllTestMethods().length + " tests)");
        System.out.flush();
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(" ✅ FINISHED: ✓" + context.getPassedTests().size()
                + " | ✗" + context.getFailedTests().size()
                + " | ⊗" + context.getSkippedTests().size() + "");
        System.out.flush();
    }
}
