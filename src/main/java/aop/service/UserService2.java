package aop.service;

import aop.dao.UserDao2;

/**
 * @classDesc： 功能描述：（xml注入）
 * @author：王武
 * @createTime 2018/1/28
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */

public class UserService2 {

    private UserDao2 userDao2;

    public void add(){
        userDao2.add();
    }

    public void setUserDao2(UserDao2 userDao2) {
        this.userDao2 = userDao2;
    }

    public UserDao2 getUserDao2() {
        return userDao2;
    }
}
