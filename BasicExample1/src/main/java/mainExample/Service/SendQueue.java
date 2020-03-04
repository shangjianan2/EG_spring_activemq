package mainExample.Service;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class SendQueue {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    private Queue queue = new ActiveMQQueue("springboot_queue");

    public void send(String msg){
        this.jmsMessagingTemplate.convertAndSend(this.queue,msg);
    }
}
