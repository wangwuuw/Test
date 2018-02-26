package BasicThread;

/**
 * @classDesc： 功能描述：（interuppt停止线程）
 * @author：王武
 * @createTime 2018/1/21
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
class StopThread extends Thread{
    public boolean flag =true;
    @Override
    public synchronized void run() {
        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                stopThread();

            }
            System.out.println(Thread.currentThread().getName()+"----子线程----");
        }
    }
    public void stopThread(){
        flag = false;
        System.out.println("线程被停止了----");
    }
}
public class TestThreadStop {
    public static void main(String[] args) {
        StopThread threadStop1 = new StopThread();
        StopThread threadStop2 = new StopThread();
        threadStop1.start();
        threadStop2.start();
        for (int i = 1; i <30 ; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            System.out.println(Thread.currentThread().getName()+"---主线程"+i);
            if (i==29){
                threadStop1.interrupt();
                threadStop2.interrupt();
            }
        }
    }
}
