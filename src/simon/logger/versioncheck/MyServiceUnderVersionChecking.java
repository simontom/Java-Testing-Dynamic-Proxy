package simon.logger.versioncheck;

import simon.logger.Logger;

public class MyServiceUnderVersionChecking implements IMyServiceUnderVersionChecking {
    private static final String CLASS_NAME = "MyServiceUnderVersionChecking";

    @Override
    public void foo() {
        commonMethodCall("foo");
    }

    @Override
    public void bar() {
        commonMethodCall("bar");
    }

    @Override
    public void baz() {
        commonMethodCall("baz");
    }

    @Override
    public void qux() {
        commonMethodCall("qux");
    }

    @Override
    public void test(int i) {
        Logger.logMessage(CLASS_NAME, "test", "value: " + i);
    }

    private void commonMethodCall(String methodName) {
        Logger.logMessage(CLASS_NAME, methodName, methodName + "_ed");
    }

}
