package com.scheduler.job;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.LockAssert;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyScheduler {

    @Scheduled(fixedDelay = 1000)
    @SchedulerLock(name = "scheduledTaskName1" ,lockAtMostFor = "5m" ,lockAtLeastFor = "1s")
    public void myJob() throws InterruptedException {
        LockAssert.assertLocked();

        long round = Math.round(Math.random() * 100);
        log.info("###### Job starting {} tasks ###### ", round);

        for (int i = 0; i < round; i++){
            long wait = Math.round(Math.random() * 100);
            log.info("processing time "+ wait);
            Thread.sleep(wait);
        }
    }
}
