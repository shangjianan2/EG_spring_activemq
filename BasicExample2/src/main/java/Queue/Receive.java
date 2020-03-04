package Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

public class Receive {
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
        connection.start();
        //3、获取session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、找目的地，获取destination，消费端，也会从这个目的地取消息
        Destination queue = session.createQueue("user");

        //5、获取消息
        MessageConsumer consumer = session.createConsumer(queue);

        while(true){
            TextMessage message = (TextMessage)consumer.receive();
            System.out.println("message: " + message.getText());
        }
    }
}
