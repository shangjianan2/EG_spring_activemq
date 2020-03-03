package mainExample.Controller;

import mainExample.Service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    SendService sendService;

    @RequestMapping("send")
    public String send(){
        sendService.send("springboot", "asdf");
        return "OK";
    }
}
