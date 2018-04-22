package com.wjh.learn.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

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

    /*
    连接池测试
     */
    @Test
    public void jedisPoolTest(){
        //连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(10);
        //设置最大空闲连接数
        config.setMaxIdle(5);

        //获取连接池
        JedisPool pool = new JedisPool(config,"192.168.3.173",6379);

        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            System.out.println(jedis.ping());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
            if (pool != null){
                pool.close();
            }
        }
    }
}
