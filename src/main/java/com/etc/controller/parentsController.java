package com.etc.controller;

import com.etc.entity.*;
import com.etc.service.CourseinfoService;
import com.etc.service.ParentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class parentsController {
    @Autowired
    private ParentsService parentsService;
    @Autowired
    private CourseinfoService courseinfoService;

    @RequestMapping("/LOGIN/parents")
    public String parents(){
        return "/LOGIN/parents";
    }

    //家长点击课程查看对应老师信息跳转
    @RequestMapping("/COURSES/parentcourses")
    public ModelAndView parentcourse(@RequestParam("course")String course,ModelAndView mav){
        String courses1 = course;
        System.out.println("-------COURSES/chinese--------"+courses1);
        //将courses返回到页面
        mav.addObject("courses",courses1);
        System.out.println("-------COURSES/chinese(mav)--------"+ mav.addObject("courses",courses1));
        mav.setViewName("/COURSES/parentcourses");
//        return "/COURSES/chinese";
        return mav;
    }

    //注册
    @RequestMapping("/parentsRegister")
    public String teaRegister(){
        return "parentsRegister";
    }
    @RequestMapping("/doParentsRegister")
    public String doPartentsRegister(Parents parents){
//        ModelAndView mav = new ModelAndView();
        if(parentsService.register(parents)){
            ///////////////////////////////////(mav.setViewName("/LOGIN/login");有bug,所有样式会消失)
//            mav.setViewName("/LOGIN/login");
            return "redirect:/LOGIN/login";
        }else{
//            mav.setViewName("parentsRegister");
            return "parentsRegister";
        }
    }

    //家长登录操作
    @RequestMapping("/doStudentLogin")
    public String doStudentLogin(HttpSession session,ModelAndView mav){
        String parentname = session.getAttribute("parentname").toString();
        String password = session.getAttribute("password").toString();
        System.out.println("------------------=====stu======----------"+parentname);
        System.out.println("------------------=====+stu+======----------"+password);
        if(parentsService.parentlogin(parentname,password)){
            // 传parentname到页面
            mav.addObject("parentname",parentname);
            //使用redirect是重新向服务器发起请求路径(RequestMapping)
            return "redirect:/LOGIN/parents";
        }else{
            return "redirect:/LOGIN/login";
        }
    }
    //提交信息,预约老师
    @RequestMapping("/doaddorder")
    public String doaddcourse(Students students,@RequestParam("teaname") String teaname,HttpSession session){
        System.out.println("---------students-----------"+students);

        if(parentsService.addorder(students)){
            parentsService.updateparentbystudentname(students.getStudentname(),session);
            return "redirect:/LOGIN/parents";
        }else{
            return "redirect:/LOGIN/parents";
        }
    }

    //多条件查询预约
    @RequestMapping("/searchStuCourse")
    public ModelAndView  search1(
            @RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
            @RequestParam("keywords") String keywords){
        ModelAndView mav = new ModelAndView();
        int pageSize = 15;
        Page<Courses> page = parentsService.viewStuCourseByKeywords(pageIndex, pageSize, keywords);
        mav.addObject("page",page);
        mav.setViewName("stuCourse");
        return mav;
    }
    //分页查看所有课程信息
    @RequestMapping("/getStuCoursesbypage")
    public ModelAndView getStuCoursesbypage(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                            @RequestParam(value = "parentname",required = false)String parentname){
        ModelAndView mav = new ModelAndView();
        int pageSize = 15;
        System.out.println("---------------------getStuCoursesbypage------------"+parentname);
        //获取姓名为parentname的所有信息
        mav.addObject("Page", parentsService.getstucoursebyname(parentname));
        System.out.println("-------------------getStuCoursesbypage(service)------------" + parentsService.getstucoursebyname(parentname));
        //进行分页
        mav.addObject("page", parentsService.viewStuCourseByPage(pageIndex, pageSize));
        mav.setViewName("stuCourse");
        return mav;
    }
    @RequestMapping("payinfo")
    public ModelAndView payinfo(@RequestParam("teachername") String teachername,HttpSession session){
        int totalprice = 0;
        ModelAndView modelAndView = new ModelAndView();
        String parentname = (String) session.getAttribute("parentname");
        System.out.println("------parentname-----"+parentname);
        String studentname = parentsService.getstudentnamebyparentname(parentname);
        System.out.println("------studentname-----"+studentname);
        List<Integer> periods = parentsService.getperiodsbyname(teachername,studentname);
        Integer price = courseinfoService.getpricebyteachername(teachername);
        for (Integer period:periods){
            totalprice +=period*price;
        }
        System.out.println("---------totalprice-----------------"+totalprice);
        System.out.println("---------------studentname---------------------"+studentname);
        modelAndView.addObject("studentname",studentname);
        modelAndView.addObject("totalprice",totalprice);
        modelAndView.setViewName("/paypage");
        return modelAndView;
    }
    @RequestMapping("/alipay")
    public String alipay(){
        System.out.println("______riririririririr_____________");
        return "/alipay.trade.page.pay";
    }
}
