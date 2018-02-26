package TimerTask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @classDesc： 功能描述：（）
 * @author：王武
 * @createTime 2018/1/21
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class Demo2 {
    static long count = 0;
    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
              count++;
                System.out.println(count);
            }
        };
        Timer timer = new Timer();
        //天数
        long delay =0;
        //秒数
        long period =1000;
        timer.scheduleAtFixedRate(timerTask,delay,period);
    }
}
