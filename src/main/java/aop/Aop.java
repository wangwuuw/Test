package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @classDesc： 功能描述：（注解版本）
 * @author：王武
 * @createTime 2018/1/28
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
@Aspect
@Component
public class Aop {
    @Before("execution(* aop.service.*.add(..))")
   public void begin(){
       System.out.println("前置通知");
   }
    @After("execution(* aop.service.*.add(..))")
   public void commit(){
        System.out.println("后置通知");
   }
    @AfterReturning("execution(* aop.service.*.add(..))")
    public void afterRun() {
        System.out.println("运行通知....");
    }
    @AfterThrowing("execution(* aop.service.*.add(..))")
    public void afterThrowing() {
        System.out.println("异常通知");
    }
    @Around("execution(* aop.service.*.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("我是环绕通知-前");
        proceedingJoinPoint.proceed();
        System.out.println("我是环绕通知-后");
    }
}
