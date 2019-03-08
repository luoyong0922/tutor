package com.etc.service;

import com.etc.dao.FriendMapper;
import com.etc.dao.ParentsDao;
import com.etc.entity.Friend;
import com.etc.entity.FriendExample;
import com.etc.entity.Parents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {
    @Autowired
    private FriendMapper friendDao;
    @Autowired
    private ParentsDao parentsDao;
    /**
     * 查询显示家长信息
     */
    public Parents showUsername(Integer pid){
        Parents parents =parentsDao.selectByPrimaryKey(pid);
        return parents;
    }

    /**
     * 根据id显示教师的所有家长
     */
    public List<Friend> showAllFriend(Integer tid){
        FriendExample example=new FriendExample();
        FriendExample.Criteria criteria=example.createCriteria();
        criteria.andTidEqualTo(tid);
        return friendDao.selectByExample(example);
    }
    /**
     * 添加好友
     */
    public boolean addFriend(Friend friend){
        return friendDao.insertSelective(friend)>0;
    }

    public void deleteFriend(Integer parentid) {
        FriendExample example= new FriendExample();
        FriendExample.Criteria criteria=example.createCriteria();
        criteria.andPidEqualTo(parentid);
        friendDao.deleteByExample(example);
    }
   /* *//**
     * 删除家长
     *//*
    public boolean deleteFriend(Long uid,Long fuid){
        FriendExample example= new FriendExample();
        FriendExample.Criteria criteria=example.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andFuidEqualTo(fuid);
        return friendDao.deleteByExample(example)>0;
    }*/

}
