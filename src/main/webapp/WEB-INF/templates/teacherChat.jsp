
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //由于password是跳转的依据，因此借助session中是否有password信息来判断用户是否有登录，

    if (session.getValue("password") == null)
        out.print("<script>alert('请教师先登录！');window.location.href='${pageContext.request.contextPath}/LOGIN/login'</script>");
%>

<html>
<head>
    <title>聊天界面</title>
    <link type="text/css" rel="stylesheet" href="css/xcConfirm/xcConfirm.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
当前用户为${teacher.teaname}<br/>
用户id：${teacher.teaid}
<hr/>
<div>
    <div class="" style="width: 80%;float:left;">
        <!-- 接收者 -->
        <div class="" style="float: left">
            <p >当前好友 : <span id="sendto"></span></p>
        </div>
        <br/>
        <!-- 聊天区 -->
        <div  id="chat-view" style="height: 510px;">
            <ul  id="chat">
            </ul>
        </div>
        <!-- 输入区 -->
       <%-- <div >
            <textarea class="" id="message" name="message" rows="5"  placeholder="输入信息."></textarea>
        </div>--%>

        <div id="editor" >
        </div>
        <input type="hidden" name="message" id="message"/>

        <!-- 按钮区 -->
        <div  style="float:right;">
            <button   id="btn" > 发送</button>
        </div>
    </div>
    <!-- 列表区 -->
    <div  style="float:right;width: 20%;">
        <div>
            <h3 >好友列表 [<span id="friend"></span>]</h3>
        </div>
        <ul id="friendlist">
        </ul>
    </div>
</div>
<!-- content end -->


