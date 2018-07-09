package text;

import com.baizhi.cmfz.entity.Shuffling;
import com.baizhi.cmfz.service.ShufflingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

/**
 * Created by zxl on 2018/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PicTest {

    @Autowired
    private ShufflingService ss;
    @Test
    public void showAllPicTest(){
        System.out.println(ss.queryAllPic(1,5));
    }

    @Test
    public void showPicById(){
        System.out.println(ss.queryPicById("de7efdae-8056-11e8-b20e-507b9d13ef75"));
    }

    @Test
    public void insertPicTest(){
        Shuffling shuffling = new Shuffling();
        shuffling.setId(UUID.randomUUID().toString().replace("-",""));
        shuffling.setPath("asdasda");
        shuffling.setDescription("asdasdasdas");
        shuffling.setDate(new Date());
        shuffling.setStatus("未展示");
        int result = ss.addPic(shuffling);
        if(result>0){
            System.out.println(shuffling);
        }else{
            System.out.println("插入失败");
        }
    }

}
