package aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @classDesc： 功能描述：（xml实现Aop）
 * @author：王武
 * @createTime 2018/1/28
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class Aop2 {
    public void begin(){
        System.out.println("前置通知");
    }
    public void commit(){
        System.out.println("后置通知");
    }
    public void afterRun() {
        System.out.println("运行通知....");
    }
    public void afterThrowing() {
        System.out.println("异常通知");
    }
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("我是环绕通知-前");
        proceedingJoinPoint.proceed();
        System.out.println("我是环绕通知-后");
    }
}