<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/wangEditor.js"></script>
<script type="text/javascript" src="js/xcConfirm.js"></script>
<script>
    var E = window.wangEditor;
    var editor = new E('#editor');
    window.onload=function()
    {
        showFriend();
        //定时获取好友列表
       /* setInterval(function () {
           showFriend();
        },3000);*/



//        var E = window.wangEditor;
//        var editor = new E('#editor');
        // 自定义菜单配置
        editor.customConfig.menus = [
            'head',
            'bold',
            'italic',
            'underline',
            'justify',
            'image',
            'undo',
            'redo'
        ];
        document.getElementById('btn').onclick=function () {
            // 读取 html
//             alert(editor.txt.html());
            var content=editor.txt.html();
            document.getElementById("message").value=content;
            editor.txt.html('');
            console.log(content);
            sendMessage();
        }

        // 自定义上传事件
        editor.customConfig.customUploadImg = function (files, insert) {
            // files 是 input 中选中的文件列表
            // insert 是获取图片 url 后，插入到编辑器的方法
            // 上传代码返回结果之后，将图片插入到编辑器中
            console.log(files);
            var formdata = new FormData();
            formdata.append("files", files[0])
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/onupload',
                data:formdata,
                dataType: 'json',
                cache: false,
                processData: false, // 不处理发送的数据，因为data值是Formdata对象，不需要对数据做处理
                contentType: false, // 不设置Content-type请求头
                success: function (data) {
                    console.log(data);
                    var imgUrl = "${pageContext.request.contextPath}/download?filename=" + data;
                    insert(imgUrl);
                },
                error: function () {
                    console.log("上传失败")
                }
            });
        }
        // 隐藏“网络图片”tab
        editor.customConfig.showLinkImg = false

        // 或者 var editor = new E( document.getElementById('editor'))
        editor.create();
    }

    function showFriend() {
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/showAllFriend',
            data:{tid:"${teacher.teaid}"},
//            async:false,
            dataType:'json',
            success:function (data) {
                $("#friendlist").text("");
                for (var i=0;i<data.length;i++) {
                  /*  var html = "<li>" + data[i].pid + "</li>";
                        html = "<li id='i'>"
                            + data[i].parents.parentname
                            + " <button type=\"button\" class=\"\" "
                            + "onclick=\"addChat('"
                            + data[i].parents.parentname
                            + "');\"> 聊天</button>"
                            +"<span>";
                        if(data[i].count!=null){html+=data[i].count;}
                        html+="</span>"+"</li>";*/
                    var html = "<li>" + data[i].pid + "</li>";
                    html = "<li id='i'>"
                        + data[i].parents.parentname
                        /*+ " <button type=\"button\" class=\"\" "
                        + "onclick=\"addChat('"
                        + data[i].parents.parentname
                        + "');\"> 聊天</button>"*/

                        +"<div class=\"btn-group\"> <button class=\"btn\">操作</button> <button data-toggle=\"dropdown\" class=\"btn dropdown-toggle\"><span class=\"caret\"></span></button> <ul class=\"dropdown-menu\">"
                        +"<li><a  href=\"javascript:addChat('"+ data[i].parents.parentname+"');\" >聊天</a>"
                        + "<a href=\"${pageContext.request.contextPath}/deleteFriend?parentname="+ data[i].parents.parentname+"\">删除</a></li>"+
                       "</ul></div>"
                        +"<span>";
                    if(data[i].count!=null){html+=data[i].count;}
                    html+="</span>"+"</li>";
                    $("#friendlist").append(html);
                }
            },
            error:function () {
                console.log("请求失败");
            }
        });
    }
    /**
     * 更改接收人
     */
    function addChat(parent){
        editor.txt.html('');
        var receive = $("#sendto").text();
        var sendname = "${teacher.teaname}";
        if(receive.indexOf(parent) == -1) {    //排除重复
            $("#chat").html("");
            $("#sendto").text(parent);
        }
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/getchatinfobyparentname',
            data:{receivename:parent,sendname:sendname},
            dataType:'json',
            success:function (data) {
                for(var i=2;i>=0;i--){
                    console.log(data[i]);
                    setMessage(data[i]);
                }
            },
            error:function () {
                console.log("请求失败");
            }
        });
    }
    var websocket=null;
    //判断当前浏览器是否支持websocket
    if ('WebSocket' in window){
        //创建WebSocket对象
        websocket=new WebSocket("ws://localhost:8000/jiajiaoProject/chatserver");
    }else{
        alert('当前浏览器 not support websocket');
    };
    //连接成功建立的回调方法
    websocket.onopen=function () {
        console.log("成功建立连接");
    };
    //连接发生错误的回调方法
    websocket.onerror=function () {
        console.log("连接发生错误");
    };
    //收到消息的回调方法
    websocket.onmessage=function (event) {
        console.log(event.data);
        //解析后台传回的消息,并予以展示
        analysisMessage(event.data);
    };
    //连接关闭的回调方法
    websocket.onclose=function () {
        console.log("连接关闭");
    };
    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常
    window.onbeforeunload=function () {
        closeWebSocket();
    };
    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    };
    /**
     * 解析后台传来的消息
     * "massage" : {
     *              "from" : "xxx",
     *              "to" : "xxx",
     *              "content" : "xxx",
     *              "time" : "xxxx.xx.xx"
     *          },
     * "type" : {notice|message},
     * "list" : {[xx],[xx],[xx]}
     */
    function analysisMessage(message){ console.log(message);
        message =JSON.parse(message);
        setMessage(message);


    }
    //将消息显示在网页上
    function setMessage(message) {
        var to =  message.to;   //获取接收人
        var html = "<li><a>" +
            "<div>\n" +
            "<header class=\"\"><div class=\"\">  " +
            " <a>"+message.from+"</a> 发表于<time> "+message.time+"</time>" +
            " 发送给: "+to+" </div></header><div> <p>"+message.content+"</p></div></div></li>";
        $("#chat").append(html);
        $("#message").val("");  //清空输入区
        var chat = $("#chat-view");
        chat.scrollTop(chat[0].scrollHeight);   //让聊天区始终滚动到最下面
    };

    //发送消息给后台
    function sendMessage() {
        var message=document.getElementById('message').value;
        var toname = $("#sendto").text();
        var to = toname == ""?"all":toname;
        var from = '${teacher.teaname}';
        console.log(to);
        if(message==null || message==""){
            alert("发送内容不能为空");
        }
        websocket.send(JSON.stringify( {
                content : message,
                from :from,
                to : to,      //接收人,如果没有则置空,如果有多个接收人则用,分隔
                time : getDateFull(),
                type:"teacher"
            }
            ));
    };
    function appendZero(s){return ("00"+ s).substr((s+"").length);}  //补0函数
    function getDateFull(){
        var date = new Date();
        var currentdate = date.getFullYear() + "-" + appendZero(date.getMonth() + 1) + "-" + appendZero(date.getDate()) + " " + appendZero(date.getHours()) + ":" + appendZero(date.getMinutes()) + ":" + appendZero(date.getSeconds());
        return currentdate;
    }



</script>
</body>

</html>