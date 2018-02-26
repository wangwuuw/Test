package TimerTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @classDesc： 功能描述：（线程池实现定时任务）
 * @author：王武
 * @createTime 2018/1/21
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class Demo3 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                // task to run goes here
                System.out.println("Hello !!");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
    }


}