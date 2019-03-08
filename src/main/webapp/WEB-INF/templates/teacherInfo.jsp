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
    <title>老师详细信息</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/menu.css">
    <link rel="stylesheet" type="text/css" href="css/button.css" />
    <link rel="stylesheet" type="text/css" href="css/teacher2.css" />
    <link rel="stylesheet" type="text/css" href="css/other2.css" />
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <link rel="stylesheet" href="https://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.9&key=cc44772d67a3f332dcbc46449e3852ea&plugin=AMap.Geocoder"></script>
    <script type="text/javascript" src="https://cache.amap.com/lbs/static/addToolbar.js"></script>
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
    <div class="button1" style="width: 540px;">
        <a href="#"><input type="button" name="button1" id="button1" class="small button" onclick=" window.location.href='${pageContext.request.contextPath}/chatroom'" value="与老师联系" /></a>
        <a href="#"><input type="button" name="button3" id="button3" class="md-trigger small button" data-modal="modal-13" value="立即预约" /></a>
        <a href="#"><input type="button" name="button2" id="button2" class="md-trigger small button" data-modal="modal-19" onclick="addMarker()" value="位置" /></a>
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
            <a href="${pageContext.request.contextPath}/payinfo?teachername=${teacher.teaname}" class="cur">支付中心</a>
        </li>
        <li>
            <a href="#item1">个人信息</a>
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
        <%--<li>--%>
            <%--<a href="indexStu.html" style="color: black;letter-spacing: 5px;">退出</a>--%>
        <%--</li>--%>
    </ul>
</div>




<div class="md-modal1 md-effect-13" id="modal-13">
    <div class="md-content">
        <div class="reservation">
            <div class="title">
                <h3>请填写相关信息</h3>
                <hr/>
            </div>
            <div id="content">
                <form action="${pageContext.request.contextPath}/doaddorder?teaname=${teacher.teaname}" method="POST">
                <table cellpadding="5px">
                    <tr>
                        <td class="cont">姓名</td>
                        <td><input type="text" id="studentname" name="studentname" /></td>
                    </tr>
                    <tr>
                        <td class="cont">年级</td>
                        <td>
                            <input type="radio" name="grade" id="Highschool" value="高中" checked="checked">高中
                            <input type="radio" name="grade" id="Middleschool" value="初中">初中
                            <input type="radio" name="grade" id="Primaryschool" value="小学">小学
                        </td>
                    </tr>
                    <tr>
                        <td class="cont">年级</td>
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
                        <td class="cont">性别</td>
                        <td>
                            <input type="radio" name="gender" id="male" value="男" checked="checked">男
                            <input type="radio" name="gender" id="female" value="女">女
                        </td>
                    </tr>
                    <tr>
                        <td class="cont">地址</td>
                        <td><input type="text" id="address" name="address" /><span id="text"></span></td>
                    </tr>
                    <tr>
                        <td class="cont">电话</td>
                        <td><input type="text" id="phone" name="phone" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="submit" id="submit1" value="提交预约" class="md-close" data-dismiss="modal" /></td>
                    </tr>
                </table>
                </form>
            </div>
        </div>
    </div>
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
<div class="md-modal md-effect-19" id="modal-19">
    <div class="md-content">
        <div id="container" style="width:400px;height:400px;"></div>
        <div id="tip"></div>
    </div>
</div>

<div class="md-overlay"></div>

<script src="js/classie.js"></script>
<script src="js/modalEffects.js"></script>
<script>
    //画表格函数的回调函数
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





    //加载地图，调用浏览器定位服务
    var map = new AMap.Map('container', {
        resizeEnable: true, //是否监控地图容器尺寸变化
        zoom:13, //初始化地图层级
        center: [118.140089,24.494536] //初始化地图中心点
    });

    $("#address").blur( function() {
        var lng = "0";
        var geocoder = new AMap.Geocoder({
            city: "0592",   //城市，默认：“全国”
            radius: 1000 //范围，默认：500
        });
        //地理编码,返回地理编码结果
        var address = $("#address").val();
        geocoder.getLocation(address, function(status, result) {
            if (status === 'complete' && result.info === 'OK') {
                geocoder_CallBack(result);
            }
        });
    });

    function addMarker() {
        var marker = new AMap.Marker({
            map: map,
            position: [${teacher.lon},${teacher.lat}]
        });
    }

    function geocoder_CallBack(data) {
        var resultStr = "";
        //地理编码结果数组
        var geocode = data.geocodes;
        for (var i = 0; i < geocode.length; i++) {
//            addMarker(i, geocode[i]);
            var lng = geocode[i].location.getLng();
            var lat =  geocode[i].location.getLat();

        }
        var url = '${pageContext.request.contextPath}/ajaxaddress';
        $.ajax({
            type:'post',
            url:url,
            data:{'userlng':lng,'userlat':lat},
            dataType:'json', //指定返回对象
            success:function(data){
                console.log(data);
                $("#text").html("");
                $("#text").append(data.message);
            },
            error:function(){}
        });
    }


</script>
</body>

</html>