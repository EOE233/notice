<%-- Created by IntelliJ IDEA. User: Yanea Date: 2022/4/2 Time: 23:18 To change this template use File | Settings | File
	Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>通过时间区间查询通知</title>
	<script type="text/javascript" language="javascript">
		function checkNotice() {
			var sTime = form1.startTime.value;
			if ((sTime == null) || (sTime == "")) {
				alert("请填写开始时间！");
				return false;
			}
			return true;
			var eTime = form1.endTime.value;
			if ((eTime == null) || (eTime == "")) {
				alert("请填写结束时间！");
				return false;
			}
			return true;
		}
	</script>
</head>

<body>
<form action="http://localhost:8080/notice/noticeServlet" name="form1" onsubmit="javascript: return checkNotice();" method="post">
    <fieldset>
        <legend>通过时间区间查询</legend>
        <table>
            <tr>
                <td>开始时间</td>
                <td>结束时间</td>
            </tr>
            <tr>
                <td><input type="date" name="startTime"></td>
                <td><input type="date" name="endTime"></td>
            </tr>
	        <tr>
		        <input type="hidden" name="method" value="getNoticeByTime">
		        <td><input type="submit" value="查询"></td>
		        <td></td>
	        </tr>
        </table>
    </fieldset>
</form>
</body>

</html>