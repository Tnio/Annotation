package com.zhujie.project;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/3/10.
 */
@Target({ElementType.FIELD})   //元注解，作用域,felid
@Retention(RetentionPolicy.RUNTIME) //元注解，生命周期
public @interface Column {
    String value();
}
