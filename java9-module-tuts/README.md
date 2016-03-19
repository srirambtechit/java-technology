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
 - <b>javac</b> provides below arguments for compiling source code
      <b>-classpath &lt;path&gt;</b> : Specify where to find user class files and annotation processors
	  <b>-modulesourcepath &lt;module-source-path&gt;</b> : Specify where to find input source files for multiple modules
	  <b>-modulepath &lt;path&gt;</b> : Specify where to find application modules
	  <b>-mp &lt;path&gt;</b> : Specify where to find application modules
	  <b>-upgrademodulepath &lt;path&gt;</b> : Override location of upgradeable modules
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
 - <b>java</b> provides below argument for running JVM
      <b>-cp &lt;class search path of directories and zip/jar files&gt;</b>
      <b>-classpath &lt;class search path of directories and zip/jar files&gt;</b> 
          A : separated list of directories, JAR archives,
          and ZIP archives to search for class files.

      <b>-mp &lt;module path&gt;</b>
      <b>-modulepath &lt;module path&gt;</b>
          A : separated list of directories, each directory is a directory of modules.

      <b>-upgrademodulepath &lt;module path&gt;</b>
           A : separated list of directories, each directory is a directory of modules that 
           replace upgradeable modules in the runtime image

      <b>-m &lt;modulename&gt; | &lt;modulename&gt;/&lt;mainclass&gt;</b>
           the initial or main module to resolve 

      <b>-addmods &lt;modulename&gt;[,&lt;modulename&gt;...]</b> 
           root modules to resolve in addition to the initial module

      <b>-limitmods &lt;modulename&gt;[,&lt;modulename&gt;...]</b>
           limit the universe of observable modules

      <b>-listmods[:&lt;modulename&gt;[,&lt;modulename&gt;...]]</b>
           list the observable modules and exit

      <b>-D&lt;name&gt;=&lt;value&gt;</b>
           set a system property
</pre>
