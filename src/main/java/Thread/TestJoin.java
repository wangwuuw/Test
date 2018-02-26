package Thread;

/**
* classDesc: 功能描述：(测试Join方法)
* @Author: 王武
* @Date:16:10 2018/2/11
* @version: v1.0
* @copyright:上海江豚教育科技有限公司
* @QQ:834667820
*/
public class TestJoin {

     public static void main(String[] args) throws InterruptedException {
         Thread t1 = new Thread( new Runnable(){

             @Override
             public void run() {


                 for (int i = 0; i <30 ; i++) {
                     try {
                         Thread.sleep(30);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println(Thread.currentThread().getName()+"-----"+i);
                 }
             }
         },"t1");
         t1.start();

         Thread t2 = new Thread( new Runnable(){

             @Override
             public void run() {

                 try {
                     t1.join();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 for (int i = 0; i <30; i++) {
                     try {
                         Thread.sleep(30);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println(Thread.currentThread().getName()+"-----"+i);
                 }
             }
         },"t2");

         t2.start();

         Thread t3 = new Thread( new Runnable(){

             @Override
             public void run() {
                 try {
                     t2.join();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 for (int i = 0; i <30; i++) {
                     try {
                         Thread.sleep(30);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println(Thread.currentThread().getName()+"-----"+i);
                 }
             }
         },"t3");

         t3.start();

      }


}
