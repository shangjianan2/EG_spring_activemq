package mainExample.Service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiveQueue {
    @JmsListener(destination = "springboot_queue", containerFactory = "jmsListenerContainerQueue")
    public void receive(String msg){
        System.out.println("receive: " + msg);
    }
}
