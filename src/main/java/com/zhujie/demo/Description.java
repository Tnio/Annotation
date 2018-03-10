package com.zhujie.demo;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/3/10.
 */
@Target({ElementType.METHOD, ElementType.TYPE})   //元注解，作用域，ElementType.METHOD--作用在方法上，ElementType.TYPE--作用在类上
@Retention(RetentionPolicy.RUNTIME) //元注解，生命周期
@Inherited //允许子注解来继承
public @interface Description {
      String value();
}
