package simon.logger.versioncheck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.METHOD)
public @interface VersionCheck {
    int major() default 12;
    int minor() default 0;
    int patch() default 0;
}
