package com.zhujie.project;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/3/10.
 */
@Target({ElementType.TYPE})   //元注解，作用域，ElementType.METHOD--作用在方法上，ElementType.TYPE--作用在类上
@Retention(RetentionPolicy.RUNTIME) //元注解，生命周期
public @interface Table {
    String value();
}
