package com.etc.controller;

import com.etc.entity.*;
import com.etc.service.CourseinfoService;
import com.etc.service.TeacherService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class indexController {
    @Autowired
    private TeacherService service;
    @Autowired
    private CourseinfoService courseinfoService;

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//        date.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(date, true));
//    }

//    public static String getNowDate(){
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        sdf.applyPattern("yyyy-MM-dd");
//        return sdf.format(date);
//    }

    //游客点击课程查看对应老师信息跳转
    @RequestMapping("/COURSES/courses")
    public ModelAndView courses(@RequestParam("course")String course,ModelAndView mav){
        String courses = course;
        System.out.println("-------COURSES/chinese--------"+courses);
        //将courses返回到页面
        mav.addObject("courses",courses);
        System.out.println("-------COURSES/chinese(mav)--------"+ mav.addObject("courses",courses));
        mav.setViewName("/COURSES/courses");
//        return "/COURSES/chinese";
        return mav;
    }

    //老师点击课程查看对应老师信息跳转
    @RequestMapping("/COURSES/teachercourses")
    public ModelAndView teachercourses(@RequestParam("course")String course,ModelAndView mav){
        String courses1 = course;
        System.out.println("-------COURSES/chinese--------"+courses1);
        //将courses返回到页面
        mav.addObject("courses",courses1);
        System.out.println("-------COURSES/chinese(mav)--------"+ mav.addObject("courses",courses1));
        mav.setViewName("/COURSES/teachercourses");
//        return "/COURSES/chinese";
        return mav;
    }



    @RequestMapping("/LOGIN/login")
    public String login1(){
        return "/LOGIN/login";
    }
    @RequestMapping("/LOGIN/login_check")
    public String login_check(){
        return "/LOGIN/login_check";
    }
    @RequestMapping("/LOGIN/image")
    public String image(){
        return "/LOGIN/image";
    }
    @RequestMapping("/LOGIN/teacher")
    public String teacher(){
        return "/LOGIN/teacher";
    }
//    @RequestMapping("/LOGIN/parents")
//    public String parents(){
//        return "/LOGIN/parents";
//    }

    //注册选择
    @RequestMapping("/registerChoose")
    public String registerChoose(){
        return "/registerChoose";
    }

//登录操作
    @RequestMapping("/loginshow")
    public String login(){
        return "login";
    }
    //教师登录操作
    @RequestMapping("/doLogin")
    public String doLogin(HttpSession session,ModelAndView mav){
        //从session里把teaname拿出来，并赋值给teaname
        String teaname = session.getAttribute("teaname").toString();
        String password = session.getAttribute("password").toString();
        System.out.println("------------------=====doLogin======----------"+teaname);
        System.out.println("------------------=====+doLogin+======----------"+password);
        if(service.tealogin(teaname,password)){
            System.out.println("----------------doLogin1---------------"+service.tealogin(teaname,password));
            // 传teaname到页面
            mav.addObject("teaname",teaname);
//            mav.addObject("teaID",service.getteaid(teaname));
//            mv.addObject("teacher",teacher);
//            session.setAttribute("teacher",teaname);
            //使用redirect是重新向服务器发起请求路径(RequestMapping)
            return "redirect:/LOGIN/teacher";
        }else{
            return "redirect:/LOGIN/login";
        }
    }
    @RequestMapping("/logout")//注销（退出）
    public String logout(Map map, SessionStatus sessionStatus, RedirectAttributes attributes){
        Teacher teacher = (Teacher) map.get("teacher");
        if(teacher != null){
            sessionStatus.setComplete();//让session过期
        }
        //重定向传递参数
        attributes.addAttribute("op","logout");
        return "redirect:index";
    }

//首页跳转
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
//老师注册
    @RequestMapping("/teaRegister")
    public String teaRegister(){
        return "teaRegister";
    }
    @RequestMapping("/doTeaRegister")
    public String doTeaRegister(Teacher teacher, Courseinfo courseinfo){
//       ModelAndView mav = new ModelAndView();
       //同时对两张表进行注册
       if(service.register(teacher) && courseinfoService.register(courseinfo) ){
//           mav.setViewName("login");
//           return mav;
           return "redirect:/LOGIN/login";
       }else{
//           mav.setViewName("teaRegister");
//           return mav;
           return "teaRegister";
       }
    }
//游客查看老师详情信息
    @RequestMapping("/teaPersonal")
     public ModelAndView getPersonal(Teacher teacher,Courseinfo courseinfo,HttpSession session){
        ModelAndView mav = new ModelAndView();
        //从teacher表获取信息
        mav.addObject("teacher",service.viewPersonalbyteaname(teacher.getTeaname()));
        session.setAttribute("teacherinfo",service.viewPersonalbyteaname(teacher.getTeaname()));
        //从courseinfo表获取信息
        mav.addObject("teachers",courseinfoService.viewPersonalgraderbyteaname(courseinfo.getTeaname()));
        mav.setViewName("teacherInfo");
        return mav;
     }


    //老师的个人详情信息中心
    @RequestMapping("/editPersonalInfo")
    public ModelAndView editPersonalInfo(Teacher teacher,Courseinfo courseinfo){
        ModelAndView mav = new ModelAndView();
        //从teacher表获取信息
        mav.addObject("teacher",service.viewPersonalbyteaname(teacher.getTeaname()));
        //从courseinfo表获取信息
        mav.addObject("teachers",courseinfoService.viewPersonalgraderbyteaname(courseinfo.getTeaname()));
        mav.setViewName("teaPersonalInfo");
        return mav;
    }
    /**
     * 修改个人详情信息，图片的上传
     * @param teacher
     * @param courseinfo
     * @param file
     * @param teaname
     * @param teaid
     * @return
     * @throws IOException
     */
    @RequestMapping("/doeditinfo")
    public String doeditinfo(Teacher teacher,Courseinfo courseinfo,
                             @RequestParam("image") MultipartFile file,
                             @RequestParam("teaname") String teaname,
                             @RequestParam("teaid") Integer teaid,
                             @RequestParam("freetime") String freetime) throws IOException {
        if (!file.isEmpty()){
            System.out.println(!file.isEmpty());
            BASE64Encoder encoder=new BASE64Encoder();
            //通过base64来转化图片
            //1.文件转换为byte[] 2.然后用BASE64编码转换 3.此时为string类型
            String image=encoder.encode(file.getBytes());
            teacher.setImages(image);
        }
       String[] freetimes = freetime.split(",");
        System.out.println("----------+freetime------------"+freetime);
       List<String> relfreetime = new ArrayList<>();

        for (String free:freetimes){  int i = 0;
            for (String time:freetimes){
                if (free.equals(time)){i++;}
            }
            System.out.println("----------+++++++++++doeditinfo+++++++++------------"+i);
            if (i>0&&i%2==1){relfreetime.add(free);}
        }
        String strfreetime = String.join(",",relfreetime);
        teacher.setFreetime(strfreetime);
        System.out.println("----------+++++++++++doeditinfo+++++++++------------"+teacher);
        System.out.println("----------+++++++++++doeditinfo+++++++++------------"+strfreetime);
        if(service.editinfo(teacher)&&courseinfoService.editinfocourse(courseinfo)) {
            return "forward:editPersonalInfo";
        }else{
            return "redirect:index";
        }
    }

    /**
     * 图片的获取
     * @param request
     * @param response
     * @param teaid
     * @throws IOException
     */
    @RequestMapping(value = "/getUserImg",method = RequestMethod.GET)
    public void upload(HttpServletRequest request, HttpServletResponse response,
                       @RequestParam("teaid") Integer teaid)
            throws IOException {
        //id 获取图片id，方便查询
        //通过id查询，此时user里面image是byte[] 类型
        Teacher teacher=service.getteacherbyteaid(teaid);
        //强制转换为byte[] ,然后转换为string类型，此时得到我们需要的BASE64码
        byte[] byteAry=(byte[])teacher.getImages();
        String data=new String(byteAry,"UTF-8");
        //BASE64解码成byte[] 这样才能生存图片
        BASE64Decoder decoder=new BASE64Decoder();
        byte[] bytes=decoder.decodeBuffer(data);
        for (int i=0;i<bytes.length;i++){
            if (bytes[i]<0){
                //调用异常数据
                bytes[i]+=256;
            }
        }
        //返回文件属性
        response.setContentType("image/*");
        //流操作，是的可以在jsp页面上接收图片
        ServletOutputStream outputStream=response.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * （根据teaname）图片的获取
     * @param request
     * @param response
     * @param teaname
     * @throws IOException
     */
    @RequestMapping(value = "/getUserImg2",method = RequestMethod.GET)
    public void upload2(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam("teaname") String teaname)
            throws IOException {
        //id 获取图片id，方便查询
        //通过id查询，此时user里面image是byte[] 类型
        Teacher teacher=service.getteacherbyteaname(teaname);
        System.out.println("-----------teacherimages----------------------"+teacher.getImages());
        if (teacher.getImages() ==null|| "".equals(teacher.getImages())){
            Teacher defaultimage=service.getteacherbyteaname("teacher1090");
            //强制转换为byte[] ,然后转换为string类型，此时得到我们需要的BASE64码
            byte[] byteAry = (byte[]) defaultimage.getImages();
            String data = new String(byteAry, "UTF-8");
            //BASE64解码成byte[] 这样才能生存图片
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(data);
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] < 0) {
                    //调用异常数据
                    bytes[i] += 256;
                }
            }
            //返回文件属性
            response.setContentType("image/*");
            //流操作，是的可以在jsp页面上接收图片
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        }else {
            //强制转换为byte[] ,然后转换为string类型，此时得到我们需要的BASE64码
            byte[] byteAry = (byte[]) teacher.getImages();
            String data = new String(byteAry, "UTF-8");
            //BASE64解码成byte[] 这样才能生存图片
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(data);
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] < 0) {
                    //调用异常数据
                    bytes[i] += 256;
                }
            }
            //返回文件属性
            response.setContentType("image/*");
            //流操作，是的可以在jsp页面上接收图片
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        }
    }




    //修改老师个人详情信息页面
    @RequestMapping("/editinfo")
    public String  editinfo(@RequestParam("teaname") String teaname,Model model){
        Teacher teacherInfo = service.viewPersonalbyteaname(teaname);
        Courseinfo courseinfo = courseinfoService.viewPersonalgraderbyteaname(teaname);
        model.addAttribute("teacherInfo",teacherInfo);
        model.addAttribute("courseinfo",courseinfo);
        return "editTeaPersonalInfo";
    }


     //查看所有老师信息（返回json对象）
     @RequestMapping("/teachershow")
     @ResponseBody
     public List<Teacher>  teachershow(){
         List<Teacher> teachers = service.viewAllTeachers();
         return  teachers;
     }
    //查看所有老师课程、科目信息（返回json对象）
    @RequestMapping("/teachershow2")
    @ResponseBody
    public List<Courseinfo>  courseinfoshow(){
        List<Courseinfo> courseinfo = courseinfoService.viewAllCourseinfo();
        return  courseinfo;
    }
    //查看所有老师课程、科目信息（返回json对象）
    @RequestMapping("/teachershow3")
    @ResponseBody
    public List<Courseinfo>  courseinfoshowbycourse(@RequestParam("course")String course){
        System.out.println("-------------------teachershow3------------------"+course);
        List<Courseinfo> courseinfo2 = courseinfoService.viewAllCourseinfobycourse(course);
        System.out.println("----------+---------teachershow3---------+---------"+courseinfo2);
        return  courseinfo2;
    }

    //分页查看所有课程
    @RequestMapping("/getcoursesbypage")
    public ModelAndView getUsersByPage(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,Teacher teacher){
        ModelAndView mav = new ModelAndView();
        int pageSize = 15;
        //获取名为teaname的课程信息
        System.out.println("-----------------getcoursesbypage-----------------"+teacher.getTeaname());
        mav.addObject("Page",service.getcoursebyname(teacher.getTeaname()));
        System.out.println("-------------------getcoursesbypage(service)------------" + service.getcoursebyname(teacher.getTeaname()));

        mav.addObject("page",service.viewCourseByPage(pageIndex,pageSize));
        mav.setViewName("queryPeriod");
        return mav;
    }

