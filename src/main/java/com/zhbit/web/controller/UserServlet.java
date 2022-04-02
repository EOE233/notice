package com.zhbit.web.controller;


import com.zhbit.bean.User;
import com.zhbit.biz.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6971717725995508517L;

	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserBiz userBiz = new UserBiz();
		User loginUser = userBiz.login(userName,password);
		if (loginUser!=null){
			request.getSession().setAttribute("LOGINED_USER", loginUser);
	 		request.getRequestDispatcher("/page/system/backIndex.jsp").forward(request, response);
	 	}else{
	 		request.setAttribute("message", "登录失败");
	 		request.getRequestDispatcher("login.jsp").forward(request, response);
	 } 

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
