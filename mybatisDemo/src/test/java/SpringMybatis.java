import com.wjh.dao.ClassesDao;
import com.wjh.dao.UserDao;
import com.wjh.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by WJH on 2017年03月30日 19:41
 *  spring和mybatis的整合
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring.xml")
public class SpringMybatis {
    @Resource(name = "userDao")           //@Autowired
    private UserDao userDao;

    @Test
    public void test1(){
        if (userDao!=null){
            System.out.println(1);
            System.out.println("删除成功："+userDao.deleteUser(2));
            User user=new User(2,"xtu",60);
            System.out.println("插入成功："+userDao.addUser(user));
            System.out.println(userDao.getUser(2));
        }
    }

    @Test
    public void test2(){
        if (userDao != null) {
            System.out.println("多参数");
            System.out.println(userDao.getUserByParameter(1,"wjh"));
        }
    }

    @Test
    public void test3(){
        if (userDao!=null){
            System.out.println("多参数传递之注解方式示");
            System.out.println(userDao.getUserByParameterAnnotation(1,"wjh"));
        }
    }
}
