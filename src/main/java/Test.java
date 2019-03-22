public class Test implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Test test = new Test();
        String s = "3";
        System.out.println("00000000000000000".length());
    }
}
