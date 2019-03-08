package com.etc.websocket;

import com.etc.entity.Chatinfo;
import com.etc.entity.Friend;
import com.etc.entity.Msg;
import com.etc.service.RecordService;
import com.etc.utils.ApplicationContextRegister;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

@Component("chattest")
// configurator = HttpSessionConfigurator.classs是引用HttpSessionConfigurator
//使httpsession的方法有效
@ServerEndpoint(value = "/chatserver",configurator = HttpSessionConfigurator.class)
public class Chattest {
    @Autowired
    //RecordService service = new RecordService();
    private RecordService recordService=(RecordService) ApplicationContextRegister.getApplicationContext().getBean("recordservice");

    private static int onlineCount = 0; //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static CopyOnWriteArraySet<Chattest> webSocketSet = new CopyOnWriteArraySet<Chattest>();
    private Session session;    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private String username;      //用户名
    private HttpSession httpSession;    //request的session

    private static List list = new ArrayList<>();   //在线列表,记录用户名称
    private static Map routetab = new HashMap<>();  //用户名和websocket的session绑定的路由表

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws IOException {
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        String parentflag = (String) httpSession.getAttribute("parentflag");
        System.out.println("++++++++"+parentflag);
        if (!"true".equals(parentflag)){
            this.username = (String) httpSession.getAttribute("teaname");
            System.out.println("1");
        }else{
            this.username = (String) httpSession.getAttribute("parentname");
            //httpSession.removeAttribute("parentflag");
            httpSession.setAttribute("parentflag","false");
            System.out.println("----------------------"+httpSession.getAttribute("parentflag"));
        }
//        this.username = (String) httpSession.getAttribute("username");
        list.add(username);
        System.out.println("______user___________"+username);
        routetab.put(username,session);
        String message = "有新连接加入！当前在线人数为"+getOnlineCount();
        broadcast(message);            //广播
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() throws IOException {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        list.remove(username);        //从在线列表移除这个用户
        routetab.remove(username);
        String message = "有一连接关闭！当前在线人数为"+getOnlineCount();
        broadcast(message);
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);

        Gson gson = new Gson();
        Msg msg = gson.fromJson(message,Msg.class);      //jsonstring如何通过gson转成普通对象
        List<Integer> ids = getidbyname(msg);
        System.out.println("-------ids------------"+ids);
        if ("all".equals(msg.getTo()) || msg.getTo().equals("")){
            //broadcast(msg.getContent());
            //广播
            for (Integer toid:ids){
                String toname =recordService.gettonamebytoid(toid);
                Session sessionto = (Session)routetab.get(toname);
                System.out.println("-------allmessage--------------"+sessionto);
                if ( sessionto != null){
                    singleSend(message,sessionto);//发送给所有用户
                }
            }
            Session sessionfrom = (Session)routetab.get(msg.getFrom());
            if (sessionfrom !=null){
                singleSend(message,sessionfrom);//发送给自己
            }

        }else {
            Session sessionto =(Session)routetab.get(msg.getTo());
            Session sessionfrom = (Session)routetab.get(msg.getFrom());
            System.out.println("-------getto-------"+msg.getTo());
            System.out.println("-------getto-------"+sessionto);
            System.out.println("---------getfrom---------"+msg.getFrom());
            System.out.println("---------getfrom---------"+sessionfrom);
            if ( sessionto != null){
                singleSend(message,sessionto);//发送给指定用户
            }
            if (sessionfrom !=null){
                singleSend(message,sessionfrom);//发送给自己
            }
        }
    }

    private List<Integer> getidbyname(Msg msg) {
        List<Integer> receiveids = new ArrayList<>();
        String sendname = msg.getFrom();
        String receivename = msg.getTo();
        String type = msg.getType();
        if ("teacher".equals(type)){
            String context = msg.getContent();
            Date date = msg.getTime();
            Integer sendid = recordService.getteaidbysendname(sendname);
            receiveids = recordService.getparentidbysendname(receivename);
            for (Integer receive:receiveids){
                Integer receiveid = receive;
                Chatinfo chatinfo = new Chatinfo(sendid,receiveid,date,context);
                recordService.insertchatinfo(chatinfo);
            }
        }else {
            String context = msg.getContent();
            Date date = msg.getTime();
            Integer receiveid = recordService.getteaidbysendname(receivename);
            List<Integer> sendids =recordService.getparentidbysendname(sendname);
            Integer sendid = sendids.get(0);
            Chatinfo chatinfo = new Chatinfo(sendid,receiveid,date,context);
            recordService.insertchatinfo(chatinfo);
            addfriend(receiveid,sendid,sendname);
        }
        return receiveids;
    }

    /**
     * 广播消息
     * @param message 客户端发送过来的消息
     */
    public void broadcast(String message) {
        System.out.println("来自客户端的消息广播:" + message);
        //群发消息
        for(Chattest item: webSocketSet){
            try {
                item.sendMessage(message);
                //session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 对特定的用户发送消息
     * @param message
     * @param session
     */
    public void singleSend(String message, Session session){
        System.out.println("来自客户端的消息私聊:" + message);
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }

    public void addfriend(Integer receiveid,Integer sendid,String sendname){
        List<Friend> friends = recordService.getfriends(receiveid);
        System.out.println("----------friends---------00-"+friends);
        int flag = 0;
        for (Friend friend:friends){
            if (sendid ==friend.getPid()){ flag=1; }
        }
        if (flag ==0){
            Integer pid =recordService.getparentidbysendname(sendname).get(0);
            Friend friend = new Friend(receiveid,pid);
            Boolean bbbb =  recordService.insertfriend(friend);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        Chattest.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        Chattest.onlineCount--;
    }
}