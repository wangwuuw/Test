//package BasicThread;
//
//class Res{
//    public String name;
//    public String sex;
//    public boolean flag = false;//为true代表没有写入
//}
///**
//* classDesc: 功能描述：(A写入线程)
//* @Author: 王武
//* @Date:11:40 2018/1/19
//* @version: v1.0
//* @copyright:上海苹果教育科技有限公司
//*
//*/
//class AThread extends Thread{
//    public Res res;
//    public AThread(Res res){
//        this.res=res;
//    }
//    @Override
//    public void run() {
//        int count=0;
//        while (true){
//            synchronized (res) {
//                if (!res.flag) {
//                    try {
//                        res.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                if (res.flag) { //为true代表没写入
//                    if (count == 0) {
//                        res.name = "王武";
//                        res.sex = "男";
//                    } else {
//                        res.name = "檀琳凤";
//                        res.sex = "女";
//                    }
//                    count = (count + 1) % 2;
//                }
//                res.flag=false;
//                String s = new String();
////                res.notify();
//            }
//        }
//    }
//}
///**
//* classDesc: 功能描述：(B线程读取)
//* @Author: 王武
//* @Date:11:42 2018/1/19
//* @version: v1.0
//* @copyright:上海苹果教育科技有限公司
//*
//*/
//class BThread extends Thread{
//    public Res res;
//    public BThread(Res res){
//        this.res=res;
//    }
//    @Override
//    public void run() {
//        int count=0;
//        while (true){
//            synchronized (res) {
//                if (res.flag) {
//                    try {
//                        res.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                if (!res.flag) {//为false代表已经写入，就读取
//                    System.out.println(res.name + "----" + res.sex);
//                }
//                res.flag=true;
////                res.notify();
//            }
//        }
//
//    }
//}
///**
// * @classDesc： 功能描述：（A线程写，B线程读）
// * @author：王武
// * @createTime 2018/1/19
// * @verson: v1.0
// * @copyright: 上海苹果教育科技有限公司
// */
//public class ThreadDemo1 {
//    public static void main(String[] args) {
//        Res res = new Res();
//        BThread bThread = new BThread(res);
//        AThread aThread = new AThread(res);
//
//        aThread.start();
//        bThread.start();
//
//    }
//
//}
