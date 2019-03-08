<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/18
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>家长加入</title>
    <link rel="stylesheet" type="text/css" href="css/default.css">
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
    <link rel="stylesheet" type="text/css" href="css/student.css" />
</head>
<body>
<div class="all">
    <div class="header">
        <img class="logo" src="img/logo1.png" />
        <ul>
            <a href="${pageContext.request.contextPath}/index"><li>首页</li></a>
            <a href="${pageContext.request.contextPath}/teaRegister"><li>老师加入</li></a>
            <a href="${pageContext.request.contextPath}/parentsRegister"><li>用户加入</li></a>
            <a href="${pageContext.request.contextPath}/LOGIN/login"><li>登录</li></a>
            <a href="${pageContext.request.contextPath}/registerChoose"><li>注册</li></a>
            <li class="slider"></li>
        </ul>
    </div>
</div>
<div class="infoStu">
    <h2 style="margin-top: 10px;margin-left: 20px;">家长注册</h2>
    <hr style="border: solid 1px #CAC6C6;" />
    <div class="con">
        <div class="con2">
            <form action="${pageContext.request.contextPath}/doParentsRegister" method="POST">
                <table style="border-collapse:separate; border-spacing:22px;">
                    <tr>
                        <td class="cont">用户名</td>
                        <td><input type="text" name="parentname" id="parentname"></td>
                    </tr>
                    <tr>
                        <td class="cont">密码</td>
                        <td><input type="password" name="password" id="password"></td>
                    </tr>
                    <%--<tr>--%>
                    <%--<td>联系电话</td>--%>
                    <%--<td><input type="text" name="phone" id="phone"></td>--%>
                    <%--</tr>--%>

                    <tr>
                        <td colspan="2">
                            <input type="submit" name="submit" id="submit" value="注册">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="img2"><img src="img/registor.png" /></div>
</div>

<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>
