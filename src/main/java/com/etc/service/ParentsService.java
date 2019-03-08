package com.etc.service;

import com.etc.dao.CoursesDao;
import com.etc.dao.ParentsDao;
import com.etc.dao.StudentsDao;
import com.etc.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service("parentsService")
public class ParentsService {
    @Autowired
    private ParentsDao parentsDao;
    @Autowired
    private StudentsDao studentsDao;
    @Autowired
    private CoursesDao coursesDao;

    private boolean insert(Parents parents){
        return parentsDao.insert(parents)>0;
    }

    public boolean register(Parents parents){
        return this.insert(parents);
    }


    //家长登录
    public boolean parentlogin(String parentname,String password){
        ParentsExample example = new ParentsExample();
        ParentsExample.Criteria criteria = example.createCriteria();
        criteria.andParentnameEqualTo(parentname);
        System.out.println("-----------------stu33---------------"+criteria.andParentnameEqualTo(parentname));
        criteria.andPasswordEqualTo(password);
        Long result = parentsDao.countByExample(example);
        System.out.println("-------------stu22--------------"+result);
        return result > 0;
    }

    //提交信息预约教师
    public boolean addorder(Students students){
        return studentsDao.insertSelective(students)>0;
    }


    //分页查询学生课程
    public Page<Courses> viewStuCourseByPage(int pageIndex, int pageSize){
        return this.viewStuCourseByKeywords(pageIndex,pageSize,null);
    }
    //关键字分页查询学生课程
    public Page<Courses> viewStuCourseByKeywords(int pageIndex,int pageSize,String keywords){
        if(keywords == null){
            keywords = "";
        }
        String condition = "%" + keywords + "%";
        Page<Courses> result;
        int start = (pageIndex - 1) * pageSize;
        long totalRowCount1 = this.getTotalRowCount1(keywords);
        CoursesExample stuexample = new CoursesExample();
        CoursesExample.Criteria criteria = stuexample.createCriteria();
        criteria.andCourseLike(condition);
        CoursesExample.Criteria criteria2 = stuexample.createCriteria();
        criteria2.andTeanameLike(condition);

        stuexample.or(criteria2);

        stuexample.setStartRow(start);
        stuexample.setPageSize(pageSize);
        List<Courses> courses = coursesDao.selectByExample(stuexample);
        result = new Page<>(pageSize, pageIndex, totalRowCount1, courses);
        return result;
    }
    //获取数据
    private Long getTotalRowCount1(String keywords){
        if(keywords == null){
            keywords = "";
        }
        String condition = "%" + keywords + "%";
        CoursesExample stuexample = new CoursesExample();
        CoursesExample.Criteria criteria = stuexample.createCriteria();
        criteria.andCourseLike(condition);

        CoursesExample.Criteria criteria2 = stuexample.createCriteria();
        criteria2.andTeanameLike(condition);

        stuexample.or(criteria2);

        return coursesDao.countByExample(stuexample);
    }
    //通过家长名查询该家长的课程
    public List<Courses> getstucoursebyname(String parentname){
        return coursesDao.selectbyparentname(parentname);
    }

    public List<Parents> getpatentsinfo() {
        ParentsExample example = new ParentsExample();
        List<Parents> parents = parentsDao.selectByExample(example);
        return parents;
    }


    public void updateparentbystudentname(String studentname,HttpSession session) {
        Parents parents = new Parents(studentname);
        String parentname =(String) session.getAttribute("parentname");
        System.out.println("=========="+parentname);
        ParentsExample example = new ParentsExample();
        ParentsExample.Criteria criteria = example.createCriteria();
        criteria.andParentnameEqualTo(parentname);
        parentsDao.updateByExampleSelective(parents,example);
    }

    public String getstudentnamebyparentname(String parentname) {
        ParentsExample example = new ParentsExample();
        ParentsExample.Criteria criteria = example.createCriteria();
        criteria.andParentnameEqualTo(parentname);
        return parentsDao.selectByExample(example).get(0).getStudentname();
    }


    public List<Integer> getperiodsbyname(String teachername, String studentname) {
        List<Integer> periods = new ArrayList<>();
        CoursesExample example = new CoursesExample();
        CoursesExample.Criteria criteria = example.createCriteria();
        criteria.andTeanameEqualTo(teachername);
        criteria.andStudentnameEqualTo(studentname);
        List<Courses> courses = coursesDao.selectByExample(example);
        for (Courses course:courses){
            periods.add(course.getPeriod());
        }
        return periods;
    }

    public Integer getparentidbyname(String parentname) {
        ParentsExample example = new ParentsExample();
        ParentsExample.Criteria criteria = example.createCriteria();
        criteria.andParentnameEqualTo(parentname);
        Integer parentid = parentsDao.selectByExample(example).get(0).getParentid();
        return parentid;
    }
}
