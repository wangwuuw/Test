package Activemq.springboot.mq;
import Activemq.springboot.mq.entity.UserEntity;
import com.alibaba.fastjson.JSONObject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @classDesc： 功能描述：（）
 * @author：王武
 * @createTime 2018/1/18
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */

public class Consumer {
    @JmsListener(destination = "${queue}")
    public void receive(String msg){
        System.out.println(msg);
        JSONObject json = new JSONObject();
        UserEntity userEntity = json.parseObject(msg, UserEntity.class);
        System.out.println(userEntity.toString());
    }
}
