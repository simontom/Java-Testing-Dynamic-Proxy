package simon.logger;

import simon.logger.versioncheck.IMyServiceUnderVersionChecking;
import simon.logger.versioncheck.MyServiceUnderVersionChecking;
import simon.logger.versioncheck.VersionCheck;
import simon.logger.versioncheck.VersionCheckingInterceptor;
import simon.logger.versioncheck.VersionHolder;

public class Main {

    public static void main(String[] args) {
        // InvocationHandler test
        /*MyInvocationHandler handler = new MyInvocationHandler("the example string");
        CharSequence o = (CharSequence) Proxy.newProxyInstance(
                MyInvocationHandler.class.getClassLoader(),
                new Class[]{CharSequence.class}, handler);
        System.out.println(o.length());
        System.out.println(o.subSequence(4, 8));*/

        // InvocationHandler generic test
        /*List<String> list = MyGenericInterceptor.getProxy(new ArrayList<>(), List.class);
        list.add("one");
        list.add("two");
        System.out.println(list);
        list.remove("one");*/

        // Version Checking using Interceptor test
        VersionHolder versionHolder = new VersionHolder(12, 0, 0);
        IMyServiceUnderVersionChecking service = VersionCheckingInterceptor.createProxy(
                new MyServiceUnderVersionChecking(),
                IMyServiceUnderVersionChecking.class,
                versionHolder
        );
        service.foo();
        service.bar();
        service.baz();
        service.qux();
        service.test(1);
    }
}
