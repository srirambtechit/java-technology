# Overview
* Java 9 has a tool called <b>jdeps</b>
* jdeps used to resolve dependencies between jar files 


## How to use `jDeps`
* To know the version of jdeps tool
 $`jdeps --version`

* To print deps summary details
 $`jdeps -s lib/jms-1.1.jar`

* Print all class level dependencies 
  $`jdeps -v lib/jms-1.1.jar`
  $`jdeps -verbose:class lib/jms-1.1.jar`

* Print package level dependenices
  $`jdeps -verbose:package lib/jms-1.1.jar`

* Show module containing a package
  $`jdeps -M lib/jms-1.1.jar`

* Finds class-level dependences on JDK internal APIs.
  By default, it analyzes all classes on -classpath
  and input files unless -include option is specified.
  This option cannot be used with -p, -e and -s options.
  WARNING: JDK internal APIs may not be accessible in
  the next release.
  $`jdeps -jdkinternals lib/jms-1.1.jar`

* Recursively traverse all run-time dependencies
  $`jdeps -R lib/jms-1.1.jar`

* Show profile containing a package
  $`jdeps -P lib/jms-1.1.jar`

## Examples
* Find list modules from the given jar
  $`jdeps -M -s lib/*`

* Generate moduleinfo for third party library
  for instance, openjms has below list of libararies
  $ls -l /opt/openjms1.1/lib
    antlr-2.7.2.jar
    castor-0.9.5.jar
    commons-codec-1.3.jar
    commons-collections-2.1.jar
    commons-dbcp-1.2.1.jar
    commons-logging-1.0.4.jar
    commons-pool-1.2.jar
    concurrent-1.3.4.jar
    derby-10.1.1.0.jar
    jdbc-2.0.jar
    jms-1.1.jar
    jndi-1.2.1.jar
    jta-1.0.1.jar
    log4j-1.2.11.jar
    openjms-0.7.7-beta-1.jar
    openjms-common-0.7.7-beta-1.jar
    openjms-net-0.7.7-beta-1.jar
    openjms-tools-0.7.7-beta-1.jar
    oro-2.0.8.jar
    spice-jndikit-1.2.jar
    xerces-2.4.0.jar
    xml-apis-1.0.b2.jar
  Resolve all dependency and generate moduleinfo for preparing 
  to run in java 9 environment.
  $`jdeps --genmoduleinfo msrc lib/*`
  Note: above command generate module-info.java for all jar files
  based on the depency resolved.
