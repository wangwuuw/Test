package Thread;

/**
* classDesc: 功能描述：(测试Join方法)
* @Author: 王武
* @Date:16:31 2018/1/12
* @version: v1.0
* @copyright:上海苹果教育科技有限公司
*
*/
public class TestJoin {

     public static void main(String[] args) throws InterruptedException {
         Thread t1 = new Thread( new Runnable(){

             @Override
             public void run() {
                 for (int i = 0; i <30 ; i++) {
                     System.out.println(Thread.currentThread().getName()+"-----"+i);
                 }
             }
         },"t1");
         t1.start();
         t1.join();
         Thread t2 = new Thread( new Runnable(){

             @Override
             public void run() {
                 for (int i = 0; i <30 ; i++) {
                     System.out.println(Thread.currentThread().getName()+"-----"+i);
                 }
             }
         },"t2");
         t2.start();
         t2.join();
         Thread t3 = new Thread( new Runnable(){

             @Override
             public void run() {
                 for (int i = 0; i <30 ; i++) {
                     System.out.println(Thread.currentThread().getName()+"-----"+i);
                 }
             }
         },"t3");
         t3.start();
         t3.join();

      }


}
