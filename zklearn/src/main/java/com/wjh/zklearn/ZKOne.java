package com.wjh.zklearn;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @author JHW
 * @date created at 2018/06/19
 * https://www.cnblogs.com/ggjucheng/p/3370359.html
 */
public class ZKOne {
    private static final String HOST = "127.0.0.1" + ":"+2181;

    public static void main(String[] args) {
        try {
            ZooKeeper zk = new ZooKeeper(HOST, 5000, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("已经触发了 "+ watchedEvent.getType()+" 事件！");
                }
            });
            Stat stat = zk.exists("/testpath", false);
            System.out.println(stat.toString());

            if (stat == null){
                zk.create("/testpath","testpath".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            } else {
                System.out.println("not null");
            }

            getChild("/",zk);
            System.out.println("===============");
            getACLTest("/",zk);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getChild(String path,ZooKeeper zk){
        try {
            List<String> list = zk.getChildren(path, false);
            for (String string : list){
                String res = new String(zk.getData(path+string,false,zk.exists(path+string,false)));
                System.out.println(string+","+res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getACLTest(String path,ZooKeeper zk) throws Exception{
        List<ACL> list = zk.getACL(path, zk.exists(path,false));

        list.forEach(e -> {
            System.out.println("ACL******"+e.toString());
        });
    }
}
