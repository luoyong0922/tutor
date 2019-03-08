package com.etc.springcrontask;

import com.etc.entity.Courses;
import com.etc.message.SMS;
import com.etc.service.ParentsService;
import com.etc.service.StudentsService;
import com.etc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.text.SimpleDateFormat;
import java.util.*;

import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.context.annotation.Lazy;
        import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
        import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.support.CronTrigger;
        import org.springframework.stereotype.Component;

import javax.servlet.http.*;

/**
 * Spring动态周期定时任务<br>
 * 在不停应用的情况下更改任务执行周期
 * @Author 许亮
 * @Create 2016-11-10 16:31:29
 */
@Lazy(false)
@Component
@EnableScheduling
public class SpringDynamicCronTask implements SchedulingConfigurer {
    @Autowired
    ParentsService parentsService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentsService studentsService;
    private static final Logger logger = LoggerFactory.getLogger(SpringDynamicCronTask.class);
    private static String cron;
    List<Long> longList = new ArrayList<>();

    private void getdate(){
        longList.clear();
        List<Courses> courses = teacherService.getcourse();
        for (Courses course:courses){
            this.longList.add(course.getDatetime());
        }
    }

    public SpringDynamicCronTask() {
        cron = "0/5 * * * * ?";

        // 开启新线程模拟外部更改了任务执行周期
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(15 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                cron = "0/5 * * * * ?";
                System.err.println("cron change to: " + cron);
            }
        }).start();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 任务逻辑
                System.out.println("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦");
                getdate();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String now1 = df.format(new Date());// new Date()为获取当前系统时间
                Long now=System.currentTimeMillis();
                for (int i=0;i<longList.size();i++){
                    //System.out.println("-----------------------"+longList.get(i));
                    Long coursetime = longList.get(i);
                    Long upmessageTime = now+40*60*1000-5000;
                    Long downmessageTime = now+40*60*1000+5000;
                    System.out.println(upmessageTime+"_____________________"+longList.get(i)+"----------------"+downmessageTime+"+++++++++++++"+longList.size());

                    if (upmessageTime<coursetime && coursetime<downmessageTime){
                        System.out.println("________________________________________________"+"success");
                        Courses course = teacherService.getusername(longList.get(i)).get(0);
                        String teachername = course.getTeaname();
                        String studentname = course.getStudentname();
                        String teacherPhone = teacherService.getteaphonebyname(teachername);
                        String studentPhone = studentsService.getstuphonebyname(studentname);
                        String teachercontent =teachername+"先生，您于"+now1+"，40分钟后，为"+studentname+"同学上课，千万不要迟到哦！！";
                        String studentcontent =studentname+"同学，您在"+now1+"的40分钟后，"+teachername+"老师，将来为您上课。";
                        SMS.message(teacherPhone,teachercontent);
                        SMS.message(studentPhone,studentcontent);


                    }
                }



                logger.debug("dynamicCronTask is running...");
                //System.out.println("dynamicCronTask is running..12."+t1);
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 任务触发，可修改任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        });
    }
}
