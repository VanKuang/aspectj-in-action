package cn.van.kuang.aspectj.in.action;

public aspect ObjectAspect {

    pointcut test(): call(void CommonObject.methodWithoutParamAndReturnValue());

    before(): test() {
        System.out.println("BEFORE");
    }

    after(): test() {
        System.out.println("AFTER");
    }

}
