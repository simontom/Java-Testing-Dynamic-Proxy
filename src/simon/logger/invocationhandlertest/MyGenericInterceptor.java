package simon.logger.invocationhandlertest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyGenericInterceptor<T> implements InvocationHandler {
    private T target;

    public MyGenericInterceptor(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method call : " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method call : " + method.getName());
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(T target, Class<? super T> interfaceType) {
        MyGenericInterceptor handler = new MyGenericInterceptor(target);
        return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(), new Class<?>[]{interfaceType}, handler);
    }
}
