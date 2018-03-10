package com.zhujie.demo;

/**
 * Created by Administrator on 2018/3/10.
 */
@Description("i am class annotation")
public class Child extends Person {

    @Override
    @Description("i am method annnotation")
    public String name() {
        return null;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {

    }
}
