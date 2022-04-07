package com.zhbit.test.springtest;

import com.zhbit.bean.Notice;
import com.zhbit.bean.User;
import com.zhbit.biz.NoticeBiz;
import com.zhbit.biz.UserBiz;
import com.zhbit.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        NoticeBiz noticeBiz = context.getBean("noticeBiz", NoticeBiz.class);
        List<Notice> list = noticeBiz.getAllNotice();
        for (Notice notice : list) {
            System.out.println(notice);
        }
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserBiz userBiz = context.getBean("userBiz", UserBiz.class);
        User user = userBiz.getUserAndNotice(1);
        System.out.println(user);
    }

}
