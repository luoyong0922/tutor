<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/28
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>修改教师个人信息</title>--%>
    <%--<script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action="${pageContext.request.contextPath}/doeditinfo?teaname=${teacherInfo.teaname}" method="POST" enctype="multipart/form-data">--%>
    <%--<input type="hidden" name="teaid" value="${teacherInfo.teaid}" />--%>
    <%--<input type="hidden" value="${teacherInfo.school}">--%>
    <%--<input type="hidden" id="freetime" name="freetime"  />--%>
    <%--<table cellpadding="5px">--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<h2 id="item1">${teacherInfo.teaname} 工作ID:${teacherInfo.teaid}</h2>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td><img width="100" alt="" src="${pageContext.request.contextPath}/getUserImg?teaid=${teacherInfo.teaid}"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td class="cont">上传头像</td>--%>
            <%--<td><input id="image" type="file" name="image"/></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>高考成绩：</td>--%>
            <%--<td><input type="text" name="score" id="score" value="${teacherInfo.score}"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td class="cont">授课年级</td>--%>
            <%--<td>--%>
                <%--<input type="radio" name="grade" id="Highschool" value="高中" checked="checked">高中--%>
                <%--<input type="radio" name="grade" id="Middleschool" value="初中">初中--%>
                <%--<input type="radio" name="grade" id="Primaryschool" value="小学">小学--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td class="cont">授课课程</td>--%>
            <%--<td>--%>
                <%--<input type="radio" name="course" id="Math" value="数学" checked="checked">数学--%>
                <%--<input type="radio" name="course" id="Chinese" value="语文">语文--%>
                <%--<input type="radio" name="course" id="English" value="英语">英语<br />--%>
                <%--<input type="radio" name="course" id="Physics" value="物理">物理--%>
                <%--<input type="radio" name="course" id="Chemistry" value="化学">化学--%>
                <%--<input type="radio" name="course" id="Biology" value="生物">生物--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td class="cont">联系方式</td>--%>
            <%--<td><input type="text" name="phone" id="phone" value="${teacherInfo.phone}"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td class="cont">就读高校</td>--%>
            <%--<td><input type="text" name="school" value="${teacherInfo.school}"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td class="cont">家教经历</td>--%>
            <%--<td><textarea name="experience">${teacherInfo.experience}</textarea></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td class="cont">个人经历</td>--%>
            <%--<td><textarea name="description">${teacherInfo.description}</textarea></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td class="cont">空闲时间</td>--%>
            <%--<td>--%>
                <%--<table id="tablenum">--%>
                <%--<tr>--%>
                    <%--<td></td>--%>
                    <%--<td>周一</td>--%>
                    <%--<td>周二</td>--%>
                    <%--<td>周三</td>--%>
                    <%--<td>周四</td>--%>
                    <%--<td>周五</td>--%>
                    <%--<td>周六</td>--%>
                    <%--<td>周日</td>--%>
                <%--</tr>--%>
                <%--</table>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td><input type="submit" name="submit" id="submit1" value="提交信息" class="md-close" data-dismiss="modal" /></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</form>--%>
