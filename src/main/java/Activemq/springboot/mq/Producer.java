package Activemq.springboot.mq;

import Activemq.springboot.mq.entity.UserEntity;
import ch.qos.logback.core.util.FixedDelay;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

/**
 * @classDesc： 功能描述：（生产者）
 * @author：王武
 * @createTime 2018/1/18
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */

@EnableScheduling
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    private int age =18;
    @Scheduled(fixedDelay = 5000)
    public void send(){
        age++;
        UserEntity userEntity = new UserEntity(System.currentTimeMillis(), UUID.randomUUID().toString(), age);
        String json = new JSONObject().toJSONString(userEntity);
        jmsMessagingTemplate.convertAndSend(queue,json);
    }

}
