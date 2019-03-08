package com.etc.service;

import com.etc.dao.*;
import com.etc.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("recordservice")
public class RecordService {
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    ParentsDao parentsMapper;
    @Autowired
    ChatinfoMapper chatinfoMapper;
    @Autowired
    FriendMapper friendDao;
    //新增

    /**
     * 根据sendname获取教师id
     * @param name
     * @return
     */
    public Integer getteaidbysendname(String name) {
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        criteria.andTeanameEqualTo(name);
        List<Teacher> teachers = teacherDao.selectByExample(example);
        System.out.println("-------teaid----------"+teachers.get(0).getTeaid());
        return teachers.get(0).getTeaid();
    }

    /**
     * 根据sendname获取家长id
     * @param name
     * @return
     */
    public List<Integer> getparentidbysendname(String name) {
        List<Parents> parents = new ArrayList<>();
        List<Integer> parentid = new ArrayList<>();
        System.out.println("-----------name-------------"+name);
        if ("all".equals(name)){
            ParentsExample example = new ParentsExample();
            parents = parentsMapper.selectByExample(example);
            for (int i=0;i<parents.size();i++){
                parentid.add(parents.get(i).getParentid());
                System.out.println("-------parentid----------"+parents.get(i).getParentid());
            }
        }else{
            ParentsExample example = new ParentsExample();
            ParentsExample.Criteria criteria = example.createCriteria();
            criteria.andParentnameEqualTo(name);
            parents = parentsMapper.selectByExample(example);
            parentid.add(parents.get(0).getParentid());
            System.out.println("-------parentid-1---------"+parents.get(0).getParentid());
        }

        return parentid;
    }

    /**
     * 将聊天信息保存在数据库
     * @param chatinfo
     */
    public void insertchatinfo(Chatinfo chatinfo) {
        chatinfoMapper.insertSelective(chatinfo);
    }

    /**
     * 获取聊天信息的时间
     * @return
     */
    public List<Chatinfo> getchatinfo() {
        ChatinfoExample example = new ChatinfoExample();
        List<Chatinfo> chatinfos = chatinfoMapper.selectByExample(example);
        System.out.println("---------------------"+chatinfos.get(0).toString());
        return chatinfos;
    }

    /**
     * 根据toid获取家长名
     * @param toid
     * @return
     */
    public String gettonamebytoid(Integer toid) {
        ParentsExample example = new ParentsExample();
        ParentsExample.Criteria criteria = example.createCriteria();
       String toname = parentsMapper.selectByPrimaryKey(toid).getParentname();
       return toname;
    }
    /**
     * 根据fromid获取教师名
     * @param fromid
     * @return
     */
    public String getfromnamebyfromid(Integer fromid) {
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        String fromname = teacherDao.selectByPrimaryKey(fromid).getTeaname();
        return fromname;
    }


    public  List<Teacher> getteacherbyfromid() {
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        List<Teacher> teachers = teacherDao.selectByExample(example);
        return teachers;
    }
    public List<Parents> getparentbytoid() {
        ParentsExample example = new ParentsExample();
        ParentsExample.Criteria criteria = example.createCriteria();
        List<Parents> parents = parentsMapper.selectByExample(example);
        return parents;
    }



    /**
     * 根据receiveid获取发送给他自己的聊天信息
     * @param receiveid
     * @return
     */
    public List<Msg> getchatinfosbyreceiveid(Integer receiveid,Integer sendid) {
        List<Msg> msgs = new ArrayList<>();
        List<Chatinfo> chatinfos =chatinfoMapper.descSelect(receiveid,sendid,sendid,receiveid);
        List<Teacher> teachers = getteacherbyfromid();
        List<Parents> parents = getparentbytoid();
        System.out.println("--------chatinfos----------"+chatinfos);
        //String content, String from, String to, Date time
        for (Chatinfo chatinfo:chatinfos){
            Integer fromid = chatinfo.getSendid();
            Integer toid = chatinfo.getReceiveid();
            String from = null;
            String to = null;
            for (Teacher teacher:teachers){
                if (fromid ==teacher.getTeaid()){from=teacher.getTeaname();}
                if (toid ==teacher.getTeaid()){to = teacher.getTeaname();}
            }
            for (Parents parent:parents){
                if (fromid ==parent.getParentid()){ from=parent.getParentname();}
                if (toid ==parent.getParentid()){to=parent.getParentname();}
            }
            String content = chatinfo.getContext();
            Date time = chatinfo.getDate();
            Msg msg = new Msg(content,from,to,time);
            System.out.println("------msg------------"+msg);
            msgs.add(msg);
        }
        return msgs;
    }

    public void setclicktime(Long clicktime,String parentname) {
        Parents parent = new Parents(clicktime);
        ParentsExample example = new ParentsExample();
        ParentsExample.Criteria criteria = example.createCriteria();
        criteria.andParentnameEqualTo(parentname);
        parentsMapper.updateByExampleSelective(parent,example);
        return;
    }

    /**
     * 获取全部好友
     * @return
     */
    public List<Friend> getfriends(Integer receiveid) {
        System.out.println("-------receiveid--------"+receiveid);
        FriendExample example = new FriendExample();
        FriendExample.Criteria criteria = example.createCriteria();
        criteria.andTidEqualTo(receiveid);
        List<Friend> friends = friendDao.selectByExample(example);
        System.out.println("-------friends--------"+friends);
        return friends;
    }

    public boolean insertfriend(Friend friend) {
        return friendDao.insertSelective(friend)>0;
    }
}
