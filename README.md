# wasp-pig-latin
Pig Latin generator for WASP SW course

# Compile and run unit test (without ant):
cd src
javac -cp .:junit-4.12.jar PigLatinTest.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore PigLatinTest
