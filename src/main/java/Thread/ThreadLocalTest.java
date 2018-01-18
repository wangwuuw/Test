package Thread;

/**
 * @classDesc： 功能描述：（ThreadLocal保证每个线程不共享变量）
 * @author：王武
 * @createTime 2018/1/13
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
class Res {
    private ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            //设置当前线程局部变量初始值
            return 0;
        }
    };

    public Integer getNum(){
        int count = this.count.get() + 1;
        this.count.set(count);
        return count;
    }
}

class ThreadLocalDemo extends Thread {
    public Res res;

    public ThreadLocalDemo(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(getName() + "----" + i + "----count:" + res.getNum());
        }
    }
}

public class ThreadLocalTest {
    public static void main(String[] args) {

        Res res = new Res();
        ThreadLocalDemo t1 = new ThreadLocalDemo(res);
        ThreadLocalDemo t2 = new ThreadLocalDemo(res);
        ThreadLocalDemo t3 = new ThreadLocalDemo(res);
        t1.start();
        t2.start();
        t3.start();
    }
}
