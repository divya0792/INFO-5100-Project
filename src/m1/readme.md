### TO RUN
# Compile:
```
find . -name "*.java" -print | xargs javac -cp "../lib/*"
```
# Run:
```
java -cp .:../lib/sqljdbc4.jar:../lib/jackson-core-2.9.9.jar::../lib/jackson-databind-2.9.9.jar:../lib/jackson-annotations-2.9.9.jar:../lib/jcalendar-1.4.jar Main
```
