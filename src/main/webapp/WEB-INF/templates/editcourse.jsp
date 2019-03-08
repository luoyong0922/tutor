
<%@ page language="java" import="java.util.*,com.etc.entity.Courses" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>修改课程</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="css/default.css">
    <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
    <link rel="stylesheet" type="text/css" href="css/student.css" />
</head>
<body>


<div class="infoStu">
    <h2 style="margin-top: 10px;margin-left: 20px;">修改课程</h2>
    <hr style="border: solid 1px #CAC6C6;" />
    <div class="con">
        <div class="con2">
            <form action="${pageContext.request.contextPath}/doupdatecourse" method="POST">
                <input type="hidden" name="courseid" value="${course.courseid}" />
                <table>
                    <tr>
                        <td>日期</td>
                        <td>
                            <input type="date" name="date" id="date" value="${course.date}">
                        </td>
                    </tr>
                    <tr>
                        <td>上课时间</td>
                        <td><input type="time" name="classtime" id="classtime" value="${course.classtime}"></td>
                    </tr>
                    <tr>
                        <td>课程</td>
                        <td><input type="text" name="course" id="course" value="${course.course}"></td>
                    </tr>
                    <tr>
                        <td>老师</td>
                        <td><input type="text" name="teaname" id="teaname" value="${course.teaname}"></td>
                    </tr>
                    <tr>
                        <td>学生</td>
                        <td><input type="text" name="studentname" id="studentname" value="${course.studentname}"></td>
                    </tr>
                    <tr>
                        <td>课时</td>
                        <td><input type="number" name="period" id="period" value="${course.period}"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="保存" />
                            <input type="reset" value="重置" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="img1"><img src="img/registor.png" /></div>
</div>

<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>



</body>
</html>
