package cn.van.kuang.aspectj.in.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonObject {

    private final static Logger logger = LoggerFactory.getLogger(CommonObject.class);

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
        return "CommonObject{}";
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CommonObject commonObject = new CommonObject();
        commonObject.withoutParamAndReturnValue();
        commonObject.withoutReturnValue("ARGUMENT");
        commonObject.withReturnValue("ARGUMENT");

        try {
            commonObject.withExceptionThrowout();
        } catch (Exception ignore) {
        }

        commonObject.toString();

        new Object().toString();

        logger.info("Inter-type, hashCode: {}", commonObject.hashCode());

        CommonObject.staticMethod();
    }
}
