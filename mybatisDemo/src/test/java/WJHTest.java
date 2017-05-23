import com.wjh.dao.WJHDao;
import com.wjh.entity.WJH;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by WJH on 2017年05月15日 19:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring.xml")
public class WJHTest {

    @Autowired
    private WJHDao wJHDao;

    @Test
    public void wjhTest(){
        if (wJHDao!=null){
            System.out.println("not null");
        }
        WJH wjh=new WJH();
        for (int j=0;j<10;j++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                wjh.setWname(Integer.toString(i));
                wjh.setWp(Integer.toString(i));
                wJHDao.addWJH(wjh);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }

}
