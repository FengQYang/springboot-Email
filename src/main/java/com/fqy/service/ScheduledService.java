package com.fqy.service;

import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledService {

    @Scheduled(cron = "")
    public void hello(){
        System.out.println("定时任务....");
    }
}
