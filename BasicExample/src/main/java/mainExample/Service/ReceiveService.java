package mainExample.Service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiveService {
    @JmsListener(destination = "springboot", containerFactory = "jmsListenerContainerTopic")
    public void receive(String msg){
        System.out.println("receive: " + msg);
    }
}
