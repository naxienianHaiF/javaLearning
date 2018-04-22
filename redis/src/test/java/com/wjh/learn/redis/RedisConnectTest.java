package com.wjh.learn.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author JHW
 * @date created at 2018/04/22
 */
public class RedisConnectTest {

    @Test
    public void localhostTest(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
//        jedis.connect();

        jedis.set("name","redis");
        System.out.println(jedis.get("name"));

        jedis.close();
    }

    /*
    使用ifconfig查看的ip地址
     */
    @Test
    public void connectTest(){
        Jedis jedis = new Jedis("192.168.3.173",6379);

        jedis.set("name","redis");
        System.out.println(jedis.get("name"));

        jedis.close();
    }
}
