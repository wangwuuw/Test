package aop;

import aop.service.UserService;
import aop.service.UserService2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @classDesc： 功能描述：（）
 * @author：王武
 * @createTime 2018/1/28
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */

public class Test2 {
    public UserService userService;
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring2.xml");
        UserService2 userService=	(UserService2) app.getBean("userService2");
        userService.add();
    }
}
