package com.zhbit.test.mappertest;

import com.zhbit.bean.Type;
import com.zhbit.mapper.TypeMapper;
import com.zhbit.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Yanea
 * 2022/3/27 20:50
 */
public class TypeTest {
    /**
     * 测试getAllTypeList
     */
    @Test
    public void test() {
        SqlSession session = SqlSessionUtil.creat();
        TypeMapper mapper = session.getMapper(TypeMapper.class);
        List<Type> list = mapper.getAllTypeList();
        list.forEach(type -> System.out.println(type));
    }

    /**
     * 删除通知类型
     */
    @Test
    public void test1() {
        SqlSession session = SqlSessionUtil.creat();
        TypeMapper mapper = session.getMapper(TypeMapper.class);
        int result = mapper.deleteType(5);
        System.out.println(result);
    }

    /**
     * 添加通知类型
     */
    @Test
    public void test2() {
        SqlSession session = SqlSessionUtil.creat();
        TypeMapper mapper = session.getMapper(TypeMapper.class);
        int result = mapper.addType("测试数据");
        System.out.println(result);
    }

    /**
     * 修改通知类型
     */
    @Test
    public void test3() {
        SqlSession session = SqlSessionUtil.creat();
        TypeMapper mapper = session.getMapper(TypeMapper.class);
        int result = mapper.alterType(6, "修改数据");
        System.out.println(result);
    }

    /**
     * 通过编号获取公告类型
     */
    @Test
    public void test4() {
        SqlSession session = SqlSessionUtil.creat();
        TypeMapper mapper = session.getMapper(TypeMapper.class);
        Type type = mapper.getTypeByID(1);
        System.out.println(type);
    }
}
