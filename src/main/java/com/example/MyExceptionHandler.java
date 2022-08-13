package com.example;

import io.micrometer.core.annotation.Counted;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class MyExceptionHandler {

//  @AfterThrowing(pointcut="execution(* com.example.MyEventHandler.*(..))", throwing="ex")
//  public void handleException(Exception ex) {
//    log.info("aspect exception");
//  }

  @Around("execution(* com.example.MyEventHandler.*(..))")
  public void handleException(ProceedingJoinPoint joinPoint) throws Throwable {
    try {
      joinPoint.proceed();
    }
    catch (Exception e) {
      log.info("aspect exception");
    }
  }
}