//添加课程
    @RequestMapping(value = "/doaddcourse",method = RequestMethod.POST)
    public ModelAndView doaddcourse(@RequestParam("date") String date,
                              @RequestParam("classtime") String time,
                              @RequestParam("course") String course,
                              @RequestParam("teaname") String teaname,
                              @RequestParam("parentname") String parentname,
                              @RequestParam("studentname") String studentname,
                              @RequestParam("period") Integer period,
                                    @RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex) throws ParseException {
        ModelAndView mav = new ModelAndView();
        int pageSize = 15;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long classTime = df.parse(date +" " +time+":00").getTime();
        Long now=System.currentTimeMillis();
        System.out.println(classTime+"----------------------"+now);
        Date datetime = new Date(classTime);
        //获取日期格式器
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //输出结果为  2017-3-22
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
        Courses courses = new Courses(course,period,studentname,parentname,teaname,dateFormat.format(datetime),dateFormat1.format(datetime),classTime);
        System.out.println("-------------doaddcourse------------"+courses);

        //对老师的学生数量进行修改
//        Long count = service.selectcount(courses.getStudentname());
        System.out.println("--------对老师的学生数量进行修改--------"+courses.getStudentname());
//        System.out.println("--------对老师的学生数量进行修改2--------"+count);
        if(service.countByExample(courses.getStudentname())!= 0 ){

        }else{
            service.updatestucount(courses.getTeaname());
        }

//        if(service.addcourse(courses)){
//           return "redirect:getcoursesbypage";
//        }else{
//            return "redirect:getcoursesbypage";
//        }
        if(service.addcourse(courses)){
            //获取当前操作的教师姓名，进行分页
            mav.addObject("Page", service.getcoursebyname(courses.getTeaname()));
            System.out.println("-------------------doaddcourse(service)------------" + service.getcoursebyname(courses.getTeaname()));
            mav.addObject("page",service.viewCourseByPage(pageIndex,pageSize));
            mav.setViewName("queryPeriod");
            return mav;
//           return "forward:getcoursesbypage";
        }
        else{
//            return "redirect:getcoursesbypage";
            mav.setViewName("/LOGIN/teacher");
            return mav;
        }
    }

    //修改课程
    @RequestMapping("/doupdatecourse")
    public String doupdatecourse(Courses courses,@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,Model model){
        System.out.println("----------++++++++++doupdatecourse++++++++++------------"+courses);
        System.out.println("----------++===++doupdatecourse++===+++------------"+courses.getTeaname());
        System.out.println("---------------------doupdatecourse---------------------"+service.updatecourse(courses));
        int pageSize = 15;
        if(service.updatecourse(courses)) {
            model.addAttribute("Page",service.getcoursebyname(courses.getTeaname()));
            model.addAttribute("page",service.viewCourseByPage(pageIndex,pageSize));
            return "queryPeriod";
        }else{
            return "redirect:index";
        }
    }

