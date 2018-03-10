package com.zhujie.project;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/3/10.
 */
public class Test {
    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(10);

        Filter f2 = new Filter();
        f2.setUserName("lucy");

        Filter f3 = new Filter();
        f3.setEmail("liu@sina.com,7777@qq.com");//查询邮箱之一的用户

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);

    }

    /**
     * 拼接sql语句,根据表和实体类的映射   @Table:数据库表名   @Column:数据库的列名
     *
     * @param f
     * @return
     */
    private static String query(Filter f) {
        StringBuffer sb = new StringBuffer();
        //1.获取Class对象
        Class c = f.getClass();
        //2.类上面获得名字为Table的注解
        boolean isExist = c.isAnnotationPresent(Table.class);
        if (!isExist) {
            return null;
        }
        //2.获得@table的value
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("select*from ").append(tableName).append(" where 1=1");

        //3.遍历所有字段
        Field[] fArray = c.getDeclaredFields();
        for (Field field : fArray) {
            //字段上有@Column映射注解,则处理,否则不处理
            boolean fExist = field.isAnnotationPresent(Column.class);
            if (!fExist) {
                continue;
            }
            //4.1 拿到字段名
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();

            //4.2  拿到字段名称
            String fieldName = field.getName();

            //4.3  拿到对象字段的值,可以是int,double,string,这里定义为object类型
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            //通过反射获得method
            Object fieldValue = null;
            try {
                Method getMethod = c.getMethod(getMethodName); //字段的get方法
                //获得对象调用方法的返回值
                fieldValue = getMethod.invoke(f);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //4.4 拼接sql,
            // 1.如果是字符串,2边需要加引号,如果是数值,不加
            // 2.字符串的值为null 或者 数值为0,不需要拼接到sql上
            if (fieldValue == null ||
                    (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
                continue;
            }
            sb.append(" and ").append(fieldName);
            //如果string里有逗号,则切割 "liu@sina.com,7777@qq.com"
            if (fieldValue instanceof String) {
                if (((String) fieldValue).contains(",")) {
                    String[] values = ((String) fieldValue).split(",");
                    sb.append(" in(");
                    for (String v : values) {
                        sb.append("'").append(v).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append(")");
                } else {
                    sb.append("=").append("'").append(fieldValue).append("'");
                }
            } else if (fieldValue instanceof Integer) {
                sb.append("=").append(fieldValue);
            }
        }
        return sb.toString();
    }
}
