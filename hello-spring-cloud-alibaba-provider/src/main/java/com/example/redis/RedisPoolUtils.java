package com.example.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description: RedisPoolUtils 连接池
 * @date: 2019/8/30 17:04
 * @author: 林宗雄
 * @version: 1.0
 */
public class RedisPoolUtils {

    private static JedisPool pool;

    static {
        //连接池配置信息
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(5);//设置最大连接数，默认为8
        poolConfig.setMaxIdle(1);//设置最大空闲数，默认为8
        //...

        String host = "192.168.42.128";
        int port = 6379;
        pool = new JedisPool(poolConfig,host,port);
    }

    public static Jedis getJedis(){
        Jedis jedis = pool.getResource();
        return jedis;
    }

    /**
     * 关闭连接
     * @param jedis
     */
    public static void close(Jedis jedis){
        jedis.close();
    }

}
