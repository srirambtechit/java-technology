package com.learn.jms.point.to.point;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.learn.jms.object.message.Event;

public class JMSSender {

    private Context context;
    private QueueConnectionFactory factory;
    private QueueConnection connection;
    private QueueSession session;
    private Queue queue;
    private QueueSender sender;

    public void send(Event event) {
	Properties prop = new Properties();
	prop.put(InitialContext.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
	prop.put(InitialContext.PROVIDER_URL, "tcp://192.168.122.1:3035/");

	try {
	    // 1. JNDI object created
	    context = new InitialContext(prop);

	    // 2. JMS administration object identified from JNDI
	    factory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
	    queue = (Queue) context.lookup("queue1");

	    // 3. JMS service provider interface (SPI) connection acquisition
	    connection = factory.createQueueConnection();

	    // 4. Session establishment
	    session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

	    connection.start();

	    // 5. Session plays two important roles
	    // 5.a) creating message
	    ObjectMessage obj = session.createObjectMessage();
	    obj.setObject(event);

	    // 5.b) Sending message
	    sender = session.createSender(queue);
	    sender.send(obj);

	    System.out.println("Sent: " + obj.getObject());

	} catch (NamingException e) {
	    e.printStackTrace();
	} catch (JMSException e) {
	    e.printStackTrace();
	}

	try {
	    if (sender != null)
		sender.close();
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
	JMSSender producer = new JMSSender();
	Event e = new Event(1, "Warning event from Point-To-Point");
	producer.send(e);
    }

}
