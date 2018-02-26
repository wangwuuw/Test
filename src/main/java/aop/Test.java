package aop;

import aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @classDesc： 功能描述：（）
 * @author：王武
 * @createTime 2018/1/28
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */

public class Test {
    @Autowired
    public UserService userService;
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService=	(UserService) app.getBean("userService");
        userService.add();
    }
}
