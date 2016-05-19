package cn.van.kuang.aspectj.in.action.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect Aspect {

    private final static Logger logger = LoggerFactory.getLogger(Aspect.class);

    pointcut withoutParamAndReturnValue(): call(void cn.van.kuang.aspectj.in.action.CommonObject.withoutParamAndReturnValue());

    pointcut withReturnValue(String argument): call(java.lang.String cn.van.kuang.aspectj.in.action.CommonObject.withReturnValue(..)) && args(argument);

    pointcut withExceptionThrowout(): call(java.lang.String cn.van.kuang.aspectj.in.action.CommonObject.withExceptionThrowout());

    pointcut staticMethod(): withincode(static * cn.van.kuang.aspectj.in.action.CommonObject.staticMethod());

    before(): withoutParamAndReturnValue() {
        logger.info("~~~~~~~~~~~~~~~~BEFORE CommonObject.withoutParamAndReturnValue()");
    }

    after(): withoutParamAndReturnValue() {
        logger.info("~~~~~~~~~~~~~~~~AFTER CommonObject.withoutParamAndReturnValue()");
    }

    String around(String argument): withReturnValue(argument) {
        logger.info("~~~~~~~~~~~~~~~~BEFORE CommonObject.withReturnValue({})", argument);
        long start = System.nanoTime();
        String result = proceed(argument);
        logger.info("~~~~~~~~~~~~~~~~AFTER CommonObject.withReturnValue({}), Result: {}, took: {}ns",
                new Object[]{argument, result, (System.nanoTime() - start)});
        return result;
    }

    after() throwing (Throwable throwable): withExceptionThrowout() {
        logger.info("~~~~~~~~~~~~~~~~AFTER CommonObject.withExceptionThrowout()", throwable);
    }

    before(): staticMethod() {
        logger.info("~~~~~~~~~~~~~~~~BEFORE CommonObject.staticMethod()");
        throw new RuntimeException("Should invoke this method");
    }

    before(): within(cn.van.kuang.aspectj.in.action.CommonObject) && execution(* *.toString()) {
        logger.info("~~~~~~~~~~~~~~~~BEFORE CommonObject.toString()");
    }

    pointcut combine(): execution(* cn.van.kuang.aspectj.in.action.CommonObject.combineMethod());

    pointcut toString(): execution(* cn.van.kuang.aspectj.in.action.CommonObject.toString());

    pointcut getAString(): execution(* cn.van.kuang.aspectj.in.action.CommonObject.getAString());

    pointcut combineCflow(): cflow(combine()) && !within(Aspect);

    pointcut valueOfInCombine(): combineCflow() && getAString();

    before(): valueOfInCombine() {
        logger.info("~~~~~~~~~~~~~~~~Cflow, before getAString");
    }

    after() returning(String string): valueOfInCombine() {
        logger.info("~~~~~~~~~~~~~~~~Cflow, {}, {}", string);
    }
}
