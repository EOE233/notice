package com.zhbit.web.controller;

import com.zhbit.bean.User;
import com.zhbit.biz.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * 修改用户信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBiz userBiz = new UserBiz();
        String uName = req.getParameter("uName");
        String uPassword = req.getParameter("uPassword");
        User user = (User) req.getSession().getAttribute("LOGINED_USER");
        userBiz.update(user.getuNo(), uName, uPassword);
        user.setuName(uName);
        user.setuPassword(uPassword);
        req.getSession().setAttribute("LOGINED_USER", user);
        req.getRequestDispatcher("checkinfo.jsp").forward(req, resp);
    }
}
