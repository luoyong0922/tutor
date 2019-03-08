<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/18
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*,com.etc.entity.Teacher" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>老师个人中心</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/menu.css">
    <link rel="stylesheet" type="text/css" href="css/button.css" />
    <link rel="stylesheet" type="text/css" href="css/teacher2.css" />
    <link rel="stylesheet" type="text/css" href="css/other2.css" />
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>
</head>

<body style="background-image: linear-gradient(to top, #FFF8DC 0%, #d1fdff 100%);">
<input type="hidden" id="freetime" value="${teacher.freetime}">
<div id="information">
    <div class="information1"><img src="${pageContext.request.contextPath}/getUserImg?teaid=${teacher.teaid}" class="tou" /></div>
    <div class="information2">
        <table style="text-align: center">
            <tr>
                <td>
                    <h2 id="item1">${teacher.teaname} 工作ID:${teacher.teaid}</h2>
                </td>
                <%--<td>${teacher.teaname}</td>--%>
            </tr>
            <tr>
                <td>授课科目：${teachers.course}</td>
            </tr>
            <tr>
                <td>授课年级：${teachers.grade}</td>
            </tr>
            <tr>
                <td>高考成绩：${teacher.score}</td>
            </tr>
        </table>
    </div>
    <div class="button1" style="width: 130px;">
        <a href="${pageContext.request.contextPath}/editinfo?teaname=${teacher.teaname}">
            <input type="button" name="button3" id="button3" class="small button" value="修改信息" />
        </a>
    </div>
    <div class="information3" style="margin-top: 3%;">
        <div class="information4">
            <h4 id="item2">就读高校</h4>
        </div>
        <p>${teacher.school}</p>
    </div>
    <div class="information3">
        <div class="information4">
            <h4 id="item3">家教经历</h4>
        </div>
        <p>${teacher.experience}</p>
    </div>
    <div class="information3">
        <div class="information4">
            <h4 id="item4">个人经历</h4>
        </div>
        <p>${teacher.description}</p>
    </div>
    <div class="information5">
        <div class="information4">
            <h4 id="item5">空闲时间</h4>
        </div>
        <table id="tablenum">
            <tr>
                <td></td>
                <td>周一</td>
                <td>周二</td>
                <td>周三</td>
                <td>周四</td>
                <td>周五</td>
                <td>周六</td>
                <td>周日</td>
            </tr>
        </table>
    </div>
</div>

<div id="menu">
    <ul>
        <li>
            <a href="#item1" class="cur">个人信息</a>
        </li>
        <li>
            <a href="#item2">个人描述</a>
        </li>
        <li>
            <a href="#item3">家教经历</a>
        </li>
        <li>
            <a href="#item4">个人经历</a>
        </li>
        <li>
            <a href="#item5">空闲时间</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/LOGIN/teacher">返回首页</a>
        </li>
        <%--<li>--%>
        <%--<a href="indexStu.html" style="color: black;letter-spacing: 5px;">退出</a>--%>
        <%--</li>--%>
    </ul>
</div>
<div class="md-modal md-effect-14" id="modal-14">
    <div class="md-content">
        <div id="chat">
            <div class="chat1">
                <button class="md-close" data-dismiss="modal" style="float: right;">&times;</button>
                <h3>name</h3>
            </div>
            <div class="chat">
                <div class="chat2"><textarea rows="3" cols="60" style="resize: none;"></textarea></div>
                <div class="chat3"><input type="button" name="send" id="send" value="发送" /></div>
            </div>
        </div>
    </div>
</div>
<div class="md-overlay"></div>
<!-- the overlay element -->

<script src="js/classie.js"></script>
<script src="js/modalEffects.js"></script>
<script>
    $(function(){

        init(3,7);
        freetimefuntion(8);
    });
    var freetimefuntion = function (i) {
        var freetime = $("#freetime").val();
        var freetimes = freetime.split(",");
        console.log(freetimes);
        for(var x=0;x<=freetimes.length+1;x++ ){
            var free = freetimes.pop();
            console.log("-----------"+free);
            $("#"+free).css("background-image","url(${pageContext.request.contextPath}/img/freetime.png)");
        }
    }

    //画出表格并设置每个表格的值
    var k =1;//答题信息中表格的值
    var init = function(r,c) {
        var template = "";
        for(var i = 0; i < r; i++) {
            template += "<tr>";
            for(var j = 0; j < c+1; j++) {
                if (j==0){
                    if (i==0){template +="<td >上午</td>";}
                    if (i==1){template +="<td >下午</td>";}
                    if (i==2){template +="<td >晚上</td>";}
                }else{
                    template += "<td id=\""+k+"\">"+k+"</td>";
                    k++;
                }

            }
            template += "</tr>";
        }
        $("#tablenum").append(template);
    };
</script>
</body>

</html>
