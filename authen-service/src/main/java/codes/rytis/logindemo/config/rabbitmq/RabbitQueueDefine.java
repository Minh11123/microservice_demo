package codes.rytis.logindemo.config.rabbitmq;

import codes.rytis.logindemo.constants.JobQueue;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RabbitQueueDefine {
    @Autowired
    @Qualifier("amqpAdmin")
    AmqpAdmin rabbitAdminMain;

    @Bean
    public Queue incomingQueue() {

        //Define queue job
        for (String queueName : JobQueue.queueNameList) {
            Queue queue = new Queue(queueName, true, false, false, null);
//            rabbitAdminMain.declareQueue(queue);
        }
        return null;
    }

}
