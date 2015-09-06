package com.evonymus.test.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainConfig {
    private final static String FILE_PATH="WEB-INF/main-servlet.xml";
    private static ApplicationContext appContext;

    public static ApplicationContext getAppContext() {
        if (appContext == null) {
            appContext = new ClassPathXmlApplicationContext(FILE_PATH);
        }
        return appContext;
    }

    public <T> T getBean(Class<T> theClass) {
        return getAppContext().getBean(theClass);
    }

}