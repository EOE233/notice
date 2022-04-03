<%--
  Created by IntelliJ IDEA.
  User: Yanea
  Date: 2022/4/2
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模糊查询</title>
    <script type="text/javascript" language="javascript">
        function checkNotice() {
            var nTitle = form1.Ntitle.value;
            if ((nTitle == null) || (nTitle == "")) {
                alert("请填写想要查询的公告名称！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form action="http://localhost:8080/notice/noticeServlet" name="form1" method="post" onsubmit="javascript: return checkNotice();">
    <fieldset>
        <legend>通过公告名称模糊查询</legend>
        <table>
            <tr>
                <td>公告名称</td>
                <td><input type="text" name="Ntitle"></td>
            </tr>
            <tr>
                <input type="hidden" name="method" value="getNoticeByNameM">
                <td></td>
                <td><input type="submit" value="查询"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
