<%@ page import="com.zhbit.bean.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Yanea
  Date: 2022/4/3
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" language="javascript">
        function checkUser() {
            var uNo = form1.uNo.value;
            if (uNo == null || uNo == "") {
                alert("想要查询的用户id不能为空！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<%
    List<User> list = (List<User>) request.getAttribute("list");
%>
<form action="userServlet" name="form1" method="post" onsubmit="javascript: return checkUser();">
    <fieldset>
        <legend>一对多查询</legend>
        <table>
            <tr>
                <td>选择用户ID</td>
            </tr>
            <tr>
                <td>
                    <input type="text" name="uNo" list="uNoList">
                    <datalist id="uNoList">
                        <%
                            for (User user : list) {
                        %>
                        <option><%=user.getuNo()%></option>
                        <%
                            }
                        %>
                    </datalist>
                </td>
            </tr>
            <tr>
                <input type="hidden" name="method" value="getUserAndNotice">
                <td>
                    <input type="submit" value="查询">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