<%--<script>--%>
    <%--//画表格函数的回调函数--%>
    <%--$(function(){--%>
        <%--init(3,7);--%>
    <%--});--%>
    <%--window.onload = function(){--%>
        <%--var grade = '${courseinfo.grade}';--%>
        <%--if(grade === '高中'){--%>
            <%--document.getElementById('Highschool').checked = true;--%>
        <%--}else if(grade === '初中'){--%>
            <%--document.getElementById('Middleschool').checked = true;--%>
        <%--}else{--%>
            <%--document.getElementById('Primaryschool').checked = true;--%>
        <%--}--%>

        <%--var course = '${courseinfo.course}';--%>
        <%--if(course === '数学'){--%>
            <%--document.getElementById('Math').checked = true;--%>
        <%--}else if(course === '语文'){--%>
            <%--document.getElementById('Chinese').checked = true;--%>
        <%--}else if(course === '英语'){--%>
            <%--document.getElementById('English').checked = true;--%>
        <%--}else if(course === '物理'){--%>
            <%--document.getElementById('Physics').checked = true;--%>
        <%--}else if(course === '化学'){--%>
            <%--document.getElementById('Chemistry').checked = true;--%>
        <%--}else{--%>
            <%--document.getElementById('Biology').checked = true;--%>
        <%--}--%>

    <%--}--%>

    <%--//画出表格并设置每个表格的值--%>
    <%--var k =1;//答题信息中表格的值--%>
    <%--var init = function(r,c) {--%>
        <%--var template = "";--%>
        <%--for(var i = 0; i < r; i++) {--%>
            <%--template += "<tr>";--%>
            <%--for(var j = 0; j < c; j++) {--%>
                <%--template += "<td id=\" "+ k + " \">"+k+"</td>";--%>
                <%--k++;--%>
            <%--}--%>
            <%--template += "</tr>";--%>
        <%--}--%>
        <%--$("#tablenum").append(template);--%>

        <%--var ss=0;--%>
        <%--var ids=[];--%>
        <%--$("#tablenum td").click(function(){--%>
            <%--var id=$(this).text();--%>
            <%--var color=$(this).css("background-image");--%>
            <%--console.log(color);--%>
            <%--if(color=="none"){--%>
                <%--$(this).css("background-image","url(${pageContext.request.contextPath}/img/Chinese.png)");--%>
                <%--ids.push(id);--%>
            <%--}else{--%>
                <%--$(this).css("background-image","");--%>
                <%--ids.push(id);--%>
            <%--}--%>
            <%--$("#freetime").val(ids);--%>
            <%--console.log(color);--%>
            <%--console.log(id);--%>
            <%--console.log(ids);--%>
        <%--});--%>


    <%--};--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>


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
<div id="information">
    <div class="information1"><img src="${pageContext.request.contextPath}/getUserImg?teaid=${teacherInfo.teaid}" class="tou" /></div>
    <form action="${pageContext.request.contextPath}/doeditinfo?teaname=${teacherInfo.teaname}" method="POST" enctype="multipart/form-data">
    <input type="hidden" name="teaid" value="${teacherInfo.teaid}" />
    <input type="hidden" value="${teacherInfo.school}">
    <input type="hidden" id="freetime" name="freetime"  />
    <table cellpadding="5px">
    <tr>
    <td>
    <h2 id="item1">${teacherInfo.teaname} 工作ID:${teacherInfo.teaid}</h2>
    </td>
    </tr>
    <tr>
    <td >上传头像</td>
    <td><input id="image" type="file" name="image"/></td>
    </tr>
    <tr>
    <td>高考成绩：</td>
    <td><input type="text" name="score" id="score" value="${teacherInfo.score}"></td>
    </tr>
    <tr>
    <td >授课年级</td>
    <td>
    <input type="radio" name="grade" id="Highschool" value="高中" checked="checked">高中
    <input type="radio" name="grade" id="Middleschool" value="初中">初中
    <input type="radio" name="grade" id="Primaryschool" value="小学">小学
    </td>
    </tr>
    <tr>
    <td >授课课程</td>
    <td>
    <input type="radio" name="course" id="Math" value="数学" checked="checked">数学
    <input type="radio" name="course" id="Chinese" value="语文">语文
    <input type="radio" name="course" id="English" value="英语">英语<br />
    <input type="radio" name="course" id="Physics" value="物理">物理
    <input type="radio" name="course" id="Chemistry" value="化学">化学
    <input type="radio" name="course" id="Biology" value="生物">生物
    </td>
    </tr>
    <tr>
    <td >联系方式</td>
    <td><input type="text" name="phone" id="phone" value="${teacherInfo.phone}"></td>
    </tr>
    <tr>
    <td >就读高校</td>
    <td><input type="text" name="school" value="${teacherInfo.school}"></td>
    </tr>
    <tr>
    <td >家教经历</td>
    <td><textarea name="experience">${teacherInfo.experience}</textarea></td>
    </tr>
    <tr>
    <td >个人经历</td>
    <td><textarea name="description">${teacherInfo.description}</textarea></td>
    </tr>
    <tr>
    <td >空闲时间</td>
    <td>
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
    </td>
    </tr>
    <tr>
    <td><input type="submit" name="submit" id="submit1" value="提交信息" class="md-close" data-dismiss="modal" /></td>
    </tr>
    </table>
    </form>


</div>

<div id="menu">
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/editPersonalInfo?teaname=${teacherInfo.teaname}">个人中心</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/getcoursesbypage?teaname=${teacherInfo.teaname}">课程安排</a>
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
    //画表格函数的回调函数
    $(function(){
        init(3,7);
    });
    window.onload = function(){
        var grade = '${courseinfo.grade}';
        if(grade === '高中'){
            document.getElementById('Highschool').checked = true;
        }else if(grade === '初中'){
            document.getElementById('Middleschool').checked = true;
        }else{
            document.getElementById('Primaryschool').checked = true;
        }

        var course = '${courseinfo.course}';
        if(course === '数学'){
            document.getElementById('Math').checked = true;
        }else if(course === '语文'){
            document.getElementById('Chinese').checked = true;
        }else if(course === '英语'){
            document.getElementById('English').checked = true;
        }else if(course === '物理'){
            document.getElementById('Physics').checked = true;
        }else if(course === '化学'){
            document.getElementById('Chemistry').checked = true;
        }else{
            document.getElementById('Biology').checked = true;
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

        var ss=0;
        var ids=[];
        $("#tablenum td").click(function(){
            var id=$(this).text();
            var color=$(this).css("background-image");
            console.log(color);
            if(color=="none"){
                $(this).css("background-image","url(${pageContext.request.contextPath}/img/freetime.png)");
                ids.push(id);
            }else{
                $(this).css("background-image","");
                ids.push(id);
            }
            $("#freetime").val(ids);
            console.log(color);
            console.log(id);
            console.log(ids);
        });


    };
</script>

</body>

</html>