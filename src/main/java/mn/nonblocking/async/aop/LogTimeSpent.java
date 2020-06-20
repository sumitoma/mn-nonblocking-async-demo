package mn.nonblocking.async.aop;

import io.micronaut.aop.Around;
import io.micronaut.context.annotation.Type;
import mn.nonblocking.async.aop.interceptor.LogTimeSpentInterceptor;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD})
@Around
@Type(LogTimeSpentInterceptor.class)
public @interface LogTimeSpent {
}
