package com.learn.jms.point.to.point;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSReceiver {

    private Context context;
    private QueueConnectionFactory factory;
    private QueueConnection connection;
    private Queue queue;
    private QueueSession session;
    private QueueReceiver receiver;

    public void receiveMessage() {
	Properties prop = new Properties();
	prop.put(InitialContext.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
	prop.put(InitialContext.PROVIDER_URL, "tcp://192.168.122.1:3035/");

	try {
	    context = new InitialContext(prop);
	    factory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
	    queue = (Queue) context.lookup("queue1");

	    connection = factory.createQueueConnection();
	    session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

	    connection.start();

	    receiver = session.createReceiver(queue);
	    Message message = receiver.receive();

	    System.out.println(queue.getQueueName());

	    if (message instanceof ObjectMessage) {
		ObjectMessage object = (ObjectMessage) message;
		System.out.println("Received: " + object.getObject());
	    }

	} catch (NamingException e) {
	    e.printStackTrace();
	} catch (JMSException e) {
	    e.printStackTrace();
	}

	try {
	    if (receiver != null)
		receiver.close();
	} catch (JMSException e) {
	    e.printStackTrace();
	}

	try {
	    if (session != null)
		session.close();
	} catch (JMSException e) {
	    e.printStackTrace();
	}

	try {
	    if (connection != null)
		connection.close();
	} catch (JMSException e) {
	    e.printStackTrace();
	}

	try {
	    if (context != null)
		context.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}

    }

    public static void main(String[] args) {
	JMSReceiver consumer = new JMSReceiver();
	consumer.receiveMessage();
    }

}
