
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Welcome:<span id="to">${teaname}</span><br/><input id="text" type="text"/>
<button onclick="send()">发送消息</button>
<hr/>
<button onclick="closeWebSocket()">关闭WebSocket连接</button>
<hr/>
<div id="message"></div>
</body>

<script type="text/javascript">
    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        wsServer = "ws://"+location.host+"${pageContext.request.contextPath}"+"chatserver";
        console.log("one");
        websocket = new WebSocket("ws://localhost:8000/jiajiaoProject/chatserver");
        console.log("two");
    }
    else {
        alert('当前浏览器 Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        console.log("-----------event-------------"+event.data);
        setMessageInnerHTML1(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }

    //将消息显示在网页上
    function setMessageInnerHTML1(innerHTML) {
        message =JSON.parse(innerHTML);
        console.log("----------message------------"+message);
        document.getElementById('message').innerHTML += message.content + '<br/>';
    }
    //将文本消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }

    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        var to ='${teaname}';
        var from='${parentname}';
            if(message == null || message == ""){
                layer.msg("请不要惜字如金!", { offset: 0, shift: 6 });
                return
            }
            websocket.send(JSON.stringify({
                    content: message,
                    from:from,
                    to:to,
                    time : getDateFull(),
                    type: "parent"
            }));
    }
    function appendZero(s){return ("00"+ s).substr((s+"").length);}  //补0函数
    function getDateFull(){
        var date = new Date();
        var currentdate = date.getFullYear() + "-" + appendZero(date.getMonth() + 1) + "-" + appendZero(date.getDate()) + " " + appendZero(date.getHours()) + ":" + appendZero(date.getMinutes()) + ":" + appendZero(date.getSeconds());
        return currentdate;
    }
</script>
</html>
