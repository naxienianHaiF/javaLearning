import com.wjh.dao.UserDao;
import com.wjh.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by WJH on 2017年03月29日 21:15
 * 注解找不到的解决方案 http://blog.csdn.net/milliemeter/article/details/50945302
 */
public class TestMybatis {

    @Test
    public void test1(){
        Reader reader= null;
        try {
            reader = Resources.getResourceAsReader("config.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            String state="com.wjh.dao.UserDao.getUser";
            User user;
            user = (User)session.selectOne(state,1);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    接口方式编程
     */
    @Test
    public void test2() {
        Reader reader = null;
        try {
            //使用classpath:config.xml报错
            reader = Resources.getResourceAsReader("config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            UserDao userDao = session.getMapper(UserDao.class);
            User user = userDao.getUser(1);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            long start=System.currentTimeMillis();
            UserDao userDao = session.getMapper(UserDao.class);
            User user=new User(2,"xtu",60);
            System.out.println("插入："+userDao.addUser(user));
            long end=System.currentTimeMillis();
            System.out.println("花费了："+(end-start));
            List<User> list = userDao.getAll();
            for (User user1 : list) {
                System.out.println(user1);
            }
            System.out.println("删除："+userDao.deleteUser(2));
            session.commit();
            List<User> list1 = userDao.getAll();
            for (User user1 : list1) {
                System.out.println(user1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
