package mainExample.Service;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Topic;

@Service
public class SendTopic {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    private Topic topic = new ActiveMQTopic("springboot_topic");

    public void send(String msg){
        this.jmsMessagingTemplate.convertAndSend(this.topic,msg);
    }
}
