package thread;

import org.junit.Test;

import com.hundsun.thread.BizThread;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/8/21 16:52
 */
public class BizThreadTest {

    @Test
    public void test1() {
//        Logger logger = LoggerFactory.getLogger(BizThread.class);

//        logger.info("开启10个线程");
        System.out.println("开启10个线程");
        BizThread bizThread = new BizThread("张三");

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(bizThread);

            thread.start();
        }
//        logger.info("结束10个线程");
        System.out.println("结束10个线程");



    }
}
