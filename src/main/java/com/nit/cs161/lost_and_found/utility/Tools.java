package com.nit.cs161.lost_and_found.utility;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Description: 工具类
 * 一些简短的泛型方法(多为提取方法: 有多处使用的雷同方法)<p>
 *
 * @Package: com.nit.lab205.mayoung.utility
 * @author: SailHe
 * @date: 2018/8/29 15:30
 */
public class Tools {
    /**
     * Descriptions: 用List.for-each即可<p>
     *
     * @author SailHe
     * @date 2018/8/29 14:56
     */
    public interface CustomTask<BeanType> {
        /**
         * Descriptions: 自定义任务<p>
         *
         * @param bean 传入的实体
         * @author SailHe
         * @date 2018/8/29 13:08
         */
        void task(BeanType bean);
    }

    public interface KeyGeter<Key, Bean> {
        /**
         * Descriptions: 返回Key<p>
         *
         * @param bean 传入的实体
         * @return 返回自定义键
         * @author SailHe
         * @date 2018/8/29 13:26
         */
        Key getKey(Bean bean);
    }

    /**
     * Descriptions: key映射BeanList, 一对多<p>
     *
     * @TODO 允许重复key的Map
     * @author SailHe
     * @date 2018/8/29 12:56
     */
    public static <Key, BeanType> void calcKeyMapList(
            List<BeanType> beanList, Map<Key, List<BeanType>> keyMapList
            , KeyGeter<Key, BeanType> keyGeter) {
        for (BeanType bean : beanList) {
            if (keyMapList.get(keyGeter.getKey(bean)) == null) {
                List tempBeanList = new LinkedList<>();
                tempBeanList.add(bean);
                keyMapList.put(keyGeter.getKey(bean), tempBeanList);
            } else {
                keyMapList.get(keyGeter.getKey(bean)).add(bean);
            }
        }
    }

    /**
     * Descriptions: key映射Bean<p>
     * 此方法在keyGeter.getKey(bean)与bean.equals()等价的前提下生成的Map与Set等价
     *
     * @throws Exception 参数的List中key重复异常, 映射结果元素个数不相等异常
     * @author SailHe
     * @date 2018/9/30 12:29
     */
    public static <Key, BeanType> void calcKeyMapBean(
            List<BeanType> beanList, Map<Key, BeanType> keyMapBean
            , KeyGeter<Key, BeanType> keyGeter) throws Exception {
        for (BeanType bean : beanList) {
            if (keyMapBean.get(keyGeter.getKey(bean)) == null) {
                keyMapBean.put(keyGeter.getKey(bean), bean);
            } else {
                throw new Exception("key值重复: 重复添加映射关系!");
            }
        }
        if (beanList.size() != keyMapBean.size()) {
            throw new Exception("映射前后的元素个数不相等!");
        }
    }

    /**
     * Descriptions: 将一个合法的列表转换为一个列表中的元素<p>
     *
     * @param beanList 有且仅有一个元素的列表
     * @return 返回列表中唯一的元素
     * @author SailHe
     * @date 2018/10/6 13:57
     */
    public static <BeanType> BeanType uniqueList(List<BeanType> beanList) throws Exception {
        BeanType resultUser = null;
        if (beanList.size() > 1) {
            throw new Exception("元素重复!");
        } else if (beanList.isEmpty()) {
            // do nothing
        } else {
            resultUser = beanList.get(0);
        }
        return resultUser;
    }
}
