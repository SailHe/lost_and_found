package com.nit.cs161.lost_and_found.utility;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.time.StopWatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 方法运行时间测试(用于单元测试)
 *
 * @author liuyt
 * @author hf
 * @date 2014-11-16 下午3:39:08
 * @bolgs http://www.cnblogs.com/liuyitian/
 * @src http://www.cnblogs.com/liuyitian/p/4101531.html
 * @see StopWatch https://commons.apache.org/proper/commons-lang/javadocs/api-2.6/org/apache/commons/lang/time/StopWatch.html
 */
public class MethodTimeActive implements MethodInterceptor {
    /**
     * 自定义map集合，key：方法名，value：[0：运行次数，1：总时间]
     */
    private static Map<String, Long[]> methodTestInfo = new HashMap<>();

    /**
     * 拦截要执行的方法
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 创建一个计时器
        StopWatch watch = new StopWatch();
        // 计时器开始
        watch.start();
        // 执行方法
        Object object = invocation.proceed();
        // 计时器停止
        watch.stop();
        // 方法名称
        String methodName = invocation.getMethod().getName();
        // 获取计时器计时时间
        Long time = watch.getTime();
        if (methodTestInfo.containsKey(methodName)) {
            Long[] values = methodTestInfo.get(methodName);
            ++values[0];
            values[1] += time;
        } else {
            methodTestInfo.put(methodName, new Long[]{1L, time});
        }
        return object;
    }

    /**
     * Descriptions: 测试方法运行完毕后，取出定义的Map集合，显示数据<p>
     *
     * @author SailHe
     * @date 2018/5/18 20:42
     */
    public static void statisticsAfterMethod() {
        System.out.println("after:");
        Set<String> set = methodTestInfo.keySet();
        Long[] values;
        for (String key : set) {
            values = methodTestInfo.get(key);
            System.out.println(key + ":" + values[0] + "次，" + values[1] + "毫秒");
        }
    }
}
