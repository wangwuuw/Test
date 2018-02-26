package aop.service;

import aop.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @classDesc： 功能描述：（注解service）
 * @author：王武
 * @createTime 2018/1/28
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public void add(){
        userDao.add();
    }
}
