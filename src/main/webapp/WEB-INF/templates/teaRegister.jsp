
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>老师加入</title>
    <link rel="stylesheet" type="text/css" href="css/default.css">
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
    <link rel="stylesheet" type="text/css" href="css/teacher.css" />
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

<div class="infoTea">
    <p style="margin-top: 10px;margin-left: 20px;">老师注册</p>
    <hr style="border: solid 1px #CAC6C6;" />
    <div class="infoTea1">
        <div class="title">
            <h3>个人信息</h3>
            <hr />
        </div>
        <form action="/jiajiaoProject/doTeaRegister" method="POST">
            <div class="con">
                <table style="border-collapse:separate; border-spacing:7px;">
                    <tr>
                        <td class="cont">用户名</td>
                        <td><input type="text" id="teaname" name="teaname" /></td>
                    </tr>
                    <tr>
                        <td class="cont">密码</td>
                        <td><input type="password" id="password" name="password" /></td>
                    </tr>
                    <tr>
                        <td class="cont">性别</td>
                        <td>
                            <input type="radio" name="gender" id="male" value="男" checked="checked">男
                            <input type="radio" name="gender" id="female" value="女">女
                        </td>
                    </tr>
                    <tr>
                        <td class="cont">电话</td>
                        <td><input type="text" id="phone" name="phone" /></td>
                    </tr>
                    <tr>
                        <td class="cont">地址</td>
                        <td><input type="text" id="address" name="address" /></td>
                    </tr>
                    <tr>
                        <td class="cont">就读学校</td>
                        <td><input type="text" id="school" name="school" /></td>
                    </tr>
                    <tr>
                        <td class="cont">高考分数</td>
                        <td><input type="text" id="score" name="score" /></td>
                    </tr>
                    <tr>
                        <td class="cont">个人描述</td>
                        <td><textarea rows="5" cols="22" style="resize: none;"></textarea></td>
                    </tr>
                </table>
            </div>
    </div>
    <div class="infoTea2">
        <div class="title">
            <h3>家教信息</h3>
            <hr />
        </div>
        <div class="con">
            <table style="border-collapse:separate; border-spacing:13px;">
                <tr>
                    <td class="cont">年级</td>
                    <td>
                        <input type="radio" name="grade" id="Primaryschool" value="小学" checked="checked">小学
                        <input type="radio" name="grade" id="Middleschool" value="初中">初中
                        <input type="radio" name="grade" id="Highschool" value="高中">高中
                    </td>
                </tr>
                <tr>
                    <td class="cont">科目</td>
                    <td>
                        <input type="radio" name="course" id="Chinese" value="语文" checked="checked">语文
                        <input type="radio" name="course" id="Math" value="数学">数学
                        <input type="radio" name="course" id="English" value="英语">英语<br />
                        <input type="radio" name="course" id="Physics" value="物理">物理
                        <input type="radio" name="course" id="Chemistry" value="化学">化学
                        <input type="radio" name="course" id="Biology" value="生物">生物
                    </td>
                </tr>
                <tr>
                    <td class="cont">家教经历</td>
                    <td><textarea rows="5" cols="22" style="resize: none;"></textarea></td>
                </tr>
                <tr>
                <td class="cont">价格</td>
                <td><input type="number" id="price" name="price" /></td>
                </tr>
            </table>
        </div>
    </div>
    <input type="submit" name="submit" id="submit" value="提交" />
    </form>
</div>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</body>

</html>