`
# in this demo, instead of compiling each module separately
# possible to compile multiple modules with one javac command

$ cd /home/sriram/stuff/jdk9/4-mod-packaging

$ javac -d mods -modulesourcepath src $(find src -name "*.java")

$ mkdir mlib

$ jar --create --file=mlib/org.astro@1.0.jar --module-version=1.0 -C mods/org.astro .

$ jar --create --file=mlib/com.greetings.jar --main-class=com.greetings.Main -C mods/com.greetings .

$ java -mp mlib -m com.greetings

$ jar --print-module-descriptor --file=mlib/org.astro@1.0.jar
`