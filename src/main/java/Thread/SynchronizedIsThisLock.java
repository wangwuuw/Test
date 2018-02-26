package Thread;

/**
 * @classDesc： 功能描述：（完美的解释了同步函数用的是this函数,如果用ob,第二个执行的函数会很快执行sale,如果是this就要等10秒）
 * @author：王武
 * @createTime 2018/2/15
 * @verson: v1.0
 * @copyright: 上海江豚教育科技有限公司
 * @qq:834667820
 */
public class SynchronizedIsThisLock implements Runnable{
    private Object ob = new Object();
    static int num= 1;
    @Override
    public void run() {
        num++;

        System.out.println("线程"+Thread.currentThread().getName());
        if (num==2) {
            synchronized (this) {
                System.out.println("线程"+Thread.currentThread().getName()+"开始运行");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程"+Thread.currentThread().getName()+"结束运行");
            }
        }
        sale();



    }
    public synchronized void sale(){
        System.out.println("线程"+Thread.currentThread().getName()+"进来了");
    }

    public static void main(String[] args) {
        SynchronizedIsThisLock synchronizedIsThisLock = new SynchronizedIsThisLock();
        Thread t1= new Thread(synchronizedIsThisLock);
        Thread t2= new Thread(synchronizedIsThisLock);
        t1.start();
        t2.start();
    }
}
