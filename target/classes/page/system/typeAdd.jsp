<%--
  Created by IntelliJ IDEA.
  User: Yanea
  Date: 2022/4/2
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加公告类型</title>
    <script type="text/javascript" language="javascript">
        function checkType(){
            var tName = form1.TtypeName.value;
            if ((tName==null)||(tName=="")) {
                alert("请填写公告类型名称！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <form action="http://localhost:8080/notice/typeServlet" method="post" name="form1" onsubmit="javascript: return checkType();">
        <fieldset>
            <legend>添加公告类型</legend>
            <table>
                <tr>
                    <td>公告类型名称</td>
                    <td><input type="text" name="TtypeName"></td>
                </tr>
                <tr>
                    <input type="hidden" name="method" value="addType">
                    <td><input type="submit" value="提交"></td>
                    <td><input type="reset" value="重置"></td>
                </tr>
            </table>

        </fieldset>
    </form>
</body>
</html>
