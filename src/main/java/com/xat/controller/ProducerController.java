package com.xat.controller;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xat.config.RabbitMQConfig;

@RestController
public class ProducerController {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@GetMapping("/sendMessage")
	public Object sendMessage() {
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String value = dateFormat.format(new Date().getTime());
				System.out.println("send message {"+value+"}");
				rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, value);
			}
		}).start();
		return "ok";
	}
}
