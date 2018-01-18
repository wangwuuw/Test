package Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @classDesc： 功能描述：（AtomicInteger实现共享变量原子性）
 * @author：王武
 * @createTime 2018/1/13
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class TestAtomicInteger extends Thread{
    private static AtomicInteger count = new AtomicInteger();
    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            count.incrementAndGet();
        }
        System.out.println(getName()+"-----"+count);
    }
     public static void main(String[] args){
         TestAtomicInteger[] atomicInteger = new TestAtomicInteger[10];
         for (int i = 0; i < atomicInteger.length; i++) {
             atomicInteger[i] = new TestAtomicInteger();
             atomicInteger[i].start();
         }

      }
}
