package cn.van.kuang.aspectj.in.action.aspect;

import cn.van.kuang.aspectj.in.action.CommonObject;

public aspect InterTypeAspect {

    public int CommonObject.hashCode() {
        return 1;
    }

}
