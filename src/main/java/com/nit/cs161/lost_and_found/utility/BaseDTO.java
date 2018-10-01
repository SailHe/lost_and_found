package com.nit.cs161.lost_and_found.utility;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Description: 基础DTO类 继承此类后不用实现toBean 并且兼容EntityExistent接口<p>
 *
 * @Package: com.nit.cs161.lost_and_found.utility
 * @author: SailHe
 * @date: 2018/4/9 12:01
 */
public abstract class BaseDTO<EntityBeanType> implements EntityExistent {

    private Class beanClass;

    private EntityBeanType newBean() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (EntityBeanType) beanClass.getConstructor().newInstance();
    }


    public BaseDTO(Class beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public Class beanClass() {
        return beanClass;
    }

    @Override
    public EntityBeanType toBean() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        EntityBeanType bean = newBean();
        BeanUtils.copyProperties(this, bean);
        return bean;
    }


    /**
     * Descriptions: 以下是Demo<p>
     *
     * @author SailHe
     * @date 2018/4/11 22:28
     */
    private static class DemoBean {
        private Integer value;

        public DemoBean() {
            this.value = 0;
            System.out.println("DemoBean 空 Constructor");
        }

        public DemoBean(Integer value) {
            this.value = value;
            System.out.println("DemoBean 带参 Constructor");
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private static class DemoDTO extends BaseDTO<DemoBean> {

        private Integer value;

        public DemoDTO(Integer value) {
            super(DemoBean.class);
            this.value = value;
            System.out.println("TempDTO Constructor");
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }


}
