<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    //由于password是跳转的依据，因此借助session中是否有password信息来判断用户是否有登录，
    if (session.getValue("password") == null)
        out.print("<script>alert('请管理员先登录！');window.location.href='LOGIN/login'</script>");
%>
<html>
<head>
    <title>管理员index</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/matrix-style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/matrix-media.css" />
    <link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css"/>
</head>
<body>
<!--Header-part-->
<div id="header">
    <h1><a href="dashboard.html">MatAdmin</a></h1>
</div>
<!--close-Header-part-->

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav">
        <li >
            <a><i class="icon icon-user"></i> <span class="text">欢迎Admin</span></a>
        </li>
        <li>
            <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 首页</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/logout" title="Exit" class="tip-bottom"><i class="icon icon-share-alt"></i> 退出</a>
        </li>
    </ul>
</div>
<div id="sidebar">
    <ul>
        <li class="active">
            <a href="${pageContext.request.contextPath}/getStudentbypage"><i class="icon icon-th"></i> <span>学生信息</span> </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/getTeacherbypage"><i class="icon icon-th"></i> <span>教师信息</span></a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/getStudentinfostatistics"><i class="icon icon-th"></i> <span>学生信息统计</span> </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/getCourseCount"><i class="icon icon-th"></i> <span>学科人数统计</span> </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/getTeacherinfobypage"><i class="icon icon-th"></i> <span>教师信息统计</span> </a>
        </li>

    </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
    <div id="query">
        <div id="query1">
            <%--<div class="query4">--%>
            <%--<input type="text" name="inp" id="inp" value="" />--%>
            <%--<input type="button" name="sear" id="sear" value="搜索" />--%>
            <%--</div>--%>
            <form action="${pageContext.request.contextPath}/getStudentbypage" method="post">
                搜索关键词：
                <input type="text" name="keywords" />
                <input type="submit" value="搜索"/><br/>
            </form>
            <%--<div class="query2">--%>
            <%--<!--起始日期：<input type="date" min="2018-01-01" max="2020-12-31" id="today1" /> 终止日期：--%>
            <%--<input type="date" min="2018-01-01" max="2020-12-31" id="today2" />-->--%>
            <%--课程内容：<input type="text" name="co" id="co" style="width: 120px;height: 18px;" />--%>
            <%--<input type="button" name="add1" id="add1" value="添加课程" />--%>
            <%--</div>--%>
            <div class="query3">
                <table class="worktime" border="1" cellspacing="0">
                    <tr>
                        <td>学生姓名</td>
                        <td>性别</td>
                        <td>联系方式</td>
                        <td>科目</td>
                        <td>年级</td>
                        <td>地址</td>
                    </tr>
                    <c:if test="${fn:length(page.list) == 0}">
                        <tr>
                            <td colspan="6">暂无数据</td>
                        </tr>
                    </c:if>

                    <c:if test="${fn:length(page.list) > 0}">
                        <c:forEach items="${page.list}" var="student" varStatus="vs">
                            <tr align="center">
                                <td>${student.studentname}</td>
                                <td>${student.gender}</td>
                                <td>${student.phone}</td>
                                <td>${student.course}</td>
                                <td>${student.grade}</td>
                                <td>${student.address}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
            </div>
            当前是第${page.pageNum}页,共${page.pages}页，总记录数为${page.total}条。
            <%--修改路径--%>
            <div style="text-align: center">
                <form action="${pageContext.request.contextPath}/getStudentbypage" method="post" id="pageForm" >
                    <input type="hidden" name="pageIndex" id="pageIndex" />
                    <button onclick="javascript:findPage(1)">首页</button>
                    <c:if test="${page.hasPreviousPage }">
                        <button onclick="javascript:findPage(${page.pageNum-1})">上一页</button>
                    </c:if>
                    <c:forEach begin="1" end="${page.pages }" step="1" var="index">
                        <button onclick="javascript:findPage(${index})">${index }</button>
                    </c:forEach>
                    <c:if test="${page.hasNextPage }">
                        <button onclick="javascript:findPage(${page.pageNum+1})">下一页</button>
                    </c:if>
                    <button onclick="javascript:findPage(${page.pages})">尾页</button>
                    <input type="text" id="toPage" /> <button onclick="jump(${page.pages})">跳转</button>
                </form>
            </div>
        </div>

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
