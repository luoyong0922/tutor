package com.etc.controller;


import com.etc.entity.Students;
import com.etc.entity.Teacher;
import com.etc.service.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class adminController {
    @Autowired
    private AdminService service;

    @RequestMapping("/LOGIN/admin")
    public String parents(){
        return "/LOGIN/admin";
    }

    @RequestMapping("/studentInfo")
    public String studentinfo(){
        return "adminTeacherInfo";
    }
    //admin登录操作
    @RequestMapping("/doAdminLogin")
    public String doAdminLogin(HttpSession session){
        String adminname = session.getAttribute("adminname").toString();
        String password = session.getAttribute("password").toString();
        System.out.println("------------------=====admin======----------"+adminname);
        System.out.println("------------------=====+admin+======----------"+password);
        if(service.adminlogin(adminname,password)){
            // 传adminname到页面
//            mav.addObject("adminname",adminname);
            //使用redirect是重新向服务器发起请求路径(RequestMapping)
            return "redirect:/getStudentbypage";
        }else{
            return "redirect:/LOGIN/login";
        }
    }

    //分页显示所有学生
    @RequestMapping("/getStudentbypage")
    public ModelAndView dogetStudentbypage(@RequestParam(value = "pageIndex",defaultValue = "1")
                                                   Integer pageIndex, ModelAndView mav, HttpServletRequest request){
        String keywords = request.getParameter("keywords");
        PageInfo<Students> page;
        page = service.viewStudentsByKeywords(pageIndex, 10, keywords);

        mav.addObject("keywords", keywords);
        mav.addObject("page",page);
//    mav.setViewName("adminTeacherInfo");
        mav.setViewName("LOGIN/admin");
        return mav;
    }

    //分页显示所有老师
    @RequestMapping("/getTeacherbypage")
    public ModelAndView dogetTeacherbypage(@RequestParam(value = "pageIndex",defaultValue = "1")
                                                   Integer pageIndex, ModelAndView mav, HttpServletRequest request){
        String keywords = request.getParameter("keywords");
        PageInfo<Teacher> page;
        page = service.viewTeachersByKeywords(pageIndex, 10, keywords);

        mav.addObject("keywords", keywords);
        mav.addObject("page",page);
//        mav.setViewName("LOGIN/admin");
        mav.setViewName("adminTeacherInfo");
        return mav;
    }

}
