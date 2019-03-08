<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%--<fmt:formatDate value='${course.date}' pattern='yyyy-MM-dd'/>--%>
<html>
<head>
    <title>课时查询</title>
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <link rel="stylesheet" type="text/css" href="css/other2.css" />
    <link rel="stylesheet" type="text/css" href="css/student2.css" />
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <%--<style>--%>
    <style>
        .reservation {
            border-radius: 30px;
            background-color: rgba(255, 255, 220, 0.9);
            width: 350px;
            padding: 20px 35px 15px 35px;
            border: 1px solid #eaeaea;
            box-shadow: 0 0 25px #cac6c6;
        }

        .title {
            margin: auto auto 20px auto;
            text-align: center;
        }

        .cont {
            text-align: center;
            text-align-last: justify;
        }

        #content {
            margin-left: 11%;
        }

        a {
            text-decoration: none;
        }
    </style>


</head>
<body>
<div id="all">
    <div class="header">
        <img class="logo" src="img/logo.png" />
        <ul>
                <a href="${pageContext.request.contextPath}/LOGIN/teacher"><li>首页</li></a>
                <a href="#"><li >空闲时间</li></a>
            <%--<li>--%>
            <%--<a href="${pageContext.request.contextPath}/getcoursesbypage?teaname=${teaname}">课程安排</a>--%>
            <%--</li>--%>
                <a href="${pageContext.request.contextPath}/getordersbypage?teaname=${teaname}"><li>预约信息</li></a>
                <a href="/jiajiaoProject/logout"><li>退出</li></a>
            <li class="slider"></li>
        </ul>
    </div>
</div>
<hr />
<form action="${pageContext.request.contextPath}/search" method="post" style="margin-left: 38%;margin-top: 4%">
    搜索关键词：<input type="text" name="keywords" />
    <%--<input type="radio"  name="keyword" value="course" />课程--%>
    <%--<input type="radio"  name="keyword" value="studentname"/>学生--%>
    <%--<input type="radio"  name="keyword" value="classtime"/>课程时间--%>
    <input type="submit" value="搜索"/>
    <%--<input type="button" value="添加课程"--%>
    <%--onclick="msgbox(1)"/>--%>
    <input type="button" name="button3" id="button3" class="md-trigger small button" data-modal="modal-13" value="添加课程" />
</form>
<div style="margin-left: 24%;">
    <div class="query1">
        <table width="600px" border="1px" cellspacing="0">
            <tr>
                <th>日期</th>
                <th>上课时间</th>
                <th>课程</th>
                <th>老师</th>
                <th>学生</th>
                <th>课时</th>
                <th>操作</th>
            </tr>
            <c:if test="${fn:length(page.data) == 0}">
                <tr>
                    <td colspan="7">暂无数据</td>
                </tr>
            </c:if>

            <c:if test="${fn:length(page.data) > 0}">
                <c:forEach items="${Page}" var="course" varStatus="vs">
                    <tr align="center">
                            <%--<td>${course.date}</td>--%>
                        <td> ${course.date}</td>
                        <td>${course.classtime}</td>
                        <td>${course.course}</td>
                        <td>${course.teaname}</td>
                        <td>${course.studentname}</td>
                        <td>${course.period}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/editcourse?courseid=${course.courseid}">修改</a>
                            <a href="javascript:deleteCourse('${course.courseid }','${course.course }','${course.teaname}')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        当前是第${page.pageIndex}页,共${page.totalPageCount-1}页，总记录数为${Page.size()}条。
    </div>
    <%--修改路径--%>
    <form action="${pageContext.request.contextPath}/getcoursesbypage" method="post" id="pageForm">
        <input type="hidden" name="pageIndex" id="pageIndex" />
        <button onclick="javascript:findPage(1)">首页</button>
        <c:if test="${page.hasPrevPage }">
            <button onclick="javascript:findPage(${page.pageIndex-1})">上一页</button>
        </c:if>
        <c:forEach begin="1" end="${page.totalPageCount-1}" step="1" var="index">
            <button onclick="javascript:findPage(${index})">${index }</button>
        </c:forEach>
        <c:if test="${page.hasNextPage }">
            <button onclick="javascript:findPage(${page.pageIndex+1})">下一页</button>
        </c:if>
        <button onclick="javascript:findPage(${page.totalPageCount})">尾页</button>
        <input type="text" id="toPage" /> <button onclick="jump(${page.totalPageCount})">跳转</button>
    </form>
</div>

<div class="md-modal1 md-effect-13" id="modal-13">
    <div class="md-content">
        <%--<button class="md-close" data-dismiss="modal" style="float: right;">&times;</button>--%>
        <div class="reservation">
            <div id="content" class="box">
                <h3>请填写相关信息</h3>
                <hr/>
                <form action="${pageContext.request.contextPath}/doaddcourse" method="POST">
                    <table cellpadding="5px">
                        <tr>
                            <td class="cont">日期</td>
                            <td><input type="date" id="date" name="date"  /></td>
                        </tr>
                        <tr>
                            <td class="cont">上课时间</td>
                            <td>
                                <input type="time" name="classtime" id="classtime" >
                            </td>
                        </tr>
                        <tr>
                            <td class="cont">课程</td>
                            <td>
                                <input type="text" name="course" id="course" >
                            </td>
                        </tr>
                        <tr>
                            <td class="cont">老师</td>
                            <td>
                                <input type="text" name="teaname" id="teaname">
                            </td>
                        </tr>
                        <tr>
                            <td class="cont">学生</td>
                            <td><input type="text" id="studentname" name="studentname" /></td>
                        </tr>
                        <tr>
                            <td class="cont">家长</td>
                            <td><input type="text" id="parentname" name="parentname" /></td>
                        </tr>
                        <tr>
                            <td class="cont">课时</td>
                            <td><input type="text" id="period" name="period" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="submit" id="submit1" value="保存课程" class="md-close" data-dismiss="modal" /></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="md-overlay"></div>

<%--<hr>--%>



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

    //删除用户
    function deleteCourse(id,course,teaname){
        if(confirm('确定要删除  ' + course + '  这节课吗?')){
            window.location = '${pageContext.request.contextPath}/deleteCourse?id='+id+'&teaname='+teaname;
        }
    }
    //
    //    function msgbox(n){
    //        document.getElementById('content').style.display=n?'block':'none';     /* 点击按钮打开/关闭 对话框 */
    //    }


</script>
<script src="js/classie.js"></script>
<script src="js/modalEffects.js"></script>

</body>
</html>
