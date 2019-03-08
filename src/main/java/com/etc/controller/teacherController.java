package com.etc.controller;

import com.etc.entity.*;
import com.etc.service.FriendService;
import com.etc.service.ParentsService;
import com.etc.service.RecordService;
import com.etc.service.TeacherService;
import com.etc.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class teacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    FriendService friendService;
    @Autowired
    RecordService recordService;
    @Autowired
    ParentsService parentsService;

    HashMap<Integer,Integer> map = new HashMap<>();
    //老师详情信息
    @RequestMapping("/chatteainfo")
    public ModelAndView gettea(String teaname,HttpSession session){
        teaname = (String) session.getAttribute("teaname");
        ModelAndView mav = new ModelAndView();
        Teacher teacher = teacherService.viewPersonalbyteaname(teaname);
        mav.addObject("teacher",teacher);
        mav.setViewName("teacherChat");
        return mav;
    }

    /**
     * 显示教师的家长列表
     */
    @RequestMapping(value = "/showAllFriend",method = RequestMethod.POST)
    @ResponseBody
    public List<Friend> showAllFriend(Integer tid) throws ParseException {
        List<Friend> friends =friendService.showAllFriend(tid);
        System.out.println("--------friend------------"+friends);
        unreceicedCount();
        System.out.println("before:"+friends);
        for (Friend friend:friends){
            //friend手动加入parent属性
            friend.setParents(showFriendname(friend.getPid()));
            friend.setCount(map.get(friend.getPid()));
            System.out.println("---------count111111-----------"+friend.getCount());
        }
        System.out.println("After:"+friends);
        return friends;
    }
    /**
     * 查询家长列表
     */
    public Parents showFriendname(Integer pid){
        return friendService.showUsername(pid);
    }

    private HashMap<Integer,Integer> unreceicedCount() throws ParseException {
        List<Chatinfo> chatinfos = recordService.getchatinfo();
        List<Parents> parents = parentsService.getpatentsinfo();
        Integer count=0;
        for (Parents parent:parents){
            int i = 1;
            Long clicktime = parent.getClicktime();
            if (clicktime == null){
                clicktime =System.currentTimeMillis();
            }
            for (Chatinfo chatinfo:chatinfos){
                Date chatdate =chatinfo.getDate();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                String str = dateFormat.format(chatdate);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                    Long millionSeconds  = sdf.parse(str).getTime();//毫秒
                    if (parent.getParentid()==chatinfo.getSendid()&&clicktime<millionSeconds){
                        count = i++;
                        Integer parentid=parent.getParentid();
                        map.put(parentid,count);
                        System.out.println("--------------counts----------------"+map.get(parentid)+"-----------"+parent.getParentid());
                    }

            }
        }
        return map;
    }

    @RequestMapping(value ="getchatinfobyparentname",method = RequestMethod.POST)
    @ResponseBody
    public List<Msg> getchatinfobyparentname(@RequestParam("receivename") String receivename,
                                             @RequestParam("sendname") String sendname){
        Integer receiveid = recordService.getparentidbysendname(receivename).get(0);
        Integer sendid = recordService.getteaidbysendname(sendname);
        Long clicktime=System.currentTimeMillis();
        map.remove(receiveid);
        List<Msg> msgs = recordService.getchatinfosbyreceiveid(receiveid,sendid);
        recordService.setclicktime(clicktime,receivename);
        System.out.println("我到了"+msgs);
        return msgs;
    }

   /**
     * 删除好友
     */
    @RequestMapping("/deleteFriend")
    public String deleteFriend(@RequestParam("parentname") String parentname){
        System.out.println("---------parentname------------"+parentname);
        Integer parentid = parentsService.getparentidbyname(parentname);
        System.out.println("---------parentid------------"+parentid);
        friendService.deleteFriend(parentid);
        return "redirect:chatteainfo";
    }


    /**
     *wangEditor图片上传
     */
    @RequestMapping(value = "/onupload")
    @ResponseBody
    public List<String> upload(HttpServletRequest request, @RequestParam("files") MultipartFile[] files) throws IOException {
        System.out.println("图片上传成功"+files);
        return UploadUtil.doUpload(request,files);
    }

    /**
     *wangEditor图片下载
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> doDownload(HttpServletRequest request, @RequestParam String filename) throws IOException {
        return UploadUtil.doDownload(request,filename);
    }

    @RequestMapping("/getTeacherinfobypage")
    private ModelAndView getTeacherinfo(){
        ModelAndView modelAndView = new ModelAndView();
        Long chinese = teacherService.getchinesecount("语文");
        Long math = teacherService.getchinesecount("数学");
        Long english = teacherService.getchinesecount("英语");
        Long physics = teacherService.getchinesecount("物理");
        Long chemistry = teacherService.getchinesecount("化学");
        Long biology = teacherService.getchinesecount("生物");
        Long primary = teacherService.getgradecount("小学");
        Long middle = teacherService.getgradecount("初中");
        Long high = teacherService.getgradecount("高中");
        Education education = new Education(primary,middle,high,chinese,math,english,physics,chemistry,biology);
        modelAndView.addObject("education",education);
        modelAndView.setViewName("statistics/teachetTeach");
        return modelAndView;

    }
}
