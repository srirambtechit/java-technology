# in this demo, instead of compiling each module separately
# possible to compile multiple modules with one javac command

$ cd /home/sriram/stuff/jdk9/3-multi-mod

$ javac -d mods -modulesourcepath src $(find src -name "*.java")

$ java -modulepath mods -m com.greetings/com.greetings.Main
