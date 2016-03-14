$ cd /home/sriram/stuff/jdk9/2-mod-dependency 
$ javac -d mods/org.astro \
        src/org.astro/module-info.java src/org.astro/org/astro/World.java

$ javac -modulepath mods -d mods/com.greetings \
        src/com.greetings/module-info.java src/com.greetings/com/greetings/Main.java

$ java -modulepath mods -m com.greetings/com.greetings.Main
