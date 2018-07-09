package text;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Created by zxl on 2018/7/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GuruTest {
    @Autowired
    private GuruService gs;

    @Test
    public void insertGuru(){
//        Guru guru = new Guru();
//        guru.setId(UUID.randomUUID().toString().replace("-",""));
//        guru.setName("按时大苏打");
//        guru.setPhoto("1");
//        guru.setSummary("asdasfas");
//        int result = gs.addGuru(guru);
//        if(result>0){
//            System.out.println(guru);
//        }else{
//            System.out.println(false);
//        }
    }

    @Test
    public void showByName(){
        //System.out.println(gs.queryGuruByName("空",1,5));
        System.out.println(gs.queryAllGuru(1,5));
    }
}
