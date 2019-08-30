package com.example.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @description: 测试jedis与redis
 * @date: 2019/8/30 16:12
 * @author: 林宗雄
 * @version: 1.0
 */
public class RedisDemo {
    String host = "192.168.42.128";
    int port = 6379;

    /**
     * Redis中的命令和jedis中的方法对应
     */
    @Test
    public void test1(){
        Jedis jedis = new Jedis(host,port);
        jedis.set("testKey","testValue");
        System.out.println(jedis.get("testKey"));
    }
}
