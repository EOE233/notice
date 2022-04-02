<%@ page import="com.zhbit.bean.Type" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Yanea
  Date: 2022/4/2
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改公告类型</title>
    <script type="text/javascript" language="javascript">
        function checkType(){
            var tName = form1.tName.value;
            if ((tNamee==null)||(tName=="")){
                alert("请填写公告类型名称！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<%
    Type type = (Type)request.getAttribute("type");
%>
<form method="post" name="form1" action="typeServlet" onsubmit="javascript: return checkType();">
    <table>
        <tr>
            <td>公告类型名称:</td>
            <td><input type="text" name="TtypeName" value="<%=type.gettTypeName()%>"/></td>
        </tr>
            <input type="hidden" name="method" value="doUpdateType" />
            <input type="hidden" name="Tno" value="<%=type.gettNo() %>" />
            <td><input type="submit" value="提交" name="submit" /></td>
            <td><input type="reset" value="重置" name="reset"/></td>
        </tr>
    </table>
</form>
</body>
</html>
