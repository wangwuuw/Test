package BasicThread;

/**
 * 线程分两种,守护线程和用户线程
 * @classDesc： 功能描述：（守护线程）
 * @author：王武
 * @createTime 2018/1/21
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class TestThreadDeamon {
    public static void main(String[] args) {
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 300; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是守护线程t1 哈哈哈" + i);
                }
            }
        });
        t1.setDaemon(true);
        t1.start();
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 3; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是子线程t2 哈哈哈" + i);
                }
            }
        });


        t2.start();
        for (int i = 1; i < 3; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是主线程 哈哈哈"+i);

        }
        System.out.println("我是主线程-------------------------------------- 我死啦");
    }

}
