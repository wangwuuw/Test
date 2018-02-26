package aop.dao;

import org.springframework.stereotype.Repository;

/**
 * @classDesc： 功能描述：（注解service）
 * @author：王武
 * @createTime 2018/1/28
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
@Repository
public class UserDao {
    public void add(){
        int i = 1/0;
        System.out.println("UserDao.add---------");
    }
}
