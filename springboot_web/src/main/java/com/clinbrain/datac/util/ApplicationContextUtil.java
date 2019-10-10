package com.clinbrain.datac.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author：ligen
 * @Date: Created:17:57  2019/7/9
 * @Description: spring bean帮助类
 **/
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(String name) {
        checkApplicationContext();
        if (applicationContext.containsBean(name)) {
            return (T) applicationContext.getBean(name);
        }
        return null;
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        return (T) applicationContext.getBeansOfType(clazz);
    }

    private static void checkApplicationContext() {
        if (applicationContext == null)
            throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextUtil");
    }
    public synchronized static void registerSingletonBean(String beanName,Class clzz,Map<String,Object> original) {
        checkApplicationContext();
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ApplicationContextUtil.getApplicationContext().getAutowireCapableBeanFactory();
        if(beanFactory.containsBean(beanName)){
            removeBean(beanName);
        }
        GenericBeanDefinition definition = new GenericBeanDefinition();
        //类class
        definition.setBeanClass(clzz);
        //属性赋值
        definition.setPropertyValues(new MutablePropertyValues(original));
        //注册到spring上下文
        beanFactory.registerBeanDefinition(beanName, definition);
    }
    public synchronized static void registerSingletonBean(String beanName,Object obj,Map<String,Object> original) {
        checkApplicationContext();
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ApplicationContextUtil.getApplicationContext().getAutowireCapableBeanFactory();
        if(beanFactory.containsBean(beanName)){
            removeBean(beanName);
        }
        GenericBeanDefinition definition = new GenericBeanDefinition();
        //类class
        definition.setBeanClass(obj.getClass());
        //属性赋值
        definition.setPropertyValues(new MutablePropertyValues(original));
        //注册到spring上下文
        beanFactory.registerBeanDefinition(beanName, definition);
    }

    /**
     * 删除spring中管理的bean
     * @param beanName
     */
    public static void removeBean(String beanName){
        ApplicationContext ctx = ApplicationContextUtil.getApplicationContext();
        DefaultListableBeanFactory acf = (DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory();
        if(acf.containsBean(beanName)) {
            acf.removeBeanDefinition(beanName);
        }
    }
}
