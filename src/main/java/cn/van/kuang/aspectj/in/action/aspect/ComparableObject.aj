package cn.van.kuang.aspectj.in.action.aspect;

import cn.van.kuang.aspectj.in.action.CommonObject;

public aspect ComparableObject {

    declare parents:CommonObject implements Comparable;

    public int CommonObject.compareTo(Object o) {
        return o == null ? 0 : 1;
    }

    public static void main(String[] args) {
        CommonObject commonObject = new CommonObject();
        CommonObject newCommonObject = new CommonObject();

        System.out.println(commonObject.compareTo(newCommonObject));
    }

}