package Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @classDesc： 功能描述：（）
 * @author：王武
 * @createTime 2018/1/14
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class ScheduleThreadPool {
     public static void main(String[] args){
         ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
         for (int i = 0; i < 10; i++) {
             int index = i;
             scheduledExecutorService.schedule(new Runnable() {
                 @Override
                 public void run() {
                     System.out.println(Thread.currentThread().getName()+"----"+index);
                 }
             },3, TimeUnit.DAYS);
         }


     }


}
