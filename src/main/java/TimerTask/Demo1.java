package TimerTask;

/**
 * @classDesc： 功能描述：（Thread方式实现定时任务）
 * @author：王武
 * @createTime 2018/1/21
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class Demo1 {
    static long count = 0;
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    while(true) {
                        Thread.sleep(1000);
                        count++;
                        System.out.println(count);
                    }
                } catch (InterruptedException e) {

                }
            }
        });
        t.start();
    }
}
