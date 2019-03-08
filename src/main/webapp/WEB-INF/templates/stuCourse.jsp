<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/26
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的课程</title>
    <link rel="stylesheet" type="text/css" href="css/student2.css" />
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <style>
        a {text-decoration: none; }
    </style>
</head>
<body>
<div id="all">
    <div class="headerStu">
        <img class="logo" src="img/logo.png" />
        <ul>
                <a href="${pageContext.request.contextPath}/LOGIN/parents"><li>首页</li></a>
                <a href="${pageContext.request.contextPath}/getStuCoursesbypage?studentname=${parentname}"><li >我的课程</li></a>
                <a href="/jiajiaoProject/logout"><li>退出</li></a>
            <li class="slider"></li>
        </ul>
    </div>
</div>
<%--<form action="${pageContext.request.contextPath}/searchStuCourse" method="post">--%>
<%--搜索关键词：--%>
<%--<input type="text" name="keywords" />--%>
<%--<input type="submit" value="搜索"/><br/>--%>
<%--</form>--%>
<hr />
<div id="query1">
    <div class="query1">
        <table width="600px" border="1px" cellspacing="0" class="worktime" cellspacing="0">
            <tr>
                <th>日期</th>
                <th>上课时间</th>
                <th>课程</th>
                <th>老师</th>
                <th>学生</th>
                <th>课时</th>
            </tr>
            <c:if test="${fn:length(page.data) == 0}">
                <tr>
                    <td colspan="5">暂无数据</td>
                </tr>
            </c:if>

            <c:if test="${fn:length(page.data) > 0}">
                <c:forEach items="${Page}" var="course" varStatus="vs">
                    <tr align="center">
                        <td>${course.date}</td>
                        <td>${course.classtime}</td>
                        <td>${course.course}</td>
                        <td>${course.teaname}</td>
                        <td>${course.studentname}</td>
                        <td>${course.period}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        当前是第${page.pageIndex}页,共${page.totalPageCount}页，总记录数为${Page.size()}条。
    </div>
    <%--修改路径--%>
    <div style="margin: auto">
        <form action="${pageContext.request.contextPath}/getStuCoursesbypage" method="post" id="pageForm" >
            <input type="hidden" name="pageIndex" id="pageIndex" />
            <button onclick="javascript:findPage(1)">首页</button>
            <c:if test="${page.hasPrevPage }">
                <button onclick="javascript:findPage(${page.pageIndex-1})">上一页</button>
            </c:if>
            <c:forEach begin="1" end="${page.totalPageCount }" step="1" var="index">
                <button onclick="javascript:findPage(${index})">${index }</button>
            </c:forEach>
            <c:if test="${page.hasNextPage }">
                <button onclick="javascript:findPage(${page.pageIndex+1})">下一页</button>
            </c:if>
            <button onclick="javascript:findPage(${page.totalPageCount})">尾页</button>
            <input type="text" id="toPage" /> <button onclick="jump(${page.totalPageCount})">跳转</button>
        </form>
    </div>
</div>
<%--<hr>--%>


<script src="http://libs.baidu.com/jquery/1.11.1/jquery.js"></script>
<script>
    $(function() {
        $('tr:even').css('background', '#FFFAF0');
        $('tr:odd').css('background', '#FDF5E6');
    })
</script>
<script>
    function findPage(pageIndex){
        var form = document.getElementById('pageForm');
        var page = document.getElementById('pageIndex') ;
        page.value = pageIndex;
        form.submit();
    }

    function jump(totalPageCount){
        var pageIndex = document.getElementById('toPage').value;
        if(pageIndex < 1){
            findPage(1);
        }else if(pageIndex > totalPageCount){
            findPage(totalPageCount);
        }else{
            findPage(pageIndex);
        }
    }
</script>
</body>
</html>
