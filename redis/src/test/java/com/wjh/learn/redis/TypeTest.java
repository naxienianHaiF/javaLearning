package com.wjh.learn.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;
import java.util.Set;

/**
 * @author JHW
 * @date created at 2018/04/22
 */
public class TypeTest {
    private JedisPoolConfig config = null;
    private JedisPool pool = null;
    private Jedis jedis = null;

    @Before
    public void init(){
        config= new JedisPoolConfig();
        config.setMaxTotal(10);
        config.setMaxIdle(5);

        pool = new JedisPool(config,"192.168.3.173",6379);
        System.out.println("init ...");
    }

    /**
     * String 类型
     */
    @Test
    public void testString(){
        jedis = pool.getResource();

        jedis.set("string","test");
        System.out.println(jedis.get("string"));


    }

    @Test
    public void testSet(){
        jedis = pool.getResource();

        jedis.sadd("myset","china","hubei","hg");
        Set<String> set = jedis.smembers("myset");

        set.forEach( e -> System.out.println(e));
    }

    @Test
    public void testHash(){
        jedis = pool.getResource();

        jedis.hset("myhash","test","test");
        Map<String, String> map = jedis.hgetAll("myhash");
        map.forEach((e,v) -> System.out.println(e+","+v));

    }

    @After
    public void destory(){
        if (jedis != null){
            jedis.close();
        }
        if (pool != null){
            pool.close();
        }
        System.out.println("destory ...");
    }
}
