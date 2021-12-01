package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumerApp
{
	@Autowired
	MessageReceiver messageReceiver;
	public String receiveMessageQueue()
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);


		
		String response = messageReceiver.receiveMessage();
		System.out.println("Messgae Received = ");

		((AbstractApplicationContext) context).close();
		return response;
	}

}
