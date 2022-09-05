package com.ipisces42.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ServiceLogAspect {

    @Around("execution(* com.ipisces42.service..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) {
        var stopWatch = new StopWatch();
        stopWatch.start();
        if (log.isInfoEnabled()) {
            log.info(
                    "====== 开始执行 {}.{}======",
                    joinPoint.getTarget().getClass(),
                    joinPoint.getSignature().getName());
        }

        Object proceed;
        try {
            proceed = joinPoint.proceed();
            stopWatch.stop();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        var time = stopWatch.getTime();
        if (time > 3000) {
            if (log.isErrorEnabled()) {
                log.error(
                        "====== 执行 {}.{} 结束,耗时:{}毫秒======",
                        joinPoint.getTarget().getClass(),
                        joinPoint.getSignature().getName(),
                        time);
            }

        } else if (time > 2000) {
            //
            if (log.isWarnEnabled()) {
                log.warn(
                        "====== 执行 {}.{} 结束,耗时:{}毫秒======",
                        joinPoint.getTarget().getClass(),
                        joinPoint.getSignature().getName(),
                        time);
            }

        } else {
            if (log.isInfoEnabled()) {
                log.info(
                        "====== 执行 {}.{} 结束,耗时:{}毫秒======",
                        joinPoint.getTarget().getClass(),
                        joinPoint.getSignature().getName(),
                        time);
            }
        }
        return proceed;
    }
}
