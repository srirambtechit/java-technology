package com.learn.jms.text.message;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSConsumer {

    private Context context;
    private ConnectionFactory factory;
    private Connection connection;
    private Destination destination;
    private Session session;
    private MessageConsumer consumer;

    public void receiveMessage() {
	Properties prop = new Properties();
	prop.put(InitialContext.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
	prop.put(InitialContext.PROVIDER_URL, "tcp://192.168.122.1:3035/");

	try {
	    context = new InitialContext(prop);
	    factory = (ConnectionFactory) context.lookup("ConnectionFactory");
	    destination = (Destination) context.lookup("queue1");

	    connection = factory.createConnection();
	    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	    consumer = session.createConsumer(destination);
	    connection.start();

	    Message message = consumer.receive();
	    if (message instanceof TextMessage) {
		TextMessage text = (TextMessage) message;
		System.out.println("Received: " + text.getText());
	    }

	} catch (NamingException e) {
	    e.printStackTrace();
	} catch (JMSException e) {
	    e.printStackTrace();
	}

	try {
	    if (consumer != null)
		consumer.close();
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
	JMSConsumer consumer = new JMSConsumer();
	consumer.receiveMessage();
    }

}
