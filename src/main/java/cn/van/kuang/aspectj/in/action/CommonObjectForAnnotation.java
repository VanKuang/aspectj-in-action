package cn.van.kuang.aspectj.in.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonObjectForAnnotation {

    private final static Logger logger = LoggerFactory.getLogger(CommonObjectForAnnotation.class);

    public void withoutParamAndReturnValue() {
        logger.info("----------Invoked withoutParamAndReturnValue()");
    }

    public void withoutReturnValue(String argument) {
        logger.info("----------Invoked withoutReturnValue({})", argument);
    }

    public String withReturnValue(String argument) {
        logger.info("----------Invoked withReturnValue({})", argument);
        return "RESULT";
    }

    public String withExceptionThrowout() {
        logger.info("----------Invoked withExceptionThrowout()");
        throw new RuntimeException("TEST");
    }

    public static void staticMethod() {
        logger.info("----------Invoked staticMethod()");
    }

    @Override
    public String toString() {
        return "CommonObjectForAnnotation{}";
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CommonObjectForAnnotation commonObject = new CommonObjectForAnnotation();
        commonObject.withoutParamAndReturnValue();
        commonObject.withoutReturnValue("ARGUMENT");
        commonObject.withReturnValue("ARGUMENT");

        try {
            commonObject.withExceptionThrowout();
        } catch (Exception ignore) {
        }

        String s = commonObject.toString();
        System.out.println(s);

        CommonObjectForAnnotation.staticMethod();
    }
}
