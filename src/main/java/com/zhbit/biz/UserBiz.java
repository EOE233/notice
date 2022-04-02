package com.zhbit.biz;

import com.zhbit.bean.User;
import com.zhbit.mapper.UserMapper;
import com.zhbit.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Yanea
 * 2022/3/28 0:01
 */
public class UserBiz {
    SqlSession session = SqlSessionUtil.creat();
    UserMapper mapper = session.getMapper(UserMapper.class);

    /**
     * 用户登录
     */
    public User login(String userName, String password) {
        return mapper.getUserByPassword(userName, password);
    }

    /**
     * 用户注册
     */
    public int register(String username, String password) {
        return mapper.insertUser(username, password);
    }

    /**
     * 更新用户信息
     */
    public int update(int uNo, String uName, String uPassword) {
        return mapper.updateUser(uNo, uName, uPassword);
    }
}
