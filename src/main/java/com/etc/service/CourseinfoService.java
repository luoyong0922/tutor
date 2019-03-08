package com.etc.service;

import com.etc.dao.CourseinfoDao;
import com.etc.dao.TeacherDao;
import com.etc.entity.Courseinfo;
import com.etc.entity.CourseinfoExample;
import com.etc.entity.Teacher;
import com.etc.entity.TeacherExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseinfoService")
public class CourseinfoService {
    @Autowired
    private CourseinfoDao courseinfoDao;
//    @Autowired
//    private TeacherDao teacherDao;
    //新增
    private boolean insert(Courseinfo courseinfo){
        return courseinfoDao.insertSelective(courseinfo)>0;
    }
    //注册
    public boolean register(Courseinfo courseinfo){
        return this.insert(courseinfo);
    }

    //查看所有老师信息
    public List<Courseinfo> viewAllCourseinfo(){
        CourseinfoExample example = new CourseinfoExample();
        return courseinfoDao.selectByExample(example);
    }
    //根据课程查看老师信息
    public List<Courseinfo> viewAllCourseinfobycourse(String course){
        System.out.println("-------------------teachershow3(service)------------------"+course);
        return courseinfoDao.selectBycourse(course);
    }


    //通过姓名查看个人信息
    public Courseinfo viewPersonalgraderbyteaname(String teaname){
        CourseinfoExample example = new CourseinfoExample();
        CourseinfoExample.Criteria criteria = example.createCriteria();
        criteria.andTeanameEqualTo(teaname);
        List<Courseinfo> courseinfos = courseinfoDao.selectByExample(example);
        if(courseinfos.size()>0){
            return courseinfos.get(0);
        }else {
            return null;
        }
    }

    //修改老师个人信息
//    public boolean editinfocourse(String teaname){return courseinfoDao.updateByteaname(teaname)>0;}

    //修改老师个人信息
    public boolean editinfocourse(Courseinfo courseinfo){return courseinfoDao.updateByteaname(courseinfo)>0;}

    public Integer getpricebyteachername(String teachername) {
        CourseinfoExample example = new CourseinfoExample();
        CourseinfoExample.Criteria criteria = example.createCriteria();
        criteria.andTeanameEqualTo(teachername);
        return courseinfoDao.selectByExample(example).get(0).getPrice();
    }
}
