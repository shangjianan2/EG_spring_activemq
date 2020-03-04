package mainExample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Topic;

@Service
public class SendTopic {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Topic topic;

    public void send(String msg){
        this.jmsMessagingTemplate.convertAndSend(this.topic,msg);
    }
}
