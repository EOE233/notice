<%@ page import="com.zhbit.bean.Notice" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zhbit.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: Yanea
  Date: 2022/4/3
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("User");
    List<Notice> list = user.getNotices();
    if (list==null || list.size()==0){
%>
<div>没有记录</div>
<% } else {
    for (Notice notice: list){
%>
<a href="noticeServlet?method=showNoticeDetail&noticeId=<%=notice.getnNo()%>"><%=notice.getnTitle()%></a><br />
<%
        }
    }
%>
</body>
</html>
