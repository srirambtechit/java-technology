package com.learn.jms.publisher.subscriber;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSSubscriberTwo {

    private Context context;
    private TopicConnectionFactory factory;
    private TopicConnection connection;
    private Topic topic;
    private TopicSession session;
    private TopicSubscriber subscriber;

    public void receiveMessage() {
	Properties prop = new Properties();
	prop.put(InitialContext.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
	prop.put(InitialContext.PROVIDER_URL, "tcp://192.168.122.1:3035/");

	try {
	    context = new InitialContext(prop);
	    factory = (TopicConnectionFactory) context.lookup("ConnectionFactory");
	    topic = (Topic) context.lookup("topic1");

	    connection = factory.createTopicConnection();
	    session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

	    connection.start();

	    subscriber = session.createSubscriber(topic);
	    Message message = subscriber.receive();

	    System.out.println(topic.getTopicName());

	    if (message instanceof ObjectMessage) {
		ObjectMessage object = (ObjectMessage) message;

		System.out.println(this.getClass().getName() + " has received a message : " + object.getObject());
	    }

	} catch (NamingException e) {
	    e.printStackTrace();
	} catch (JMSException e) {
	    e.printStackTrace();
	}

	try {
	    if (subscriber != null)
		subscriber.close();
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
	JMSSubscriberTwo consumer = new JMSSubscriberTwo();
	consumer.receiveMessage();
    }

}
