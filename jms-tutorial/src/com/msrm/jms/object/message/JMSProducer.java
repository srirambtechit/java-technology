package com.msrm.jms.object.message;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSProducer {

    private Context context;
    private ConnectionFactory factory;
    private Connection connection;
    private Destination destination;
    private Session session;
    private MessageProducer producer;

    public void sendMessage(Event event) {

	Properties prop = new Properties();
	prop.put(InitialContext.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
	prop.put(InitialContext.PROVIDER_URL, "tcp://192.168.122.1:3035/");

	try {
	    context = new InitialContext(prop);
	    factory = (ConnectionFactory) context.lookup("ConnectionFactory");
	    destination = (Destination) context.lookup("queue1");

	    connection = factory.createConnection();
	    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	    producer = session.createProducer(destination);
	    connection.start();

	    ObjectMessage message = session.createObjectMessage();
	    message.setObject(event);
	    producer.send(message);

	    System.out.println("Sent: " + message.getObject());

	} catch (NamingException e) {
	    e.printStackTrace();
	} catch (JMSException e) {
	    e.printStackTrace();
	}

	try {
	    if (producer != null)
		producer.close();
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
	JMSProducer producer = new JMSProducer();
	Event e = new Event(1, "Warning event");
	producer.sendMessage(e);
    }

}
