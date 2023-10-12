package com.sukai.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * 数据源切面
 * @author chengsukai
 */
public class DataSourceAspect {

    /**
     * 拦截数据源的标识,并设置到线程存储中,用于后续切换
     *
     * @param joinPoint 切点
     */
    public void intercept(JoinPoint joinPoint) {
        //获取切入点的类反射
        Class<?> targetClass = joinPoint.getTarget().getClass();
        //获取方法参数
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        for (Class<?> clazz : targetClass.getInterfaces()) {
            dealDataSource(clazz, signature.getMethod());
        }
        //默认使用目标类型的注解,如果没有则使用其实现的接口注解
        dealDataSource(targetClass, signature.getMethod());
    }

    /**
     * 提取目标对象方法注解和注解中的数据源标识
     *
     * @param clazz 类对象
     * @param method 方法
     */
    private void dealDataSource(Class<?> clazz, Method method) {
        try {
            //获取方法参数
            Class<?>[] paramTypeArr = method.getParameterTypes();
            //检查是否为DataSource注解
            if (clazz.isAnnotationPresent(DataSource.class)) {
                //获取注解对象
                DataSource dataSource = clazz.getAnnotation(DataSource.class);
                DataSourceContextHolder.setDataSource(dataSource.value());
            }else{
                DataSourceContextHolder.setDataSource("master");
            }
            //方法注解,可以覆盖类型注解
            Method m = clazz.getMethod(method.getName(), paramTypeArr);
            if (m.isAnnotationPresent(DataSource.class)) {
                DataSource dataSource = m.getAnnotation(DataSource.class);
                DataSourceContextHolder.setDataSource(dataSource.value());
            }else{
                DataSourceContextHolder.setDataSource("master");
            }
        } catch (Exception e) {
            System.out.println(clazz + ":" + e.getMessage());
        }
    }
}
