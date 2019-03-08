<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/27
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册选择</title>
    <link rel="stylesheet" type="text/css" href="css/default.css">
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
    <link rel="stylesheet" type="text/css" href="css/other.css" />
</head>
<body>
<div class="all">
    <div class="header">
        <img class="logo" src="img/logo1.png" />
        <ul>
            <a href="${pageContext.request.contextPath}/index"><li>首页</li></a>
            <a href="${pageContext.request.contextPath}/teaRegister"><li>老师加入</li></a>
            <a href="${pageContext.request.contextPath}/parentsRegister"><li>家长加入</li></a>
            <a href="${pageContext.request.contextPath}/LOGIN/login"><li>登录</li></a>
            <a href="${pageContext.request.contextPath}/registerChoose"><li>注册</li></a>
            <li class="slider"></li>
        </ul>
    </div>
</div>

<div class="login">
    <h2 style="margin-top: 10px;margin-left: 20px;">现在加入大学生家教</h2>
    <hr style="border: solid 1px #CAC6C6;" />
    <div class="left2">
        <div class="left3" style="line-height: 45px;">
            <h2>我是家长</h2>
            <p>我想为孩子找辅导老师</p>
            <a href="${pageContext.request.contextPath}/parentsRegister"><input type="button" name="join" id="join" value="现在加入" /></a>
        </div>
    </div>
    <div class="right2">
        <div class="right3" style="line-height: 45px;">
            <h2>我是老师</h2>
            <p>我想帮助学生提高学习成绩</p>
            <a href="${pageContext.request.contextPath}/teaRegister"><input type="button" name="join1" id="join1" value="现在加入" /></a>
        </div>
    </div>
</div>

<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>
