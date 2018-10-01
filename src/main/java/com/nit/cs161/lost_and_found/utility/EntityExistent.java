package com.nit.cs161.lost_and_found.utility;

import java.lang.reflect.InvocationTargetException;

/**
 * Description: 存在实体的类型接口<p>
 *
 * @Package: com.nit.cs161.lost_and_found.utility
 * @author: SailHe
 * @date: 2018/4/9 12:01
 */
public interface EntityExistent {

    /**
     * Descriptions: <p>
     * @return 继承此接口的DTO类型对应的Bean的类型名称对象 即 Bean.class
     * @author SailHe
     * @date 2018/4/9 12:27
     */
    Class beanClass();

    /**
     * Descriptions: 转换为实体对象<p>
     * @return Bean对象
     * @author SailHe
     * @date 2018/4/9 17:55
     */
    Object toBean() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException ;
}
