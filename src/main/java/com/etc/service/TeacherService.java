package com.etc.service;

import com.etc.dao.CourseinfoDao;
import com.etc.dao.CoursesDao;
import com.etc.dao.StudentsDao;
import com.etc.dao.TeacherDao;
import com.etc.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private CoursesDao coursesDao;
    @Autowired
    private StudentsDao studentsDao;
    @Autowired
    private CourseinfoDao courseinfoDao;

    //教师登录
    public boolean tealogin(String teaname,String password){
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        criteria.andTeanameEqualTo(teaname);
        System.out.println("-----------------3---------------"+criteria.andTeanameEqualTo(teaname));
        criteria.andPasswordEqualTo(password);
        Long result = teacherDao.countByExample(example);
//        Long result = teaDao.countTeanameAndPassword(example);
        System.out.println("-------------2--------------"+result);
        return result > 0;
    }

    //新增
    private boolean insert(Teacher teacher){
        return teacherDao.insertSelective(teacher)>0;
    }
    //注册
    public boolean register(Teacher teacher){
        return this.insert(teacher);
    }
//
//    //查看个人信息
//    public Teacher viewPersonal(Integer teaid){
//        TeacherExample example = new TeacherExample();
//        TeacherExample.Criteria criteria = example.createCriteria();
////        criteria.andTeanameEqualTo(teaname);
//        criteria.andTeaidEqualTo(teaid);
//        List<Teacher> teachers = teaDao.selectByExample(example);
//        if(teachers.size()>0){
//            return teachers.get(0);
//        }else {
//            return null;
//        }
//    }

    //通过姓名查看个人信息
    public Teacher viewPersonalbyteaname(String teaname){
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        criteria.andTeanameEqualTo(teaname);
        List<Teacher> teachers = teacherDao.selectByExample(example);
        if(teachers.size()>0){
            return teachers.get(0);
        }else {
            return null;
        }
    }


    //查看所有老师信息
    public List<Teacher> viewAllTeachers(){
        TeacherExample example = new TeacherExample();
       return teacherDao.selectByExample(example);
    }


    //分页查询课时
    public Page<Courses> viewCourseByPage(int pageIndex, int pageSize){
        return this.viewCourseByKeywords(pageIndex,pageSize,null);
    }
    //关键字分页查询课时
    public Page<Courses> viewCourseByKeywords(int pageIndex,int pageSize,String keywords){
        if(keywords == null){
            keywords = "";
        }
        String condition = "%" + keywords + "%";
        Page<Courses> result;
        int start = (pageIndex - 1) * pageSize;
        long totalRowCount = this.getTotalRowCount(keywords);
        CoursesExample example = new CoursesExample();
        CoursesExample.Criteria criteria = example.createCriteria();
        criteria.andCourseLike(condition);
        CoursesExample.Criteria criteria2 = example.createCriteria();
        criteria2.andStudentnameLike(condition);
        //CoursesExample.Criteria criteria3 = example.createCriteria();
        ////criteria3.andClasstimeLike(condition);
        //criteria3.andClasstimeEqualTo(condition);

        example.or(criteria2);
        //example.or(criteria3);

        example.setStartRow(start);
        example.setPageSize(pageSize);
        List<Courses> courses = coursesDao.selectByExample(example);
        result = new Page<>(pageSize, pageIndex, totalRowCount, courses);
        return result;
    }
    //获取数据
    private Long getTotalRowCount(String keywords){
        if(keywords == null){
            keywords = "";
        }
        String condition = "%" + keywords + "%";
        CoursesExample example = new CoursesExample();
        CoursesExample.Criteria criteria = example.createCriteria();
        criteria.andCourseLike(condition);

        CoursesExample.Criteria criteria2 = example.createCriteria();
        criteria2.andStudentnameLike(condition);

        //CoursesExample.Criteria criteria3 = example.createCriteria();
        //criteria3.andClasstimeLike(condition);

        example.or(criteria2);
        //example.or(criteria3);

        return coursesDao.countByExample(example);
    }
