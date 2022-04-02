package com.zhbit.web.controller;

import com.zhbit.biz.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * 用户注册
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        UserBiz userBiz = new UserBiz();
        int result = userBiz.register(userName, password);
        if (result == 1) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }else {
            req.setAttribute("message", "注册失败");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}
