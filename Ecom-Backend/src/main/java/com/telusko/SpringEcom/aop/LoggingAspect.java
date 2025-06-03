package com.telusko.SpringEcom.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private  static  final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
   //return type , class name.method name(args)

   // It runs before the methods getJob and updateJob are executed irrespective of whether the exception is thrown or not.
    @Before("execution(* com.telusko.SpringEcom.service.JobService.getJob(..)) || execution(* com.telusko.SpringEcom.service.JobService.updateJob(..)) ")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called" + jp.getSignature().getName());

    }
    //It runs after the method getJob and updateJob  are executed irrespective of whether the exception is thrown or not .
    @After("execution(* com.telusko.SpringEcom.service.JobService.getJob(..)) || execution(* com.telusko.SpringEcom.service.JobService.updateJob(..)) ")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed" + jp.getSignature().getName());

    }


   // it runs only after the method getJob or update Job throws the exception
    @AfterThrowing("execution(* com.telusko.SpringEcom.service.JobService.getJob(..)) || execution(* com.telusko.SpringEcom.service.JobService.updateJob(..)) ")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method has some issues" + jp.getSignature().getName());

    }


    @AfterReturning("execution(* com.telusko.SpringEcom.service.JobService.getJob(..)) || execution(* com.telusko.SpringEcom.service.JobService.updateJob(..)) ")
    public void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info("Method has some issues" + jp.getSignature().getName());

    }








}
