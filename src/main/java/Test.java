public class Test implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Test test = new Test();
//        test.start();
//        Thread t1 = new Thread(test);
//        t1.start();
//        Thread t2 = new Thread(test);
//        t2.start();
    }
}
