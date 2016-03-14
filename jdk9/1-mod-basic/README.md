$ cd /home/sriram/stuff/jdk9/1-mod-basic
$ javac -d mods/com.greetings \
        src/com.greetings/module-info.java \
		        src/com.greetings/com/greetings/Main.java
$ java -modulepath mods -m com.greetings/com.greetings.Main
