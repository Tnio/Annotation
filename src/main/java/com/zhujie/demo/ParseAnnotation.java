package com.zhujie.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/3/10.
 */
public class ParseAnnotation {

    public static void main(String[] args) {
        try {
            //1.使用类加载器或者Class对象
            Class c=Class.forName("com.zhujie.demo.Child");
            //2.获得类上面的注解
            Boolean isExsit = c.isAnnotationPresent(Description.class);
            if(isExsit){
                 // 3.拿到注解实例
                 Description d = (Description) c.getAnnotation(Description.class);
                System.out.println(d.value());
            }

            //4.拿到方法的注解
            Method[] ms= c.getMethods();
            for (Method m : ms) {
                boolean isExist=m.isAnnotationPresent(Description.class);
                if(isExist){
                    Description d=(Description) m.getAnnotation(Description.class);
                    System.out.println(d.value());
                }
            }

            //对于方法上注解解析另外一种方式
            for (Method m : ms) {
                Annotation[] annotations = m.getAnnotations();
                for (Annotation a : annotations) {
                    if(a instanceof Description){
                        Description d= (Description) a;//向下转化,多态
                        System.out.println(d.value());
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
