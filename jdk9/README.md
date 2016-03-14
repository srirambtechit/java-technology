<h1>JDK 9 Tutorial</h1>

<h3>Project Jigsaw</h3>
<pre>
 - Make the Java SE Platform, and the JDK, more easily scalable
   down to small computing devices;
 - Improve the security and maintainability of Java SE Platform Implementations 
   in general, and the JDK in particular;
 - Enable improved application performance
 - Make it easier for developers to construct and maintain libraries
   and large applications, for both the Java SE and EE Platforms.
</pre>

<h3>Modular Development</h3>
<pre>
 - jdk 9 supports modular developement
 - Project Jigsaw proposed in JEP
 - <b>module</b> keyword added as part of jdk binaries
 - <b>moudle-info.java</b> is a java file should have all module related information
   and file name should be as it is.
 - <b>javac</b> provides below arguments
      <b>-classpath &lt;path&gt;</b> : Specify where to find user class files and annotation processors
	  <b>-modulesourcepath &lt;module-source-path&gt;</b> : Specify where to find input source files for multiple modules
	  <b>-modulepath &lt;path&gt;</b> : Specify where to find application modules
	  <b>-mp &lt;path&gt;</b> : Specify where to find application modules
	  <b>-upgrademodulepath ;lt;path&gt;</b> : Override location of upgradeable modules
	  <b></b> : Override location of system modules
	  <b>-system &lt;jdk&gt;|none</b> : Override location of system modules
	  <b>-systemmodulepath &lt;jdk&gt;|none</b> : Override location of system modules
	  <b>-bootclasspath &lt;path&gt;</b> : Override location of bootstrap class files
	  <b>-extdirs &lt;dirs&gt;</b> : Override location of installed extensions
	  <b>-endorseddirs &lt;dirs&gt;</b> : Override location of endorsed standards path
	  <b>-d &lt;directory&gt;</b> : Specify where to place generated class files
	  <b>-s &lt;directory&gt;</b> : Specify where to place generated source files
	  <b>-h &lt;directory&gt;</b> : Specify where to place generated native header files
	  <b>-m &lt;module-name&gt;</b> : Compile only the specified module, check timestamps
</pre>
