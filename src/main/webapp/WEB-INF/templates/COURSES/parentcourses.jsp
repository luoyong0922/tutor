<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/2
  Time: 17:30
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/20
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${courses}</title>
    <style>
        body{width: 850px;margin: auto;}
        .all {
            /*border: solid 1px;*/
            height: 60px;
            width: 75%;
            border-radius: 15px 15px 0 0;
            margin-left: 15%;
            margin-top: 2.4%;
            background-color: rgba(250, 255, 255, 1);
        }
        .header ul {
            /*border: solid 1px;*/
            font-size: 0;
            position: relative;
            margin: 0px;
            padding: 0px;
            /*margin-left: 15.5%;*/
            margin-left: 25%;
        }
        ul li {
            display: inline-block;
            width: 120px;
            font-size: 16px;
            text-align: center;
            line-height: 60px;
            position: relative;
            overflow: hidden;
            cursor: pointer;
        }
        .course ul {
            /*border: solid 1px;*/
            font-size: 0;
            position: relative;
            margin: 0px;
            padding: 0px;
            margin-left: 7%;
        }
        .course ul li {
            display: inline-block;
            width: 70px;
            font-size: 16px;
            text-align: center;
            line-height: 40px;
            position: relative;
            overflow: hidden;
            cursor: pointer;
        }

        .header ul li a {
            color: black;
        }
        .logo {
            height: 60px;
            float: left;
            /*margin-left: 2.5%;*/
            margin-left: 2.7%;
        }
        .slider {
            display: block;
            position: absolute;
            bottom: 0;
            left: 0;
            height: 3px;
            background: cyan;
            -webkit-transition: all 0.5s;
            transition: all 0.5s;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="all">
    <div class="header">
        <img class="logo" src="../img/logo.png" />
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/LOGIN/parents">首页</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/getStuCoursesbypage?parentname=${parentname}">我的课程</a>
            </li>
            <li>
                <a href="/jiajiaoProject/logout">退出</a>
            </li>
            <li class="slider"></li>
        </ul>
    </div>
</div>
<hr/>
<div class="course">
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/COURSES/courses?course=数学">数学</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/COURSES/courses?course=语文">语文</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/COURSES/courses?course=英语">英语</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/COURSES/courses?course=物理">物理</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/COURSES/courses?course=化学">化学</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/COURSES/courses?course=生物">生物</a>
        </li>
    </ul>
</div>
<hr/>

<div id="span"></div>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.js"></script>
<script type="text/javascript">
    $(function(){
        var url = '/jiajiaoProject/teachershow3?course=${courses}';
        $.ajax({
            type:'post',
            url:url,
            dataType:'json', //指定返回对象
            success:
                function(data){ //接受会的数据
                    for(var i=0;i<data.length;i++){
                        $("#span").append(
                            "<form action  id='form"+i+"' method='POST'>"
                            +"<table style='float: left;margin-left:35px ;'>"
                            +"<tr>"
                            +"<td colspan='3'><img src id='img"+i+"' style='width: 200px;height: 160px;border-radius: 35px;'/>"
                            +"</td>"+"</tr>"+"<tr>"
                            +"<td>教师姓名：<input type='text' id='teaname"+i+"' name='teaname' id='teaname' readonly='readonly' style='width: 85px;'/></td>"
                            +"</tr>"+"<tr>"
                            +"<td>授课科目：<input type='text' id='course"+i+"' name='course' id='course' readonly='readonly' style='width: 65px;'/></td>"
                            +"</tr>"+"<tr>"
                            +"<td>授课年级：<input type='text' id='grade"+i+"' name='grade' id='grade' readonly='readonly' style='width: 65px;'/></td>"
                            +"</tr>"+"<tr>"
                            +"<td colspan='3'><input type='submit' value='查看详情'></td>"
                            +"</tr>"+"</table>"
                            +"</form>");
                    }
                    for(var i=0;i<data.length;i++){
                        var object = data[i];
                        $("#teaname"+i).val(object.teaname);
                        $("#course"+i).val(object.course);
                        $("#grade"+i).val(object.grade);
                        $("#img"+i).attr('src','${pageContext.request.contextPath}/getUserImg2?teaname='+object.teaname);
                        $("#form"+i).attr('action',"/jiajiaoProject/teaPersonal");
                    }

                },
            error:function(){
                alert('发生错误了');
            }
        });


    });
</script>
</body>
</html>

