package com.zhbit.web.controller;


import com.zhbit.bean.User;
import com.zhbit.biz.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
		String method = request.getParameter("method");
		if ("doLogin".equals(method)) {
			doLogin(request, response);
		} else if ("doRegister".equals(method)) {
			doRegister(request, response);
		} else if ("doUpdateUser".equals(method)) {
			doUpdateUser(request, response);
		} else if ("getUserAndNotice".equals(method)) {
			getUserAndNotice(request, response);
		} else if ("getAllUsers".equals(method)) {
			getAllUsers(request, response);
		}


	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * 登录验证
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doLogin (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserBiz userBiz = new UserBiz();
		int result = userBiz.register(userName, password);
		if (result == 1) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "注册失败");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	/**
	 * 修改用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doUpdateUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBiz userBiz = new UserBiz();
		String uName = request.getParameter("uName");
		String uPassword = request.getParameter("uPassword");
		User user = (User) request.getSession().getAttribute("LOGINED_USER");
		userBiz.update(user.getuNo(), uName, uPassword);
		user.setuName(uName);
		user.setuPassword(uPassword);
		request.getSession().setAttribute("LOGINED_USER", user);
		request.getRequestDispatcher("checkinfo.jsp").forward(request, response);
	}

	/**
	 * 获取所有用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getAllUsers (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("测试");
		UserBiz userBiz = new UserBiz();
		List<User> list = userBiz.getAllUsers();
		request.setAttribute("list", list);
		request.getRequestDispatcher("page/portal/selectUserAndNotice.jsp").forward(request, response);
	}

	/**
	 * 获取用户一对多的通知
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getUserAndNotice (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBiz userBiz = new UserBiz();
		int uNo = Integer.parseInt(request.getParameter("uNo"));
		User user = userBiz.getUserAndNotice(uNo);
		request.setAttribute("User", user);
		request.getRequestDispatcher("page/portal/showUserAndNotice.jsp").forward(request, response);
	}

}
