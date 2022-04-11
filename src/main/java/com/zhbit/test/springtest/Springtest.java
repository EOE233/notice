package com.zhbit.test.springtest;

import com.zhbit.bean.Notice;
import com.zhbit.bean.Type;
import com.zhbit.bean.User;
import com.zhbit.biz.NoticeBiz;
import com.zhbit.biz.TypeBiz;
import com.zhbit.biz.UserBiz;
import com.zhbit.utils.ApplicationContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Springtest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        NoticeBiz noticeBiz = context.getBean("noticeBiz", NoticeBiz.class);
        List<Notice> list = noticeBiz.getAllNotice();

        for (Notice notice : list) {
            System.out.println(notice);
        }
    }

    @Test
    public void test2() {
        ApplicationContext context = ApplicationContextUtil.creat();
        TypeBiz typeBiz = context.getBean("typeBiz", TypeBiz.class);
        List<Type> list = typeBiz.getAllType();
        for (Type type : list) {
            System.out.println(type);
        }
    }

    @Test
    public void test3() {
        ApplicationContext context = ApplicationContextUtil.creat();
        UserBiz userBiz = context.getBean("userBiz", UserBiz.class);
        List<User> list = userBiz.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

    }


}
