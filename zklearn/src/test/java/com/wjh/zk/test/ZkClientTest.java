package com.wjh.zk.test;

import org.I0Itec.zkclient.ZkClient;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @author JHW
 * @date created at 2018/07/14
 */
public class ZkClientTest {

    private final String host = "127.0.0.1";
    private final String port = "2181";
    private ZkClient client = null;

    @BeforeClass
    public static void beforeclass() {
        System.out.println("===beforeclass===");
    }
    @Before
    public void init(){
        System.out.println("===before===");
        client = new ZkClient(host+":"+port, 1000);
    }

    @Test
    public void createNodeTest() {
        List<String> list = client.getChildren("/");
        list.forEach(e -> System.out.println(e));

    }

}
