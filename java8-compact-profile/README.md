# Java 8 Features

* lambda expression
* compact profiles


## compact profiles
Compact profiles, introducted in Java SE 8, define subset of the Java SE
platform API thtat can reduce the static size of Java runtime on devices
that have limited storage capacity.


### Why we need compact profile?
* JRE is core software for Java to lunch JVM
* JRE consists of binaries, libararies, resources, system properties, etc.
* rt.jar, tools.zip, bin/executable, etc. are few of them
* Java runs on differnent device viz PC, Mobile, Embedded devices
* Running Java application on any of these device require JRE, size of the 
JRE is standard, so it is difficult to adapt all devices
* Generally, all application doesn't required all of these libraries, for
example, web application doesn't dependent on javax.swing, java.awt packages
some networking application doesn't dependent on xml processing APIs and so on.
* Java 8 brought profiling concept to reduce JRE bundle size in terms of compact 
profiles, which defines three subset of Java SE. but still, unable to cover all
current and future needs of partial JREs.
* Java 9 will address this problem in future by module system


### Overview
* Resource-constrained devices can use profiles.
* Three profiles
   * compact1 (very min APIs)
   * compact2 (compact1 + additional APIs)
   * compact3 (compact 2 + additional APIs) = Full Java SE API
* javac compiler has **-profile** option to direct the usage of an API not present
in profile.


### API details
Profile | APIs
--- | ---
__compact1__ | core(java.lang), networking, date & time, logging, security, io, internationalization, extension mechanism, concurrency, zip, jndi, scripting, collection, regex, versioning, override mechanism, seiralization 
__compact2__ | compact1, jdbc, xml, rmi
**compact3** | compact2, security(kerberos, acl, sasl to compact1 security), JMX, XML JAXP, Management, Instrumentation
**Full SE API** | beans, jni, jax-ws, preferences, accessibility, IDL, RMI-IIOP, CORBA, print service, sound, swing, Java 2D, AWT, darg & drop, input methods, Image IO

