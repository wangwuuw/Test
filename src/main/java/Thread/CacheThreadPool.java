package Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @classDesc： 功能描述：（测试缓存线程池）
 * @author：王武
 * @createTime 2018/1/14
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class CacheThreadPool {
     public static void main(String[] args){
         ExecutorService executorService = Executors.newCachedThreadPool();
         for (int i = 0; i < 30; i++) {
             int index= i;
             executorService.execute(new Runnable() {
                 @Override
                 public void run() {
                     System.out.println(Thread.currentThread().getName()+"----"+index);
                 }
             });
         }


     }


}
