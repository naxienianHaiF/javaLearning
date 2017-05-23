import com.wjh.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

/**
 * Created by WJH on 2017年05月14日 18:32
 */

public class UserTest {

    private SessionFactory factory;
    private Session session;
//    @Before
//    public void init(){
//        Configuration cfg=new Configuration().configure();
//        factory=cfg.buildSessionFactory();
//        session=factory.openSession();
//        session.beginTransaction();
//    }
//    @After
//    public void destory(){
////        session.getTransaction().commit();
//        if (session!=null){
//            session.close();
//        }
//        if (factory != null) {
//            factory.close();
//        }
//    }
    @Test
    public void testAdd(){
        Configuration cfg=new Configuration().configure();
        factory=cfg.buildSessionFactory();
//        session.beginTransaction();
        User user=new User();
        for (int j=0;j<10;j++){
            System.out.println("j="+j);
            long start=System.currentTimeMillis();
            for(int i=0;i<1000;i++){
                session=factory.openSession();
                session.beginTransaction();
                user.setName(Integer.toString(i));
                user.setPassword(Integer.toString(i));
                //TODO 代码还有问题，未能正确提交到数据库中
                session.save(user);
                session.flush();
                session.clear();
                session.getTransaction().commit();
                session.close();
            }
            long end=System.currentTimeMillis();
            System.out.println(end-start);
        }

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
