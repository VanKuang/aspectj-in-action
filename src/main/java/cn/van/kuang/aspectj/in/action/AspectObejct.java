package cn.van.kuang.aspectj.in.action;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AspectObejct {

    private final static Logger logger = LoggerFactory.getLogger(AspectObejct.class);

    @Before("call(void CommonObject.methodWithoutParamAndReturnValue())")
    public void before() {
        logger.info("BEFORE");
    }

}
