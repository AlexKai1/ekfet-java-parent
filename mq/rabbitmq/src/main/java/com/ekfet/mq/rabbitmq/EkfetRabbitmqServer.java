package com.ekfet.mq.rabbitmq;

import com.ekfet.mq.rabbitmq.config.RabbitConfiguration;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EkfetRabbitmqServer {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(RabbitConfiguration.class);
    ctx.refresh();

    RabbitTemplate rabbitTemplate = ctx.getBean(RabbitTemplate.class);
    Message message =
        MessageBuilder.withBody("foo".getBytes())
            .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
            .setMessageId("123")
            .setHeader("bar", "baz")
            .build();
    rabbitTemplate.convertAndSend("luoboExchange", "luobo", message);
  }
}
