package simon.logger.invocationhandlertest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private String theString;

    public MyInvocationHandler(String theString) {
        this.theString = theString;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method call : " + method.getName());
        Object result = method.invoke(theString, args);
        System.out.println("after method call : " + method.getName());
        return result;
    }
}
