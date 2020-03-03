package mainExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class ActiveMqConfig {
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(
            ConnectionFactory activeMQConnectionFactory
    ){
        DefaultJmsListenerContainerFactory bean
                = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(
            ConnectionFactory activeMQConnectionFactory
    ){
        DefaultJmsListenerContainerFactory bean
                = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
}
