package com.etc.message;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
@Component
public class SMS {

    //用户名
    private static String Uid = "alax";

    //接口安全秘钥
    private static String Key = "d41d8cd98f00b204e980";

    //手机号码，多个号码如13800000000,13800000001,13800000002
    private static String smsMob = null;

    //短信内容
    private static String smsText = null;


    @RequestMapping("/message")
    public static void message(String phone,String content) {
        smsMob = phone;
        smsText = content;
        System.out.println(smsMob+"_____________________"+smsText);
        /*MessageController client = MessageController.getInstance();
        //UTF发送
        int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
        if(result>0){
            System.out.println("UTF8成功发送条数=="+result);
        }else{
            System.out.println(client.getErrorMsg(result));
        }*/
    }
}
