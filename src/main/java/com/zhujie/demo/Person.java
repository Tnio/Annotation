package com.zhujie.demo;

/**
 * Created by Administrator on 2018/3/10.
 */
@Description("i am interface")
public class Person {
    @Description("i am interface method")
    public String name(){
        return null;
    }

    public int age(){
        return 0;
    };

    @Deprecated    //表示该方法已经过时
    public void sing(){
        
    }
}
