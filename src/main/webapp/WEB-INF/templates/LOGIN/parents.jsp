
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*,com.etc.entity.Parents" pageEncoding="UTF-8"%>
<%
    //由于password是跳转的依据，因此借助session中是否有password信息来判断用户是否有登录，
    if (session.getValue("password") == null)
        out.print("<script>alert('请家长先登录！');window.location.href='login'</script>");
%>

<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>我的首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" media="screen">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nivo-slider.css" media="screen">
    <style>

    </style>
</head>

<body style="background-image: linear-gradient(to top, #FFEBCD 0%, #d1fdff 100%);">
<div id="all">
    <div class="headerStu">
        <img class="logo" src="../img/logo.png" />
        <ul>
                <a href="${pageContext.request.contextPath}/LOGIN/parents"><li>首页</li></a>
                <a href="${pageContext.request.contextPath}/getStuCoursesbypage?parentname=${parentname}"><li>我的课程</li></a>
                <a href="/jiajiaoProject/logout"><li>退出</li></a>
            <li class="slider"></li>
        </ul>
    </div>
</div>

<div id="slider-container">
    <div id="slider" class="nivoSlider">
        <img title="#htmlcaption1" alt="" src="../img/timg6.jpg">
        <img title="#htmlcaption2" alt="" src="../img/timg8.jpg">
        <img title="#htmlcaption3" alt="" src="../img/timg3.jpg">
        <img title="#htmlcaption4" alt="" src="../img/timg7.jpg">
    </div>
    <!-- #slider -->
    <div id="htmlcaption1" class="nivo-html-caption">
        <span class="sdate">December 01, 2011</span>
        <h1>干阳老师现场教学</h1>
        <hr>
        <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In sapien lorem, placerat ac imperdiet a,
            volutpat et risus. </p>
    </div>
    <div id="htmlcaption2" class="nivo-html-caption">
        <span class="sdate">December 05, 2011</span>
        <h1>We can help to solve your company problem...</h1>
        <hr>
        <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In sapien lorem, placerat ac imperdiet a,
            volutpat et risus. </p>
    </div>
    <div id="htmlcaption3" class="nivo-html-caption">
        <span class="sdate">December 07, 2011</span>
        <h1>We always smile to help you...</h1>
        <hr>
        <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In sapien lorem, placerat ac imperdiet a,
            volutpat et risus. </p>
    </div>
    <div id="htmlcaption4" class="nivo-html-caption">
        <span class="sdate">December 07, 2011</span>
        <h1>Discover the places you´ve never been before...</h1>
        <hr>
        <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In sapien lorem, placerat ac imperdiet a,
            volutpat et risus. </p>
    </div>
</div>

<div id="sub">
    <div class="sub" onclick="window.open('${pageContext.request.contextPath}/COURSES/parentcourses?course=数学');"><img src="../img/Math.png" class="img1" />
        <h3>数学</h3></div>
    <div class="sub" onclick="window.open('${pageContext.request.contextPath}/COURSES/parentcourses?course=语文');"><img src="../img/Chinese.png" class="img1" />
        <h3>语文</h3></div>
    <div class="sub" onclick="window.open('${pageContext.request.contextPath}/COURSES/parentcourses?course=英语');"><img src="../img/English.png" class="img1" />
        <h3>英语</h3></div>
    <div class="sub" onclick="window.open('${pageContext.request.contextPath}/COURSES/parentcourses?course=物理');"><img src="../img/Physics.png" class="img1" />
        <h3>物理</h3></div>
    <div class="sub" onclick="window.open('${pageContext.request.contextPath}/COURSES/parentcourses?course=化学');"><img src="../img/Chemical.png" class="img1" />
        <h3>化学</h3></div>
    <div class="sub" onclick="window.open('${pageContext.request.contextPath}/COURSES/parentcourses?course=生物');"><img src="../img/Biological.png" class="img1" />
        <h3>生物</h3></div>
</div>

