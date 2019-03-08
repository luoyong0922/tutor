package com.etc.utils;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 开发过程中，某个未被spring托管的类（例如MessageComponent）想调用一个被spring托管的对象的方法（例如MessageService对象），
 * 如果我们像下面代码的方式去调用方法，则会出现空指针的异常。
 * 解决办法
 */
@Component
public class ApplicationContextRegister   implements ApplicationContextAware {
    private static ApplicationContext applicationContext=null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationContextRegister.applicationContext==null) {
            ApplicationContextRegister.applicationContext = applicationContext;
        }
    }
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }
}
