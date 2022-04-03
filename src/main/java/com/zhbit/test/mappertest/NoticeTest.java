package com.zhbit.test.mappertest;

import com.zhbit.bean.Notice;
import com.zhbit.mapper.NoticeMapper;

import com.zhbit.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

/**
 * @author Yanea
 * 2022/3/27 21:29
 */
public class NoticeTest {
    /**
     * 测试addNotice方法
     */
    @Test
    public void test1(){
        SqlSession session = SqlSessionUtil.creat();
        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
        java.sql.Date date = new java.sql.Date(new Date().getTime());
        Notice notice = new Notice(9,"idea测试","内容","教务处", date,2,1);
        boolean b = mapper.addNotice(notice);
    }

    /**
     * deleteNotice
     */
    @Test
    public void test2(){
        SqlSession session = SqlSessionUtil.creat();
        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
        mapper.deleteNotice(9);
    }

    /**
     * updateNotice
     */
    @Test
    public void test3(){
        SqlSession session = SqlSessionUtil.creat();
        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
        java.sql.Date date = new java.sql.Date(new Date().getTime());
        Notice notice = new Notice(7,"idea测试","内容","教务处", date,2,1);
        mapper.updateNotice(notice);
    }

    /**
     * getAllNoticeList
     */
    @Test
    public void test4(){
        SqlSession session = SqlSessionUtil.creat();
        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
        List<Notice> list = mapper.getAllNoticeList();
        for (Notice notice : list) {
            System.out.println(notice);
        }
    }

    /**
     * getNoticeByType
     */
    @Test
    public void test5(){
        SqlSession session = SqlSessionUtil.creat();
        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
        List<Notice> noticeByType = mapper.getNoticeByType(3);
        for (Notice notice : noticeByType) {
            System.out.println(notice);
        }
    }

    /**
     * getNoticeById
     */
    @Test
    public void test6(){
        SqlSession session = SqlSessionUtil.creat();
        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
        Notice noticeById = mapper.getNoticeById(6);
        System.out.println(noticeById);
    }

    /**
     * 模糊查询 名称
     */
    @Test
    public void test7() {
        SqlSession session = SqlSessionUtil.creat();
        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
        List<Notice> list = mapper.getNoticeByNameM("通知");
        list.forEach(notice -> System.out.println(notice));

    }

    /**
     * 时间区间查询
     */
    @Test
    public void test8() {
        SqlSession session = SqlSessionUtil.creat();
        NoticeMapper mapper = session.getMapper(NoticeMapper.class);
        List<Notice> list = mapper.getNoticeByTime("2013-01-01", "2013-02-01");
        list.forEach(notice -> System.out.println(notice));
    }
}