<div id="teac">
    <p class="teac">授课老师</p>
    <p class="teac1">师者，传道、授业、解惑</p>
    <table class="teac2">
        <tr>
            <td>
                <button class="md-trigger small" data-modal="modal-14" id="1"><div class="tea2"> <img src="${pageContext.request.contextPath}/getUserImg2?teaname=喻干阳"  style="height:150px;width: 200px; "/> </div> </button><br/>
                姓名：<input type="text" readonly="readonly" name="name" id="name" value="喻干阳"/>
            </td>
            <td>
                <button class="md-trigger small" data-modal="modal-14" id="2"> <div class="tea2"><img src="${pageContext.request.contextPath}/getUserImg2?teaname=李四" style="height:150px;width: 200px; "/></div></button><br/>
                姓名：<input type="text" readonly="readonly" name="name" id="name1" value="李四" />
            </td>
            <td>
                <button class="md-trigger small" data-modal="modal-14" id="3"><div class="tea2"><img src="${pageContext.request.contextPath}/getUserImg2?teaname=王五" style="height:150px;width: 200px; "/></div></button><br/>
                姓名：<input type="text" readonly="readonly" name="name" id="name2" value="王五" />
            </td>
        </tr>
        <tr>
            <td>
                <button class="md-trigger small" data-modal="modal-14" id="4"><div class="tea2"><img src="${pageContext.request.contextPath}/getUserImg2?teaname=苏铭" style="height:150px;width: 200px; " /></div></button><br/>
                姓名：<input type="text" readonly="readonly" name="name" id="name3" value="苏铭" />
            </td>
            <td>
                <button class="md-trigger small" data-modal="modal-14" id="5">  <div class="tea2"><img src="${pageContext.request.contextPath}/getUserImg2?teaname=赵六" style="height:150px;width: 200px; " /></div></button><br/>
                姓名：<input type="text"  readonly="readonly" name="name" id="name4" value="赵六" />
            </td>
            <td>
                <button class="md-trigger small" data-modal="modal-14" id="6"><img src="${pageContext.request.contextPath}/getUserImg2?teaname=安琪" style="height:150px;width: 200px; " /></button><br/>
                姓名：<input type="text"  readonly="readonly" name="name" id="name5" value="安琪" />
            </td>
        </tr>
</table>

</div>

<script src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
<script type="text/javascript" src="../js/jquery-1.6.4.min.js"></script>
<%--<script src="js/jquery-2.1.4.min.js"></script>--%>
<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="../js/jquery.nivo.slider.pack.js"></script>
<script>
    $(function(){
    });
    $("#1").on('click',function () {videotype(1);});
    $("#2").on('click',function () {videotype(2);});
    $("#3").on('click',function () {videotype(3);});
    $("#4").on('click',function () {videotype(4);});
    $("#5").on('click',function () {videotype(5);});
    $("#6").on('click',function () {videotype(6);});




    function videotype(i) {
        console.log("---------------"+i);
        var videoObject = {
            container: '#video', //容器的ID或className
            variable: 'player', //播放函数名称
            loop: false, //播放结束是否循环播放
            autoplay: false, //是否自动播放
            cktrack: 'img/srt.srt', //字幕文件
            poster: 'img/poster.jpg', //封面图片
//				preview: { //预览图片
//					file: ['material/mydream_en1800_1010_01.png', 'material/mydream_en1800_1010_02.png'],
//					scale: 2
//				},
            drag: 'start', //拖动的属性
            video: [
                ['http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4', 'video/mp4', '中文标清', 0],
                ['http://img.ksbbs.com/asset/Mon_1703/d0897b4e9ddd9a5.mp4', 'video/mp4', '中文高清', 0],
                ['http://img.ksbbs.com/asset/Mon_1703/eb048d7839442d0.mp4', 'video/mp4', '英文高清', 0],
                ['http://img.ksbbs.com/asset/Mon_1703/d30e02a5626c066.mp4', 'video/mp4', '英文超清', 0]
            ]
        };
        var player = new ckplayer(videoObject);

    }
</script>
</body>

</html>