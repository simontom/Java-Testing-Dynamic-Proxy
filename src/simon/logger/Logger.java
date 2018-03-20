package simon.logger;

import com.sun.istack.internal.NotNull;

public class Logger {
    public static void logMessage(@NotNull String className, @NotNull String method, @NotNull String message) {
        System.out.println(className + " # " + method + " # " + message);
    }
}
