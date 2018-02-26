package Thread;

/**
 * @classDesc： 功能描述：（模拟多线程死锁）
 * @author：王武
 * @createTime 2018/2/15
 * @verson: v1.0
 * @copyright: 上海江豚教育科技有限公司
 * @qq:834667820
 */
public class ThreadDeadLock implements Runnable{
    private Object ob = new Object();
    static int num= 1;
    @Override
    public void run() {
        num++;
        if (num==2) {
            synchronized (ob) {
                System.out.println(Thread.currentThread().getName()+"拿到ob锁");
                sale();
            }
        }
        sale();



    }
    public synchronized void sale(){
        System.out.println(Thread.currentThread().getName()+"拿到this锁");
        synchronized (ob){
            System.out.println(Thread.currentThread().getName()+"拿到ob锁");
        }
    }

    public static void main(String[] args) {
        ThreadDeadLock threadDeadLock = new ThreadDeadLock();
        Thread t1= new Thread(threadDeadLock);
        Thread t2= new Thread(threadDeadLock);
        t1.start();
        t2.start();
    }
}
