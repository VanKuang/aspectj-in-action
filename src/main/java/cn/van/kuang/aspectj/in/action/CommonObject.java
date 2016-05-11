package cn.van.kuang.aspectj.in.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonObject {

    private final static Logger logger = LoggerFactory.getLogger(CommonObject.class);

    public void methodWithoutParamAndReturnValue() {
        logger.info("Invoked methodWithoutParamAndReturnValue()");
    }

    public void methodWithoutReturnValue(String argument) {
        logger.info("Invoked methodWithoutReturnValue({})", argument);
    }

    public String methodWithReturnValue(String argument) {
        logger.info("Invoked methodWithReturnValue({})", argument);
        return "RESULT";
    }

    public String methodWithExceptionThrowout() {
        logger.info("Invoked methodWithException()");
        throw new RuntimeException("TEST");
    }

    public String methodWithCatchException() {
        logger.info("Invoked methodWithCatchedException()");

        try {
            throw new RuntimeException("TEST");
        } catch (Exception e) {
            logger.error("Exception throw");
        }

        return "RESULT";
    }

    public static void main(String[] args) {
        CommonObject commonObject = new CommonObject();
        commonObject.methodWithoutParamAndReturnValue();
        commonObject.methodWithoutReturnValue("ARGUMENT");
        commonObject.methodWithReturnValue("ARGUMENT");

        try {
            commonObject.methodWithExceptionThrowout();
        } catch (Exception ignore) {
        }
        commonObject.methodWithCatchException();
    }
}
