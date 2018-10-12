public class Test implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("版本5。0");
    }
}
