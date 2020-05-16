package com.zhang.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    /**
     * 秒 分 时 日 月 周几
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void scheduled(){
        System.out.println("hello,定时执行了");
    }
}
