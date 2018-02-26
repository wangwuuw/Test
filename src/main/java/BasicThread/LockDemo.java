package BasicThread;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Res{
    public String name;
    public String sex;
    public boolean flag = true;//为true代表没有写入
    public Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
}

/**
* classDesc: 功能描述：(A写入线程)
* @Author: 王武
* @Date:11:40 2018/1/19
* @version: v1.0
* @copyright:上海苹果教育科技有限公司
*
*/
class AThread extends Thread{
    public Res res;
    public AThread(Res res){
        this.res=res;
    }
    @Override
    public void run() {
        int count=0;
        while (true){
            try {
                res.lock.lock();

                if (res.flag) {
                    if (count == 0) {
                        res.name = "王武";
                        res.sex = "男";
                    } else {
                        res.name = "檀琳凤";
                        res.sex = "女";
                    }

                        res.condition.await();
                        count = (count + 1) % 2;
                        res.flag=false;
                }
                        res.condition.signal();




            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }


                }
            }
}

/**
* classDesc: 功能描述：(B线程读取)
* @Author: 王武
* @Date:11:42 2018/1/19
* @version: v1.0
* @copyright:上海苹果教育科技有限公司
*
*/
class BThread extends Thread{
    public Res res;
    public BThread(Res res){
        this.res=res;
    }
    @Override
    public void run() {
        int count=0;
        while (true){


            try {
                res.lock.lock();
                if (!res.flag) {
                    System.out.println(res.name + "----" + res.sex);
                    try{
                        res.condition.await();
                    }catch (Exception e){

                    }

                }
                res.flag=true;
                res.condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                res.lock.unlock();
            }





        }

    }
}

/**
 * @classDesc： 功能描述：（A线程写，B线程读）
 * @author：王武
 * @createTime 2018/1/19
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class LockDemo {
    public static void main(String[] args) {
        Res res = new Res();
        BThread bThread = new BThread(res);
        AThread aThread = new AThread(res);

        aThread.start();
        bThread.start();

    }

}
