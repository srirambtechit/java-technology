# JMX Technology

## Java Management Extension
The Java Management Extensions (JMX) API is a standard API for management and monitoring  
of resources such as applications, devices, services, and the Java virtual machine.  
MBeans expose a management interface that consists of the following:  

- A set of readable or writable attributes, or both.
- A set of invokable operations.
- A self-description.

# Usage
Typical uses of the JMX technology include:  
- Consulting and changing application configuration
- Accumulating statistics about application behavior and making them available
- Notifying of state changes and erroneous conditions.

## 5 Types
1. Standard MBeans (Represent simple data type)  
2. Dynamic MBeans 
3. Open MBeans
4. Model MBeans
5. MXBean (Represent complex data type) 

## Tool
jconsole - monitoring and management tool of JMX MBeans

## Local and Remote invocation of JMX enabled application
- remote  
`$ java -Dcom.sun.management.jmxremote.port=9999 \
        -Dcom.sun.management.jmxremote.authenticate=false \
	    -Dcom.sun.management.jmxremote.ssl=false \
		   com.msrm.jmx.stdmbean.MainJmxAgent`  
- local
`$ java -Dcom.sunmanagement.jmxremote com.msrm.jmx.stdmbean.MainJmxAgent`  


