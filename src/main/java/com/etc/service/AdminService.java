package com.etc.service;

import com.etc.dao.AdminDao;
import com.etc.dao.StudentsDao;
import com.etc.dao.TeacherDao;
import com.etc.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private StudentsDao studentsDao;

    //管理员登录
    public boolean adminlogin(String adminname,String password){
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andAdminnameEqualTo(adminname);
        System.out.println("-----------------admin33---------------"+criteria.andAdminnameEqualTo(adminname));
        criteria.andPasswordEqualTo(password);
        Long result = adminDao.countByExample(example);
        System.out.println("-------------admin22--------------"+result);
        return result > 0;
    }

//    //管理员分页查询教师信息
//    public Page<Teacher> viewTeacherByPage(int pageIndex, int pageSize,String keywords){
////        System.out.println("-------------admin---------------");
////        return this.viewTeacherByKeywords(pageIndex,pageSize,null);
//        if(keywords == null){
//            keywords = "";
//        }
//        String condition = "%" + keywords + "%";
//        Page<Teacher> result;
//        int start = (pageIndex - 1) * pageSize;
//        long totalRowCount = this.getTotalRowCount(keywords);
//        TeacherExample teaexample = new TeacherExample();
//        TeacherExample.Criteria criteria = teaexample.createCriteria();
//        criteria.andTeanameLike(condition);
//        TeacherExample.Criteria criteria2 = teaexample.createCriteria();
//        criteria2.andSchoolLike(condition);
//
//        teaexample.or(criteria2);
//
//        teaexample.setStartRow(start);
//        teaexample.setPageSize(pageSize);
////        List<Teacher> teachers = teacherDao.selectByExample(teaexample);
//        List<Teacher> teachers = teacherDao.selectcourseAndgrade(teaexample);
//        System.out.println("-------------admin22--------------"+teachers);
//        result = new Page<>(pageSize, pageIndex, totalRowCount, teachers);
//        System.out.println("-------------admin33--------------"+result);
//        return result;
//    }
//    //关键字分页查询教师信息
//    public Page<Teacher> viewTeacherByKeywords(int pageIndex,int pageSize,String keywords){
//        if(keywords == null){
//            keywords = "";
//        }
//        String condition = "%" + keywords + "%";
//        Page<Teacher> result;
//        int start = (pageIndex - 1) * pageSize;
//        long totalRowCount = this.getTotalRowCount(keywords);
//        TeacherExample teaexample = new TeacherExample();
//        TeacherExample.Criteria criteria = teaexample.createCriteria();
//        criteria.andTeanameLike(condition);
//        TeacherExample.Criteria criteria2 = teaexample.createCriteria();
//        criteria2.andSchoolLike(condition);
//
//        teaexample.or(criteria2);
//
//        teaexample.setStartRow(start);
//        teaexample.setPageSize(pageSize);
//        List<Teacher> teachers = teacherDao.selectByExample(teaexample);
////        List<Teacher> teachers = teacherDao.selectcourseAndgrade(teaexample);
//        System.out.println("-------------admin11--------------"+teachers);
//        result = new Page<>(pageSize, pageIndex, totalRowCount, teachers);
//        System.out.println("-------------admin00--------------"+result);
//        return result;
//    }
//    //获取数据
//    private Long getTotalRowCount(String keywords){
//        if(keywords == null){
//            keywords = "";
//        }
//        String condition = "%" + keywords + "%";
//        TeacherExample teaexample = new TeacherExample();
//        TeacherExample.Criteria criteria = teaexample.createCriteria();
//        criteria.andTeanameLike(condition);
//
//        TeacherExample.Criteria criteria2 = teaexample.createCriteria();
//        criteria2.andSchoolLike(condition);
//
//        teaexample.or(criteria2);
//
//        return teacherDao.countByExample(teaexample);
//    }

    //    //管理员分页查询教师信息
//    public Page<Teacher> viewTeacherByPage(int pageIndex, int pageSize){
//        System.out.println("-------------admin---------------");
//        return this.viewTeacherByKeywords(pageIndex,pageSize,null);
//    }
    //关键字分页查询教师信息
    public PageInfo<Teacher> viewTeacherByKeywords(int pageIndex,int pageSize,String keywords){
        if(keywords == null){
            keywords = "";
        }
        String condition = "%" + keywords + "%";
        PageInfo<Teacher> result;
        PageHelper.startPage(pageIndex,pageSize,true);
        TeacherExample teaexample = new TeacherExample();
        TeacherExample.Criteria criteria = teaexample.createCriteria();
        criteria.andTeanameLike(condition);
        TeacherExample.Criteria criteria2 = teaexample.createCriteria();
        criteria2.andSchoolLike(condition);

        teaexample.or(criteria2);

//        teaexample.setStartRow(start);
//        teaexample.setPageSize(pageSize);
        List<Teacher> teachers = teacherDao.selectByExample(teaexample);
        System.out.println("-------------admin11--------------"+teachers);
//        result = new Page<>(pageSize, pageIndex, totalRowCount, teachers);
//        System.out.println("-------------admin00--------------"+result);
        result = new PageInfo<>(teachers);
        return result;
    }
    //获取数据
    private Long getTotalRowCount(String keywords){
        if(keywords == null){
            keywords = "";
        }
        String condition = "%" + keywords + "%";
        TeacherExample teaexample = new TeacherExample();
        TeacherExample.Criteria criteria = teaexample.createCriteria();
        criteria.andTeanameLike(condition);

        TeacherExample.Criteria criteria2 = teaexample.createCriteria();
        criteria2.andSchoolLike(condition);

        teaexample.or(criteria2);

        return teacherDao.countByExample(teaexample);
    }

    //管理员分页查询学生信息
    public PageInfo<Students> viewStudentsByKeywords(int pageIndex, int pageSize, String keywords){
        if(keywords == null){
            keywords = "";
        }
        String condition = "%" + keywords + "%";
        PageInfo<Students> result;
        PageHelper.startPage(pageIndex,pageSize,true);
        StudentsExample example = new StudentsExample();
        StudentsExample.Criteria criteria = example.createCriteria();
        criteria.andGradeLike(condition);
        StudentsExample.Criteria criteria2 = example.createCriteria();
        criteria2.andCourseLike(condition);

        example.or(criteria2);
        List<Students> studentsList = studentsDao.selectByExample(example);
        result = new PageInfo<>(studentsList);
        return result;
    }

    //管理员分页查询老师信息
    public PageInfo<Teacher> viewTeachersByKeywords(int pageIndex, int pageSize, String keywords){
        if(keywords == null){
            keywords = "";
        }
        String condition = "%" + keywords + "%";
        PageInfo<Teacher> result;
        PageHelper.startPage(pageIndex,pageSize,true);
        TeacherExample teaexample = new TeacherExample();
        TeacherExample.Criteria criteria = teaexample.createCriteria();
        criteria.andTeanameLike(condition);
        TeacherExample.Criteria criteria2 = teaexample.createCriteria();
        criteria2.andSchoolLike(condition);

        teaexample.or(criteria2);
        List<Teacher> teacherList = teacherDao.selectcourseAndgrade(teaexample);
        result = new PageInfo<>(teacherList);
        return result;
    }
}
