package com.example.config;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSender
{

	 @Autowired
     private JmsTemplate jmsTemplate_Queue_1;
     @Autowired
     private JmsTemplate jmsTemplate_Queue_2;


	public void sendMessageA(final String str)
	{
		
		jmsTemplate_Queue_1.send(new MessageCreator()
		{
			public Message createMessage(Session session) throws JMSException
			{
				ObjectMessage objectMessage = session.createObjectMessage();
				objectMessage.setObject(str);
				return objectMessage;
			}
		});
	}
	
	public void sendMessageB(final String str)
	{
		
		jmsTemplate_Queue_2.send(new MessageCreator()
		{
			public Message createMessage(Session session) throws JMSException
			{
				ObjectMessage objectMessage = session.createObjectMessage();
				objectMessage.setObject(str);
				return objectMessage;
			}
		});
	}

}
