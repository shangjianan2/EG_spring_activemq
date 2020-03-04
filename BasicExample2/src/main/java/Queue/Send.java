package Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

public class Send {
    public static void main(String[] args) throws Exception {
        //1、获取连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(
                        ActiveMQConnectionFactory.DEFAULT_USER,
                        ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                        "tcp://39.106.169.107:61616"
                );
        //2、获取一个ActiveMQ连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //3、获取session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、找目的地，获取destination，消费端，也会从这个目的地取消息
        Queue queue = session.createQueue("user");

        //5.1、消息创建者
        MessageProducer producer = session.createProducer(queue);
        //5.2、创建消息
        TextMessage textMessage = session.createTextMessage("hi");
        //5.3、向目的地写入消息
        producer.send(textMessage);
        //6、关闭连接
        connection.close();
    }
}
