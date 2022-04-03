<%--
  Created by IntelliJ IDEA.
  User: Yanea
  Date: 2022/3/28
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <script type="text/javascript" language="javascript">
        function checkRegister(){
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
    <form action="userServlet" id="register" onsubmit="javascript: return checkRegister()" method="post">
        <fieldset>
            <legend>注册信息</legend>
        <%
            String errorMsg = (String)request.getAttribute("message");
            if (errorMsg!=null){
                out.print("<div style='color:red'>" +errorMsg + "</div>");
            }
        %>
        <table>

                <tr>
                    <td>用户名</td>
                    <td><input type="text" id="userName" name="userName"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" id="password" name="password"></td>
                </tr>
                <tr>
                    <input type="hidden" name="method" value="doRegister">
                    <td><a href="login.jsp"><input type="button" value="返回登录"></a></td>
                    <td><input type="submit" value="注册"></td>
                </tr>
            </table>
            </fieldset>
        </table>
    </form>
</body>
</html>
