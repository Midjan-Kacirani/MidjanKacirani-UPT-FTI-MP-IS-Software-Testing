package selenium.training.utils.customannotations;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import java.lang.reflect.Method;

public class SuiteCheckListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            Method testMethod = method.getTestMethod().getConstructorOrMethod().getMethod();
            if (testMethod.isAnnotationPresent(NotInSuite.class) && isRunningInSuite(testResult)) {
                throw new SkipException("Skipping setupNotInSuite as the test is part of a suite");
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // No implementation needed for afterInvocation in this scenario
    }

    private boolean isRunningInSuite(ITestResult testResult) {
        // You can define a custom logic to check if the test is running as part of a suite
        return System.getProperty("RUNNING_SUITE") != null;
    }
}
