<h1>Java Message Service - JMS</h1>

<h3>Introduction:-</h3>

- Passing message between application
- Distributed system
- Loosely coupled
- An application can send message(text, object, etc) to another application


<h3>Participants and Concept of JMS:-</h3>

	SenderApplication     - Application want to send message
	Destination           - It is a domain where messages placed
	ReceiverApplication   - Application want to receive message
	
- JMS Client can send its message to destination
- Another JMS Client can receive the same message from destination 


<h3>JMS Model:-</h3>

- Point-To-Point approach        - One client send message to an another client
- Publisher-Subscriber approach  - One client send message to multiple clients

<h3>JMS APIs</h3>

<b>Administered Objects:-<b> Destinations and connection factories are referred as administered objects.These are not usually maintaining by program . These objects will be bound to JNDI  name space . Clients can access these administered object using JNDI look up.

<b>Connection:-</b> It is a virtual connection with JMS provider.

<b>Session:-</b> It is a single threaded  context for producing and consuming messages.

<b>Message Producer:–</b> It is created from a session and is using to send messages to destinations.

<b>Message Consumers:–</b> It is also created from a session and is using to receive messages from destination.

<b>Message Selector:-</b> To filter the messages received.

<b>Message:-</b> Message objects are sending in JMS. A JMS message has 3 parts

	a)header:- It contains a number of  predefined fields using for proper delivery and routing.
	
	b)body :- As the name suggests it is the body of messages. JMS API allows five types of message bodies.

	        1.TextMessage :- Body contains String data
	
	        2.ByteMessage :- Body contains byte data
	
	        3. MapMessage :- Body contains data in key/value pair
	
	        4.StreamMessage :-Body contains a stream of primitive  values
	
	        5.ObjectMessage : – Body contains an object
	
	        6.Message :- Nothing in body. Only header and properties.
	
	c)properties :- Additional properties other than header.


<h3>Reliability:-</h3>

	1)Specifying message persistence :- It is possible to make messages persistent or non-persistent.Persistent messages will be persisted in case of JMS provider failure. It ensures reliable message delivery.
	
	2)Setting message priority levels :- It is possible to set the message priority levels. Messages with higher priorities will be delivered first.
	
	3)Allowing messages to expire :– It is possible to set expiration time for messages.This mechanism avoids the delivery of messages once it is obsolete.
	
	4)Controlling message acknowledgment:-It is possible to make various levels of control over message acknowledgment. These controlling makes a reliable delivery of messages.
	
	5)Creating Temporary Destinations:-Usually JMS destinations are created administratively . JMS API allows the creation of temporary destinations in program.Temporary destinations can be used to implement a request/response mechanism .It ensures reliable message delivery.
	
	6)Creating durable subscriptions :-    In a Publish/Subscribe messaging domain , the subscriber should be active to get the published messages. If the subscriber is not active while a client publishes a message , the subscriber cannot get that message. If we create a durable subscriber in place of non-durable subscriber , the messages will not lost even if the subscriber is not active.This ensures a better reliability in case of Publish/Subscribe domain.
	
	