package com.zhang.service.impl;

import com.zhang.service.TicketService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service // dubbo的注解
@Component //使用了dubbo尽量不要使用service注解
public class TicketServiceImpl implements TicketService {

    @Override
    public String ticket() {
        return "好好学java";
    }
}
