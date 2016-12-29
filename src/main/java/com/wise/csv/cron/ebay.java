package com.wise.csv.cron;

import com.wise.cfg.ThrdCfg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * Project : demo
 * Package : com.wise.test
 * FileName : test
 * Date : 16. 12. 23
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@PropertySource(value = "classpath:application.properties")
@Service
public class ebay {

    private Logger log = LoggerFactory.getLogger(ebay.class);

    private static Environment environment;

    @Scheduled(cron = "*/30 * * * * *")
    public void apiRequest() throws Exception {

        //Ready to use ThreadPool
        ApplicationContext context = new AnnotationConfigApplicationContext(ThrdCfg.class);
        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context.getBean("taskExecutor");

        //TODO 스토어 테이블 불러오는 작업

        //TODO for문 수정 필요
        int cnt = 0;
        for(int i = 0; i < 20; i++){//임시 for 문
            String mbrNo = "1019";
            String mbrSto = "123123";

            ThrdRun run = (ThrdRun) context.getBean("thrdRun");
            run.setName("Thread "+(cnt++));
            run.setMbrNo(mbrNo);
            run.setMbrSto(mbrSto);
            taskExecutor.execute(run);
        }

        //액티브 쓰레드 확인작업후 쓰레드 없으며 셧다운
        for (;;) {
            int count = taskExecutor.getActiveCount();
            System.out.println("Active Threads : " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 0) {
                taskExecutor.shutdown();
                break;
            }
        }
    }
}