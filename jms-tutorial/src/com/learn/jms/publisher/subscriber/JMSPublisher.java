package com.learn.jms.publisher.subscriber;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.learn.jms.object.message.Event;

public class JMSPublisher {

    private Context context;
    private TopicConnectionFactory factory;
    private TopicConnection connection;
    private TopicSession session;
    private Topic topic;
    private TopicPublisher publisher;

    public void sendMessage(Event event) {
	Properties prop = new Properties();
	prop.put(InitialContext.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
	prop.put(InitialContext.PROVIDER_URL, "tcp://192.168.122.1:3035/");

	try {
	    // 1. JNDI object created
	    context = new InitialContext(prop);

	    // 2. JMS administration object identified from JNDI
	    factory = (TopicConnectionFactory) context.lookup("ConnectionFactory");
	    topic = (Topic) context.lookup("topic1");

	    // 3. JMS service provider interface (SPI) connection acquisition
	    connection = factory.createTopicConnection();

	    // 4. Session establishment
	    session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

	    connection.start();

	    // 5. Session plays two important roles
	    // 5.a) creating message
	    ObjectMessage obj = session.createObjectMessage();
	    obj.setObject(event);

	    // 5.b) Sending message
	    publisher = session.createPublisher(topic);
	    publisher.send(obj);

	    System.out.println(this.getClass().getName() + " has sent a message : " + obj.getObject());

	} catch (NamingException e) {
	    e.printStackTrace();
	} catch (JMSException e) {
	    e.printStackTrace();
	}

	try {
	    if (publisher != null)
		publisher.close();
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
	JMSPublisher producer = new JMSPublisher();
	Event e = new Event(1, "Warning event from Publisher-Subscriber");
	producer.sendMessage(e);
    }

}
