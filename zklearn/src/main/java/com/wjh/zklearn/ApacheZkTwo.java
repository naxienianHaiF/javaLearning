package com.wjh.zklearn;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author JHW
 * @date created at 2018/07/14
 */
public class ApacheZkTwo {

    private final String host = "127.0.0.1:2181";
    private ZooKeeper zooKeeper = null;

    @Before
    public void init() {
        try {
            zooKeeper = new ZooKeeper(host, 2000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(watchedEvent.getPath()+"---"+watchedEvent.getType());

                    new Watcher(){
                        @Override
                        public void process(WatchedEvent watchedEvent) {
                            System.out.println(watchedEvent.getPath()+"---"+watchedEvent.getType());
                        }
                    };
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get node
     */
    @Test
    public void getZnode() {
        try {
            List<String> list = zooKeeper.getChildren("/", true);
            list.forEach(e -> System.out.println(e));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createZnode(){
        try {
            /*
            创建节点的路劲，节点的数据，节点的权限，节点的类型
             */
            String result = zooKeeper.create("/idea", "create".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteZnode() {
        try {
            String path = "/idea";
            //version为-1的时候，表示删除所有的版本
            zooKeeper.delete(path, -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void existZnode() {
        try {
            Stat stat = zooKeeper.exists("/idea" ,true);
            if (stat == null){
                System.out.println("is not exists...");
            } else {
                System.out.println("is exists...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateZnode() {

        try {
            Stat stat = zooKeeper.setData("/idea", "hellozk".getBytes(), -1);
            if (stat == null) {
                System.out.println("update date is failed...");
            } else {
                System.out.println("update date is success...");
            }
            byte[] data = zooKeeper.getData("/idea", false ,null);
            System.out.println(new String(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
