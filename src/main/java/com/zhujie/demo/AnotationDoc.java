package com.zhujie.demo;

/**
 * Created by Administrator on 2018/3/10.
 */
public class AnotationDoc {
    /**
     * 注解说明，java1.5之后引用
     */
    /*
        1.java中常见注解

           JDK自带注解： @override  @Deprecated  @Suppvisewarnings

           常见第三方注解：
                     @autowired              @InsertProvider
           spring    @service        mybatis @UpdateProvider
                     @repository             @options


        2.注解的分类
           1.源码注解
           2.编译时注解 ： 注解在源码和 .class文件中都存在，如 @override  @Deprecated  @Suppvisewarnings
           3.运行时注解 ： 运行阶段还会起作用，甚至会影响运行逻辑的注解

        3.如何解析注解
          通过反射获取类,函数或者成员上的运行时注解信息，从而实现动态控制程序运行的逻辑。
     */

//    @Target({ElementType.METHOD, ElementType.TYPE})   //元注解，作用域，ElementType.METHOD--作用在方法上，ElementType.TYPE--作用在注解上
//    @Retention(RetentionPolicy.RUNTIME) //元注解，生命周期
//    @Inherited //允许子注解来继承
//    @Documented
//    public @interface Description {        //@interface：定义注解
//
//        /*
//         *  1.成员类型是受限的，合法的类型包括 原始类型及 String,Class,Annotation,Enumeration
//         *  2.如果注解只有一个成员，则成员名必须取名为value()，在使用时可以忽略成员名和赋值号（=）
//         *  3.注解成员是无参的
//         */
//
//        // String value();
//        String desc();
//
//        String author();
//
//        int age() default 18;
//    }
//
//
//    //方法上注解
//    @Description(desc = "I am lucy",author = "Boy",age = 18)
//    public String eyeColor() {
//        return "red";
//    }


}