package cn.van.kuang.aspectj.in.action;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AspectObject {

    private final static Logger logger = LoggerFactory.getLogger(AspectObject.class);

    @Before("execution(void CommonObjectForAnnotation.withoutParamAndReturnValue())")
    public void beforeMethodWithoutParamAndReturnValue() {
        logger.info("++++++++beforeMethodWithoutParamAndReturnValue");
    }

    @After("execution(void CommonObjectForAnnotation.withoutParamAndReturnValue())")
    public void afterMethodWithoutParamAndReturnValue() {
        logger.info("++++++++afterMethodWithoutParamAndReturnValue");
    }

    @Before("execution(void CommonObjectForAnnotation.withoutReturnValue(..))")
    public void beforeMethodWithoutReturnValue(JoinPoint joinPoint) {
        logger.info("++++++++beforeMethodWithoutReturnValue, argument:[{}]", joinPoint.getArgs()[0]);
    }

    @After("execution(void CommonObjectForAnnotation.withoutReturnValue(..))")
    public void afterMethodWithoutReturnValue(JoinPoint joinPoint) {
        logger.info("++++++++afterMethodWithoutReturnValue, argument:[{}]", joinPoint.getArgs()[0]);
    }

    @AfterReturning(
            value = "execution(String CommonObjectForAnnotation.withReturnValue(..)) && args(argument)",
            returning = "result",
            argNames = "argument,result")
    public void afterMethodWithReturnValue(String argument, String result) {
        logger.info("++++++++afterMethodWithReturnValue, argument:[{}], result=[{}]", argument, result);
    }

    @AfterThrowing(
            value = "execution(String CommonObjectForAnnotation.withExceptionThrowout())",
            throwing = "throwable",
            argNames = "throwable"
    )
    public void afterThrow(Throwable throwable) {
        logger.info("++++++++afterThrow, exception message: {}", throwable.getMessage());
    }

    @Around(
            value = "execution(String CommonObjectForAnnotation.toString())",
            argNames = "proceedingJoinPoint")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return proceedingJoinPoint.proceed();
    }

    @AfterReturning(
            value = "cflow(execution(void CommonObjectForAnnotation.combineMethod())) && valueOf()",
            returning = "member1")
    public void combine(String member1) {
        logger.info("member1: {}", member1);
    }

    @Pointcut("execution(* *.String.valueOf(int))")
    void valueOf() {

    }
}
