<%@ page import="com.zhbit.bean.User" %>
<%-- Created by IntelliJ IDEA. User: Yanea Date: 2022/3/30 Time: 16:08 To change this template use File | Settings |
    File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>查询个人信息</title>
    <% User user = (User) session.getAttribute("LOGINED_USER"); %>
</head>

<body>
<form action="http://localhost:8080/notice/userServlet">
    <table>
        <tr>
            <td>id</td>
            <td>用户名</td>
            <td>密码</td>
        </tr>
        <tr>
            <td>
                <%=user.getuNo()%>
            </td>
            <td>
                <input type="text" name="userName" value="<%=user.getuName()%>" readonly="readonly">
            </td>
            <td>
                <input type="text" name="password" value="<%=user.getuPassword()%>" readonly="readonly">
            </td>
        </tr>
    </table>
</form>
<a href="alter.jsp" target="showNotice">
    <button>修改个人信息</button>
</a>
</body>

</html>