package mainExample.Controller;

import mainExample.Service.SendQueue;
import mainExample.Service.SendTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {
    @Autowired
    SendQueue sendQueue;
    @Autowired
    SendTopic sendTopic;

    @RequestMapping("sendQ")
    public String sendQueue(){
        sendQueue.send("a queue wjl");
        return "Queue OK";
    }

    @RequestMapping("sendT")
    public String sendTopic(){
        sendTopic.send("a topic wjl");
        return "Topic OK";
    }

}
