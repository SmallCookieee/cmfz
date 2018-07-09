package text;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import com.baizhi.cmfz.service.ShufflingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by zxl on 2018/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MenuTest {

    @Autowired
    private  MenuService ms;

    @Test
    public void fun1() {
        List<Menu> menus = ms.queryMenu();

        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }

}
