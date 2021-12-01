package com.example.config;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver
{
	@Autowired
    private JmsTemplate jmsTemplate_Queue_1;
    @Autowired
    private JmsTemplate jmsTemplate_Queue_2;
	@Autowired
	MessageConverter messageConverter;

	public String receiveMessage()
	{
		try
		{
			/*
			 * Here we receive the message.
			 */
			Message message = jmsTemplate_Queue_1.receive();
			//String response = (String) messageConverter.fromMessage(message);
			String response = (String) messageConverter.fromMessage(message);
			
			System.out.println("Receiver "+response);
//			for(YoutubeDataSerializer yt : response) {
//				System.out.println("Inside Receiver "+yt.getTitle());
//			}
			return response;

		}
		catch (Exception exe)
		{
			exe.printStackTrace();
		}

		return null;
	}
}