<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户登录</title>
<script type="text/javascript" language="javascript">
	function checkLogin(){
		var userName = document.getElementById("userName").value;
		var password = document.getElementById("password").value;
		if (userName==null || userName==""){
			alert("用户名不能为空！");
			return false;
		}else if (password==null || password==""){
			alert("密码不能为空！");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
    <div style="font-color:red"></div>
	<form id="login" name="login" action="http://localhost:8080/notice/userServlet" onsubmit="javascript: return checkLogin();" method="post" >
        <% 
        	String errorMsg = (String)request.getAttribute("message");
        	if (errorMsg!=null){
        		out.print("<div style='color:red'>" +errorMsg + "</div>");
    		}    	 
        %>
    	用户名：<input type="text" id="userName" name="userName"/>
    	<br />
     	 密&nbsp;&nbsp;码：<input type="password" id="password" name="password"/>
        <br/>
		<input type="hidden" name="method" value="doLogin"/>
        <input type="submit" value="登录"/>
        <input type="reset" value="重置"/>
		<a href="register.jsp"><input type="button" value="注册"></a>
    </form>
</body>
</html>
