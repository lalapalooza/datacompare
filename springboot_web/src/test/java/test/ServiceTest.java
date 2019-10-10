package test;

import com.clinbrain.datac.SpringbootStart;
import com.clinbrain.datac.service.TableStatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Liaopan on 2019/8/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootStart.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTest {

    @Autowired
    private TableStatusService tableStatusService;

    @Test
    public void test() {
        System.out.println(tableStatusService.mainDashboard());
    }
}
