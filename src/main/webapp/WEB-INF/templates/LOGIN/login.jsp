<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/21
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登录页面</title>
    <%--<script type="text/javascript">--%>
        <%--function reImg() {--%>
            <%--var img = document.getElementById("image");--%>
            <%--img.src = "image?code=" + Math.random();--%>
        <%--}--%>
    <%--</script>--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" media="screen">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}//css/other.css"/>
</head>
<body>
<div class="all">
    <div class="header">
        <img class="logo" src="${pageContext.request.contextPath}/img/logo1.png" />
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
<div id="choose" class="login" style="padding-top: 2em">
    <div class="left">
        <div class="left1">
            <form action="${pageContext.request.contextPath}/LOGIN/login_check" method="post" id="form">
                <table id="left1">
                    <tr>
                        <td class="cont">用户名</td>
                        <td><input type="text" name="name" />
                        </td>
                    </tr>
                    <tr>
                        <td class="cont">密码</td>
                        <td><input type="password" name="password" />
                        </td>
                    </tr>
                    <%--<tr>--%>
                    <%--<td>验证码：</td>--%>
                    <%--<td><input type="text" name="yanzhengma" />--%>
                    <%--<img border=0 id="image" src="image">--%>
                    <%--<img border=0 id="image" src="<%=application.getRealPath("/WEB-INF/")%>/LOGIN/image">--%>
                    <%--<a href="#" onclick="reImg();">看不清，请点击刷新</a>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                </table>
                <table id="left2">
                    <tr>
                        <td><input type="radio" name=type value=admin>管理员
                            <input type="radio" name=type value=teacher>教师
                            <input type="radio" name=type value=parents checked>家长
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="登录" />
                            <input type="reset" value="重置" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

    <div class="right">
        <div class="right1">
            <p>没有帐号？
                <a href="${pageContext.request.contextPath}/registerChoose" style="font-size: 20px;">申请注册</a>
            </p>
            <br />
            <h3>优质的师资</h3>
            <p>各项证书的专业认证</p>
            <p>教育专家严格把关的实名推荐</p>
            <p>来自于订课家长的真实评价</p>
            <p>定期淘汰差评教师的过滤机制</p>
            <br />
            <h3>自主约课</h3>
            <p>让约课变成可能</p>
            <p>大班课的费用，精品班的质量</p>
            <p>同学、同步</p>
        </div>
    </div>
</div>
</body>
</html>
