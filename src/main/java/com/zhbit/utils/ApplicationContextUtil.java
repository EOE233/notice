package com.zhbit.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
    public static ApplicationContext creat() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        return context;
    }
}
