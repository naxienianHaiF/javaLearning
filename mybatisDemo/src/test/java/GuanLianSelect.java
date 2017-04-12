import com.wjh.dao.ClassesDao;
import com.wjh.dao.OnetoManyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by WJH on 2017年03月31日 14:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring.xml")
public class GuanLianSelect {
    @Autowired
    private ClassesDao classesDao;

    /**
     * 一对一查询
     */
    @Test
    public void test1(){
        if (classesDao != null) {
            System.out.println(11111111);
            System.out.println("查询成功了！ "+classesDao.getClasses("3(6)班"));
            System.out.println("查询成功了！ "+classesDao.getClasses2("3(6)班"));
        }
    }

    @Autowired
    private OnetoManyDao onetoManyDao;
    @Test
    public void test2(){
        if (onetoManyDao!=null){
            System.out.println(2222222);
            System.out.println("方法一："+onetoManyDao.getGrade("3(6)班"));
            System.out.println("方法二："+onetoManyDao.getGrade2("3(6)班"));
            System.out.println(onetoManyDao.getStudent("3(6)班"));
        }
    }
}
