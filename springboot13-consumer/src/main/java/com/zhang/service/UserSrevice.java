package com.zhang.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service //消费者放入spring
public class UserSrevice {
    //远程引用
    @Reference  //坐标或者想用路径的接口名
    TicketService tickservice;
    public void byTicket(){
        String ticket = tickservice.ticket();
        System.out.println("远程拿到一张票+"+ticket);
    }

}
