package com.nit.cs161.lost_and_found.utility;


import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public final class Upgrade {

    /**
     * @Description: 单表更新数据
     * @Author: 卫超越
     * @Date: 2018/4/5 下午5:49
     * @return:
     */
    public static String updateUpgrade(Object bean, Map<String, Object> filds) throws Exception {
        String beanName = (String) bean.getClass().getMethod("getBeanName").invoke(bean);
        String newBeanName = "";
        Class cls = Class.forName("com.nit.cs161.lost_and_found.entity." + beanName);
        boolean isExist = cls.isAnnotationPresent(Table.class);
        if (isExist) {
            Table table = (Table) cls.getAnnotation(Table.class);
            newBeanName = table.catalog() + "." + table.schema() + "." + table.name();
        }
        String sql = "UPDATE " + newBeanName + " SET ";
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field f : fields
                ) {
            String name = f.getName();
            String nameUp = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method m = bean.getClass().getMethod("get" + nameUp);
            if ((m.invoke(bean) != null) && (!filds.containsKey(name))) {
                //重新获取bean 中的字段名
                Method method = cls.getMethod("get" + nameUp);
                if (method.isAnnotationPresent(Column.class)) {
                    name = method.getAnnotation(Column.class).name();
                }
                sql += name + " = '" + m.invoke(bean) + "', ";
            }
        }
        sql = sql.substring(0, sql.length() - 2);
        sql += " WHERE ";
        for (String key : filds.keySet()
                ) {
            String keyName = key.substring(0, 1).toUpperCase() + key.substring(1);
            //重新获取bean 中的字段名
            Method method = cls.getMethod("get" + keyName);
            if (method.isAnnotationPresent(Column.class)) {
                keyName = method.getAnnotation(Column.class).name();
            }
            sql += keyName + " = '" + filds.get(key) + "' and ";
        }
        sql = sql.substring(0, sql.length() - 4);
        return sql;
    }

}
