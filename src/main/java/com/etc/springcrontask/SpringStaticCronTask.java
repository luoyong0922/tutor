package com.etc.springcrontask;/*
package com.etc.springcrontask;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.context.annotation.Lazy;
        import org.springframework.scheduling.annotation.Scheduled;
        import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

*/
/**
 * Spring静态周期定时任务
 * @Author Alax
 * @Create 2016-11-10 16:31:29
 *//*


@Component
@EnableScheduling
public class SpringStaticCronTask {
    private static final Logger logger = LoggerFactory.getLogger(SpringStaticCronTask.class);

    //@Scheduled(cron="* * * * * ?")
    public void staticCronTask() {
        logger.debug("staticCronTask is running...");
        System.out.println("staticCronTask is running...1");
    }

}
*/
