package com.nit.cs161.lost_and_found.utility;


import org.apache.commons.collections.map.HashedMap;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * Descriptions: hibernate query language生成器<p>
 *
 * @author SailHe
 * @date 2018/4/9 14:30
 */
public final class HqlGenerator {

    /**
     * Descriptions: 若是数字返回true<p>
     *
     * @author SailHe
     * @date 2018/4/9 18:15
     */
    static Boolean isNumeric(Object AObject) {
        Class cla = AObject.getClass();
        return cla == Byte.class || cla == Integer.class
                || cla == Long.class || cla == Short.class
                || cla == Double.class || cla == Float.class
                ;
    }

    /**
     * Descriptions: 如果参数的类型是Integer那么直接返回对应字符串 否则在外面加一个"" 若是Data会返回格式话的字符串<p>
     *
     * @author SailHe
     * @date 2018/4/9 15:37
     */
    static String hqlString(Object value) {
        //SQL Server的datetime2储存时用字符串 并且格式必须一样
        return isNumeric(value) ? value.toString()
                : value.getClass() == Date.class ? "'" + new DateGenerator((Date) value).toString() + "'"
                : "'" + value + "'";
    }

    /**
     * Descriptions: 将Class转为对应的包名<p>
     *
     * @author SailHe
     * @date 2018/4/23 20:45
     */
    public static String getPackageName(Class cls) {
        return cls.toString().replace("class ", "");
    }

    /**
     * Descriptions: 拼接筛选条件<p>
     *
     * @author SailHe
     * @date 2018/4/23 20:50
     */
    public static String getFilterCondition(Map<String, Object> filterFields){
        if(filterFields.size() > 0){
            String filterConditionHql = " WHERE ";
            for (Map.Entry<String, Object> entry : filterFields.entrySet()) {
                filterConditionHql += entry.getKey() + " = ";
                filterConditionHql += hqlString(entry.getValue());
                filterConditionHql += " AND ";
            }

            //尾" AND "
            return filterConditionHql.substring(0, filterConditionHql.length() - 5);
        }else{
            return "";
        }
    }

    /**
     * Descriptions: 返回该对象的过滤器(所有非空的字段都将作为筛选字段)<p>
     *
     * @author SailHe
     * @date 2018/4/23 21:03
     */
    public static Map<String, Object> getFilter(EntityExistent objDTO) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Map<String, Object> filterFields = new HashedMap();
        //获取Bean中所有的字段名
        Field[] fields = objDTO.getClass().getDeclaredFields();
        for (Field f : fields) {
            String name = f.getName();
            String lowerCamelCase = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
            //得到对应属性的get方法 f.get(bean)无法获取私有字段
            Method method = objDTO.getClass().getMethod(lowerCamelCase);
            //将非空且非筛选字段写入字符串
            if ((method.invoke(objDTO) != null) && !filterFields.containsKey(name)) {
                if (method.isAnnotationPresent(Column.class)) {
                    name = method.getAnnotation(Column.class).name();
                }
                filterFields.put(name, method.invoke(objDTO));
            }
        }
        return filterFields;
    }

    /**
     * Descriptions: 生成hql更新语句<p>
     *
     * @param filterFields 用于数据库查询时的筛选字段以及其值
     * @return 由objDTO的非空字段组成的 hql更新语句
     * @author SailHe
     * @date 2018/4/9 13:54
     */
    public static String upgrade(EntityExistent newObjDTO, Map<String, Object> filterFields) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        /*
        包括时间格式在内的数据类型问题,
        末尾; -> unexpected char: ';'  sql可以
        set goodsId = 40 -> 会无法识别标识列
        */
        String hql = "UPDATE "
                + newObjDTO.beanClass().toString().replace("class ", "")
                + " SET ";
        //获取Bean中所有的字段名
        Field[] fields = newObjDTO.getClass().getDeclaredFields();
        for (Field f : fields) {
            String name = f.getName();
            String lowerCamelCase = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
            //得到对应属性的get方法 f.get(bean)无法获取私有字段
            Method method = newObjDTO.getClass().getMethod(lowerCamelCase);
            //将非空且非筛选字段写入字符串
            if ((method.invoke(newObjDTO) != null) && !filterFields.containsKey(name)) {
                if (method.isAnnotationPresent(Column.class)) {
                    name = method.getAnnotation(Column.class).name();
                }
                hql += name + " = " + hqlString(method.invoke(newObjDTO)) + ", ";
            }
        }
        //尾逗号
        hql = hql.substring(0, hql.length() - 2);

        hql += " WHERE ";
        for (Map.Entry<String, Object> entry : filterFields.entrySet()) {
            hql += entry.getKey() + " = ";
            hql += hqlString(entry.getValue());
            hql += " AND ";
        }

        //尾" AND "
        hql = hql.substring(0, hql.length() - 5);
        return hql;
    }

    /**
     * Descriptions: 生成hql查询语句 该语句返回相应的DTO(必须有DTO的Bean构造器)<p>
     *
     * @author SailHe
     * @date 2018/4/23 20:34
     */
    public static String query(EntityExistent objDTO, Map<String, Object> filterFields) {
        String hql = "SELECT new " + getPackageName(objDTO.getClass()) + "(bean)";
        hql += " FROM " + getPackageName(objDTO.beanClass()) + " bean";
        hql += getFilterCondition(filterFields);
        return hql;
    }

    /**
     * Descriptions: 测试阶段 返回以示例非空字段为筛选器的hql查询语句<p>
     *
     * @author SailHe
     * @date 2018/4/23 21:21
     */
    public static String query(EntityExistent objDTO) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return query(objDTO, getFilter(objDTO));
    }

}
