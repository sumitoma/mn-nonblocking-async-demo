package mn.nonblocking.async.aop.interceptor;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Singleton
public class LogTimeSpentInterceptor implements MethodInterceptor<Object, Object> {

    private static final Logger logger = LoggerFactory.getLogger(LogTimeSpentInterceptor.class);

    @Override
    public Object intercept(MethodInvocationContext context) {
        long start = System.nanoTime();
        Object obj = context.proceed();
        long elapsed = TimeUnit.
                NANOSECONDS.toMillis(System.nanoTime()-start);
        logger.trace("Executing " + context.getDeclaringType().getSimpleName() + "#" + context.getMethodName()
            + Arrays.stream(context.getArgumentNames())
                .collect(Collectors.joining(",", "(", ")")) + " finished in " + elapsed + " ms" );
        return obj;
    }
}
