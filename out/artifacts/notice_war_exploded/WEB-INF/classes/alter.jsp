<%@ page import="com.zhbit.bean.User" %><%-- Created by IntelliJ IDEA. User: Yanea Date: 2022/3/30 Time: 16:47 To change this template use File | Settings |
    File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>修改个人信息</title>
    <script type="text/javascript" language="javascript">
        function checkLogin(){
            var userName = document.getElementById("uName").value;
            var password = document.getElementById("uPassword").value;
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
    <%
        User user = (User) session.getAttribute("LOGINED_USER");
    %>
</head>

<body>
<form action="userServlet" onsubmit="javascript: return checkLogin();" method="post">
    <fieldset>
        <legend>修改个人信息</legend>
        <table>
            <tr>
                <td>用户名</td>
                <td>密码</td>
            </tr>
            <tr>
                <td><input type="text" id="uName" name="uName" value="<%=user.getuName()%>"></td>
                <td><input type="password" id="uPassword" name="uPassword" value="<%=user.getuPassword()%>"></td>
            </tr>
            <tr>
                <input type="hidden" name="method" value="doUpdateUser">
                <td><input type="submit" name="submit" id="submit" value="修改"></td>
                <td></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>

</html>