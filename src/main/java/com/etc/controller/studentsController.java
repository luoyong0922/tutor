package com.etc.controller;

import com.etc.dao.StudentsDao;
import com.etc.entity.Education;
import com.etc.entity.ResponseResult;
import com.etc.entity.Students;
import com.etc.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class studentsController {
    @Autowired
    private StudentsDao studentsDao;
    @Autowired
    private StudentsService studentsService;
    @RequestMapping("setstudentinfo")
    private ModelAndView setstudentinfo(Students students, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        int s = (int) session.getAttribute("distance");
        if(s<5000) {
            if (studentsDao.insert(students)>0) {
                modelAndView.setViewName("redirect:/teapage");
            } else {
                modelAndView.setViewName("redirect:/teapage");
            }
        }else {
            modelAndView.addObject(students);
            modelAndView.setViewName("forward:appointmen");
        }
        return modelAndView;
    }



    @RequestMapping("teapage")
    private String teapage(){
        return "index";
    }

    @RequestMapping("/getStudentinfostatistics")
    private ModelAndView getStudentinfostatistics(){
        ModelAndView modelAndView = new ModelAndView();
        Long primary1 = studentsService.getgendercount("小学","男");
        Long primary0 = studentsService.getgendercount("小学","女");
        Long middle1 = studentsService.getgendercount("初中","男");
        Long middle0 = studentsService.getgendercount("初中","女");
        Long high1 = studentsService.getgendercount("高中","男");
        Long high0 = studentsService.getgendercount("高中","女");
        Education girledu = new Education(primary0,middle0,high0);
        Education boyedu = new Education(primary1,middle1,high1);
        System.out.println("---------------"+girledu);
        System.out.println("---------------"+boyedu);
        modelAndView.addObject("girledu",girledu);
        modelAndView.addObject("boyedu",boyedu);
        modelAndView.setViewName("statistics/studentClass");
        return modelAndView;
    }

    @RequestMapping("getCourseCount")
    private ModelAndView getCourseCountstatistics(){
        ModelAndView modelAndView = new ModelAndView();
        Long chinese0 = studentsService.getCourseCount("语文","女");
        Long chinese1 = studentsService.getCourseCount("语文","男");
        Long math0 = studentsService.getCourseCount("数学","女");
        Long math1 = studentsService.getCourseCount("数学","男");
        Long English0 = studentsService.getCourseCount("英语","女");
        Long English1 = studentsService.getCourseCount("英语","男");
        Long Physics0 = studentsService.getCourseCount("物理","女");
        Long Physics1 = studentsService.getCourseCount("物理","男");
        Long Chemistry0 = studentsService.getCourseCount("化学","女");
        Long Chemistry1 = studentsService.getCourseCount("化学","男");
        Long Biology0 = studentsService.getCourseCount("生物","女");
        Long Biology1 = studentsService.getCourseCount("生物","男");
        Education girlcourse = new Education(chinese0,math0,English0,Physics0,Chemistry0,Biology0);
        Education boycourse = new Education(chinese1,math1,English1,Physics1,Chemistry1,Biology1);
        System.out.println("---------------"+girlcourse);
        System.out.println("---------------"+boycourse);
        modelAndView.addObject("boycourse",boycourse);
        modelAndView.addObject("girlcourse",girlcourse);
        modelAndView.setViewName("statistics/studentStudy");
        return modelAndView;

    }

}
