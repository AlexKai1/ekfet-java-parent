package com.ekfet.mq.rabbitmq;

import com.ekfet.mq.rabbitmq.config.RabbitConfiguration;
import com.ekfet.mq.rabbitmq.listener.QueueListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EkfetRabbitmqListener {
  public static void main(String[] args) {
      AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
      ctx.register(RabbitConfiguration.class, QueueListener.class);
      ctx.refresh();

  }
}
