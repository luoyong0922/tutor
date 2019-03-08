package com.etc.websocket;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

@Component
public class HttpSessionConfigurator extends ServerEndpointConfig.Configurator  {
    @Override
    public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response) {

        //request.getHttpSession(true);
        HttpSession httpSession = (HttpSession)request.getHttpSession();
        if (httpSession!=null){
            config.getUserProperties().put(HttpSession.class.getName(),httpSession);
        }else{
            System.out.println("modifyHandshake 获取到null session");
        }
    }

}