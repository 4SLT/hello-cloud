package com.example.redis;

import redis.clients.jedis.Jedis;

/**
 * @description: 通过jedis操作redis服务器
 * @date: 2019/8/30 15:57
 * @author: 林宗雄
 * @version: 1.0
 */
public class RedisDemo {
    /**
     * 测试数据库是否连接
     *
     * @param args
     */
    public static void main(String[] args) {
        //从连接池获取一个连接
        Jedis jedis = RedisPoolUtils.getJedis();
        System.out.println(jedis.ping());

        //将获取的连接断开
        RedisPoolUtils.close(jedis);
    }

    /**
     * Redis String作用：为了减轻MySQL的访问压力：判断key是否存在于Redis，存在就直接查询；
     * 如果不存在就从MySQL中查询并存入Redis
     */
    public void test() {
        String host = "192.168.42.128";
        int port = 6379;
        Jedis jedis = new Jedis(host, port);

        String key = "applicationName";
        if (jedis.exists(key)) {
            String result = jedis.get(key);
            System.out.println("redis中的applicationName" + result);
        } else {
            //从数据库中查询
            String result = "UCAR";
            System.out.println("从MySQL中查询applicationName" + result);
            jedis.set(key, result);
        }
    }

}