//    //修改课程
//    @RequestMapping("/doupdatecourse")
//    public String doupdatecourse(Courses courses){
//        System.out.println("----------++++++++++doupdatecourse++++++++++------------"+courses);
//        System.out.println("---------------------doupdatecourse---------------------"+service.updatecourse(courses));
//        if(service.updatecourse(courses)) {
//            return "redirect:getcoursesbypage";
//        }else{
//            return "redirect:index";
//        }
//    }
    //修改老师信息页面
    @RequestMapping("/editcourse")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public String  courseplay(@RequestParam("courseid") Integer courseid,Model model){
        Courses courses = service.getSingleCourse(courseid);
//         Date dt = service.getSingleCourse(courseid).getDate();
        model.addAttribute("course",courses);
//        model.addAttribute("dt",dt);
        return "editcourse";
    }

    //删除课程
    @RequestMapping("/deleteCourse")
    public ModelAndView dodeletecourse(@RequestParam("id") Integer id,
                                 @RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                 @RequestParam("teaname") String teaname){
        ModelAndView mav = new ModelAndView();
        int pageSize = 15;
        if(service.deleteCourse(id)){
            //获取当前操作的教师姓名，进行分页
            System.out.println("-------------------deleteCourse------------" + teaname);
            mav.addObject("Page", service.getcoursebyname(teaname));
            System.out.println("-------------------deleteCourse(service)------------" + service.getcoursebyname(teaname));

            mav.addObject("page",service.viewCourseByPage(pageIndex,pageSize));
            mav.setViewName("queryPeriod");
            return mav;
//            return "redirect:getcoursesbypage";
        }else{
            mav.setViewName("queryPeriod");
            return mav;
//            return "redirect:getcoursesbypage";
        }
    }

    //多条件查询
 @RequestMapping("/search")
    public ModelAndView  search(
                                 @RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                 @RequestParam("keywords") String keywords){
        ModelAndView mav = new ModelAndView();
        int pageSize = 15;
        Page<Courses> page = service.viewCourseByKeywords(pageIndex, pageSize, keywords);
        mav.addObject("page",page);
        mav.setViewName("queryPeriod");
        return mav;
    }

    //根据教师姓名分页查看所有预约信息
    @RequestMapping("/getordersbypage")
    public ModelAndView getOrdersByPage(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
//                                        @RequestParam(value = "teaname",required = false)String teaname
    Teacher teacher){
        ModelAndView mav = new ModelAndView();
        int pageSize = 15;
        //获取姓名为teaname的所有信息
//        System.out.println("-------------------getordersbypage------------------"+teaname);
//        mav.addObject("Page", service.getorderbyid(teaname));
        System.out.println("-------------------getordersbypage------------------"+teacher.getTeaname());
        mav.addObject("Page", service.getorderbyid(teacher.getTeaname()));
        System.out.println("-------------------getordersbypage(service)------------" + service.getorderbyid(teacher.getTeaname()));
        mav.addObject("page",service.viewOrderByPage(pageIndex,pageSize));
        mav.setViewName("order");
        return mav;
    }
    //删除（拒绝）预约
    @RequestMapping("/deleteOrder")
    public String dodeleteorder(@RequestParam(value = "studentname",required = false) String studentname,Teacher teacher){
        System.out.println("---------------deleteorder-----------"+studentname);
        if(service.deleteOrder(studentname)){
//            return "redirect:/getordersbypage";   //存在问题，待解决
            return "redirect:/LOGIN/teacher";
        }else{
            return "redirect:/getordersbypage";
        }
    }
    //接受预约
    @RequestMapping("/addOrder")
    public String doaddorder(@RequestParam(value = "studentname",required = false) String studentname,Teacher teacher){
        System.out.println("---------------addorder-----------"+studentname);
        if(service.updateOrderState(studentname)){
//            return "redirect:/getordersbypage";  //存在问题，待解决
            return "redirect:/LOGIN/teacher";
        }else{
            return "redirect:/getordersbypage";
        }
    }
    //多条件查询预约
    @RequestMapping("/search1")
    public ModelAndView  search1(
            @RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
            @RequestParam("keywords1") String keywords1){
        ModelAndView mav = new ModelAndView();
        int pageSize = 15;
        Page<Students> page = service.viewOrderByKeywords(pageIndex, pageSize, keywords1);
        mav.addObject("page",page);
        mav.setViewName("order");
        return mav;
    }

    /**
     * 根据经纬度算距离，进行判断
     * @param session
     * @param lng1
     * @param lat1
     * @return
     */
    @RequestMapping("ajaxaddress")
    @ResponseBody
    private ResponseResult doajaxaddress(HttpSession session,
                                         @RequestParam("userlng") double lng1,
                                         @RequestParam("userlat") double lat1){
        Teacher teacher = (Teacher)session.getAttribute("teacherinfo");
        double lng2 = Double.parseDouble(teacher.getLon());
        double lat2 = Double.parseDouble(teacher.getLat());
        int s = (int)getDistance(lat1, lng1,lat2,lng2);
        session.setAttribute("distance",s);
        System.out.println("--------------"+s);
        ResponseResult result;
        if(s>5000){
            result = new ResponseResult("ERROR","太远了，滚！！");
        }else{
            result = new ResponseResult("OK","亲！！等会见，哈哈哈哈哈哈哈哈哈");
        }
        return result;
    }
    private static double EARTH_RADIUS = 6378.137;//地球半径
    private static double getRadian(double d)
    {
        return d * Math.PI / 180.0;
    }
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = getRadian(lat1);
        double radLat2 = getRadian(lat2);
        double a = radLat1 - radLat2;// 两点纬度差
        double b = getRadian(lng1) - getRadian(lng2);// 两点的经度差
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        return s * 1000;
    }

    /**
     * 即时通讯
     * @return
     */
    @RequestMapping("/teacherChat")
    private String teacherChat(){
        return "teacherChat";
    }
    @RequestMapping("/chat")
    private String chatpage(){
        return "chatpage";
    }
    @RequestMapping("/chatroom")
    private ModelAndView chatr(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        httpSession.setAttribute("parentflag","true");
        Teacher teacher = (Teacher)httpSession.getAttribute("teacherinfo");
        String parentname = (String) httpSession.getAttribute("parentname");
        System.out.println("---------parentname123------------"+parentname);
        String teaname = teacher.getTeaname();
        modelAndView.addObject("parentname",parentname);
        modelAndView.addObject("teaname",teaname);
        modelAndView.setViewName("forward:chat");
        return modelAndView;
    }



}
