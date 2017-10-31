package com.baidu.uuap.runner;

import com.baidu.uuap.pojo.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRabbitRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;

    @Autowired
    public AppRabbitRunner(Receiver receiver, RabbitTemplate rabbitTemplate,
                           ConfigurableApplicationContext context) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("AppRabbitRunner Sending message...");
//        rabbitTemplate.convertAndSend(SpringbootTestApplication.queueName, "Hello from RabbitMQ!");
//        receiver.getLatch().await(5000, TimeUnit.MILLISECONDS);
//        context.close();
    }

}