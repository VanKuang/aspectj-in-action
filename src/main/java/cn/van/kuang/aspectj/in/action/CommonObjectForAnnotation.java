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

    public int combineMethod() {
        String member1 = String.valueOf(1);

        int member2 = Integer.valueOf(member1);

        logger.info("{}, {}", member1, member2);

        return member2;
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

        int i = commonObject.combineMethod();
        System.out.println(i);

        CommonObjectForAnnotation.staticMethod();
    }
}
