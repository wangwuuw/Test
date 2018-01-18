package Activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @classDesc： 功能描述：（订阅消费者）
 * @author：王武
 * @createTime 2018/1/17
 * @verson: v1.0
 * @copyright: 上海苹果教育科技有限公司
 */
public class TopReceiver {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String BROKERURL = "tcp://127.0.0.1:61616";
    private static final String MYTOPIC = "myTopic";
    public static void start() throws JMSException {
        //获取ActiveMQ 回话工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);
        Connection connection = activeMQConnectionFactory.createConnection();
        //启动连接
        connection.start();
        //jms 设置消息可靠性 自动签收
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Topic topic = session.createTopic(MYTOPIC);
        MessageConsumer consumer = session.createConsumer(topic);


        while (true){
            TextMessage receive = (TextMessage) consumer.receive();
            if (receive!=null){
                System.out.println("我是消费者，内容："+receive.getText());
//                session.commit();
                receive.acknowledge();
            }else
                break;
        }
        session.close();
        connection.close();;




    }

    public static void main(String[] args) throws JMSException {
        start();
    }
}
