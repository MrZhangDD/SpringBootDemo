package com.zhang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

@RestController
public class RedisController {
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;
    /**
     * 加锁
     * jedis Redis客户端
     * lockKey  锁
     * requestId 请求标识
     * expireTime  超期时间
     */

    @RequestMapping("/redis")
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey,
                                                String requestId, int expireTime){
        SetParams setParams = new SetParams();
        System.out.println(setParams);
        setParams.nx();
        setParams.px(expireTime);
        String set = jedis.set(lockKey, requestId, setParams);
        System.out.println(set);
        if(LOCK_SUCCESS.equals(set)){
            return true;
        }
        return false;
    }
    @RequestMapping("/r")
    public String test1(){
        System.out.println("RequestMapping");
        Jedis jedis = new Jedis();
        //tryGetDistributedLock(jedis,"RequestMapping","1111",10);
        releaseDistributedLock(jedis,"RequestMapping","1111");
        return "RequestMapping";
    }

    /**
     * 解锁
     * LCU模式
     *
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {
        String script = "if jedis.call('get', KEYS[1]) == ARGV[1] " +
                "then return jedis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

}
