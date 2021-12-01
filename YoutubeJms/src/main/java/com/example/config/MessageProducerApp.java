package com.example.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;



@Component
public class MessageProducerApp
{
	@Autowired
	MessageSender messageSender;
	public String sendMessageQueue(ArrayList<YoutubeDataSerializer> senderDataList)
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		XMLTransformer transformer = new XMLTransformer();
		
String str=transformer.toXMLString(senderDataList);
messageSender.sendMessageA(str);
		System.out.println("Message has been sent successfully...");

		((AbstractApplicationContext) context).close();
		return str;
	}

}