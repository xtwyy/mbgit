package com.wyy.mclub.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class AppLogTrace {

    private static Logger logger = LogManager.getLogger(AppLogTrace.class);

    public Object logTrace(ProceedingJoinPoint point) throws Throwable {
        long begin = System.nanoTime();
        Object obj = point.proceed();
        long end = System.nanoTime();
        logger.trace("{}.{}:{} ms", point.getTarget().getClass(), point.getSignature().getName(), (end - begin) / 1000000);
        return obj;
    }

}

