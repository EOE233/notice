<%@ page import="com.zhbit.bean.Type,java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Yanea
  Date: 2022/4/2
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看通知类型</title>
</head>
<body>
<%
    List<Type> list = (List<Type>) request.getAttribute("list");
    if (list != null && list.size() != 0) {
%>
<table>
    <tr>
        <td>通知类型编号</td>
        <td>通知类型名称</td>
        <td colspan="2">操作</td>
    </tr>
    <%
        for (Type type : list) {
    %>
    <tr>
        <td><%=type.gettNo()%>
        </td>
        <td><%=type.gettTypeName()%>
        </td>
        <td><a href="typeServlet?method=doShowDetailForModify&Tno=<%=type.gettNo()%>">修改</a>
        </td>
        <td><a href="typeServlet?method=doDelTypeByID&Tno=<%=type.gettNo()%>">删除</a></td>
    </tr>
    <%
        }
    %>
    <tr>
        <td></td>
        <td><a href="page/system/typeAdd.jsp">添加公告类型</a></td>
        <td></td>

    </tr>

    <%
        } else {
            out.print("没有记录");
        }
    %>
</table>
</body>
</html>
