package com.zhbit.biz;

import com.zhbit.bean.User;
import com.zhbit.mapper.UserMapper;
import com.zhbit.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yanea
 * 2022/3/28 0:01
 */
@Service
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

    /**
     * 获取所有用户
     */
    public List<User> getAllUsers () {
        return mapper.getAllUserList();
    }

    /**
     * 获取用户一对多的通知
     */
    public User getUserAndNotice (int uNo) {
        return mapper.getUserAndNotice(uNo);
    }
}
