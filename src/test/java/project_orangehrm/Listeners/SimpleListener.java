package project_orangehrm.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class SimpleListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("\n▶ STARTING: " + result.getMethod().getMethodName()
                + " in " + result.getTestClass().getRealClass().getSimpleName());
        System.out.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        long duration = (result.getEndMillis() - result.getStartMillis()) / 1000;
        System.out.println("\n  ✓ PASSED (" + duration + "s)");
        System.out.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        long duration = (result.getEndMillis() - result.getStartMillis()) / 1000;
        System.out.println("\n  ✗ FAILED (" + duration + "s)");
        System.out.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("\n  ⊗ SKIPPED");
        System.out.flush();
    }

}
