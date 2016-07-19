# Compile and Run program


$ cd rmi-arraylist-remoteobject

- clear the existing byte code and stubs 
$ rm -rf bin/*

- compile sources codes
$ javac -d bin src/*.java

- rmic compiler for generating stub
$ rmic -d bin -classpath bin com.msrm.rmi.ShipperImpl

- rmiregistry should be called from root directory
- of byte code location, and running it in backgound process
$ cd bin
$ rmiregistry &

- run MyRMIServer class
$ java -cp bin com.msrm.rmi.MyRMIServer

- run MyRMIClient class
$ java -cp bin com.msrm.rmi.MyRMIClient
