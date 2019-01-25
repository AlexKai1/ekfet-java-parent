package com.ekfet.mq.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

  @RabbitListener(
      bindings = @QueueBinding(value = @Queue("luobo"), exchange = @Exchange("luoboExchange")))
  public void message(byte[] message) {
    String string = new String(message);
    System.out.println("QueueListener" + string);
  }
}