//添加课时
    public boolean addcourse(Courses courses){
        return coursesDao.insertSelective(courses)>0;
    }

    //修改课时信息
    public boolean updatecourse(Courses courses){return coursesDao.updateByPrimaryKeySelective(courses)>0;}
    //修改老师个人信息
    public boolean editinfo(Teacher teacher){return teacherDao.updateByPrimaryKeySelective(teacher)>0;}

    public Courses getSingleCourse(Integer courseid){
        return coursesDao.selectByPrimaryKey(courseid);
    }

    //删除课程
    public boolean deleteCourse(Integer id){
        return coursesDao.deleteByPrimaryKey(id) > 0;
    }


    //分页查询预约学生
    public Page<Students> viewOrderByPage(int pageIndex, int pageSize){
        return this.viewOrderByKeywords(pageIndex,pageSize,null);
    }
    //关键字分页查询预约
    public Page<Students> viewOrderByKeywords(int pageIndex,int pageSize,String keywords1){
        if(keywords1 == null){
            keywords1 = "";
        }
        String condition = "%" + keywords1 + "%";
        Page<Students> result;
        int start = (pageIndex - 1) * pageSize;
        long totalRowCount1 = this.getTotalRowCount1(keywords1);
        StudentsExample stuexample = new StudentsExample();
        StudentsExample.Criteria criteria = stuexample.createCriteria();
        criteria.andCourseLike(condition);
        StudentsExample.Criteria criteria2 = stuexample.createCriteria();
        criteria2.andStudentnameLike(condition);

        stuexample.or(criteria2);

        stuexample.setStartRow(start);
        stuexample.setPageSize(pageSize);
        List<Students> students = studentsDao.selectByExample(stuexample);
        result = new Page<>(pageSize, pageIndex, totalRowCount1, students);
        return result;
    }
    //获取数据
    private Long getTotalRowCount1(String keywords1){
        if(keywords1 == null){
            keywords1 = "";
        }
        String condition = "%" + keywords1 + "%";
        StudentsExample stuexample = new StudentsExample();
        StudentsExample.Criteria criteria = stuexample.createCriteria();
        criteria.andCourseLike(condition);

        StudentsExample.Criteria criteria2 = stuexample.createCriteria();
        criteria2.andStudentnameLike(condition);

        stuexample.or(criteria2);

        return studentsDao.countByExample(stuexample);
    }
    //删除（拒绝）预约
    public boolean deleteOrder(String studentname){
        return studentsDao.deleteorder(studentname) > 0;
    }
    //接受预约更改状态
    public boolean updateOrderState(String studentname){
        return studentsDao.updateOrderState(studentname) > 0;
    }

    //根据教师id查询预约
    public List<Students> getorderbyid(String teaname){
        return studentsDao.selectorderbyteaid(teaname);
    }

    public List<Courses> getcourse() {
        CoursesExample example = new CoursesExample();
        return coursesDao.selectByExample(example);
    }

    public List<Courses> getusername(Long datetime) {
        CoursesExample example = new CoursesExample();
        CoursesExample.Criteria criteria = example.createCriteria();
        criteria.andDatetimeEqualTo(datetime);
        return coursesDao.selectByExample(example);
    }

    public String getteaphonebyname(String teachername) {
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        criteria.andTeanameEqualTo(teachername);
        return teacherDao.selectByExample(example).get(0).getPhone();
    }

    public Teacher getteacherbyteaid(Integer teaid) {
        return teacherDao.selectByPrimaryKey(teaid);
    }

    //根据教师名获取图片
    public Teacher getteacherbyteaname(String teaname) {
        return teacherDao.selectByTeaname(teaname);
    }

//    //根据教师姓名查询教师id
//    public int getteaid(String teaname){
//        return teaDao.selectid(teaname);
//    }
    //根据教师name查询课程安排
    public List<Courses> getcoursebyname(String teaname){
        return coursesDao.selectcoursebyteaname(teaname);
    }


    //判断学生名为studentname的人数
    public long countByExample(String studentname){
        CoursesExample courseexample = new CoursesExample();
        CoursesExample.Criteria criteria = courseexample.createCriteria();
        criteria.andStudentnameEqualTo(studentname);
        return coursesDao.countByExample(courseexample);
    }

    //对stucount进行加一
    public int updatestucount(String teaname){
        return teacherDao.updatestucount(teaname);
    }

    public Long getchinesecount(String course) {
        CourseinfoExample courseexample = new CourseinfoExample();
        CourseinfoExample.Criteria criteria = courseexample.createCriteria();
        criteria.andCourseEqualTo(course);
        return courseinfoDao.countByExample(courseexample);
    }

    public Long getgradecount(String grade) {
        CourseinfoExample courseexample = new CourseinfoExample();
        CourseinfoExample.Criteria criteria = courseexample.createCriteria();
        criteria.andGradeEqualTo(grade);
        return courseinfoDao.countByExample(courseexample);
    }
}
