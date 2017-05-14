import com.wjh.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by WJH on 2017年05月14日 18:32
 */

public class UserTest {

    private SessionFactory factory;
    private Session session;
    @Before
    public void init(){
        Configuration cfg=new Configuration().configure();
        factory=cfg.buildSessionFactory();
        session=factory.openSession();
        session.beginTransaction();
    }
    @After
    public void destory(){
        session.getTransaction().commit();
        if (session!=null){
            session.close();
        }
        if (factory != null) {
            factory.close();
        }
    }
    @Test
    public void testAdd(){
        User user=new User();
        user.setName("wjh");
        user.setPassword("wjh");
        session.save(user);
    }
    @Test
    public void testDelete1(){
        User user=(User)session.load(User.class,1);
        session.delete(user);
    }
    @Test
    public void testSelect(){
        Query query=session.createQuery("from User ");
        List<User> list=query.list();
        for(User u:list){
            System.out.println(u);
        }
    }
    @Test
    public void testSelectByPara(){
        User user=session.load(User.class,2);
        System.out.println(user);
    }
    @Test
    public void testUpdate(){
        User user=session.load(User.class,3);
        user.setName("update");
        session.update(user);
    }
}
