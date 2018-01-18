package Activemq.springboot.mq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @classDesc： 功能描述：（创建一个队列）
 * @author：王武
 * @createTime 2018/1/18
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
@Configuration
public class QueueConfig {
    @Value("${queue}")
    private String QueueName;
    @Bean
    public Queue queue(){
    return new ActiveMQQueue(QueueName);
    }
}
