package simon.logger.versioncheck;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import simon.logger.Logger;

public class VersionCheckingInterceptor<T> implements InvocationHandler {
    public static final String CLASS_NAME = "VersionCheckingInterceptor";

    private final T invocationTarget;
    private final VersionHolder versionHolder;

    private VersionCheckingInterceptor(T invocationTarget, VersionHolder versionHolder) {
        this.invocationTarget = invocationTarget;
        this.versionHolder = versionHolder;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Logger.logMessage(CLASS_NAME, "invoke", "Currently proxying method: " + method.getName());
        VersionCheck versionCheckAnnotation = method.getAnnotation(VersionCheck.class);
        checkVersion(versionCheckAnnotation);
        return method.invoke(invocationTarget, args);
    }

    private void checkVersion(VersionCheck versionCheck) {
        final String methodName = "checkVersion";
        if (versionCheck == null) {
            Logger.logMessage(CLASS_NAME, methodName, "NO VERSIONCHECK ANNOTATION");
            return;
        }

        if (versionHolder.isSameVersion(versionCheck.major(), versionCheck.minor(), versionCheck.patch())) {
            Logger.logMessage(CLASS_NAME, methodName, "HAS SAME VERSION");
        }
        else {
            Logger.logMessage(CLASS_NAME, methodName, "HAS DIFFERENT VERSION");
        }

        String versionString = versionCheck.major() + "." + versionCheck.minor() + "." + versionCheck.patch();
        Logger.logMessage(CLASS_NAME, methodName, "Version in Annotation: " + versionString);
    }

    @SuppressWarnings ({"unchecked", "UnnecessaryLocalVariable"})
    public static <T extends Object> T createProxy(T invocationTarget, Class<? super T> interfaceType, @NotNull VersionHolder versionHolder) {
        VersionCheckingInterceptor interceptor = new VersionCheckingInterceptor(invocationTarget, versionHolder);
        T proxyInstance = (T) Proxy.newProxyInstance(interfaceType.getClassLoader(), new Class<?>[]{interfaceType}, interceptor);
        return proxyInstance;
    }
}
