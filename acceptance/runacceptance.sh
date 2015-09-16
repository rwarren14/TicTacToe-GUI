#!/bin/bash
javac -cp .:/Users/robertwarren/GitHub/tic-tac-toe/src/main/java/edu/jsu/mcis/TicTacToe.java
java -cp .:../build/classes/main:/Users/robertwarren/RobotFramework/robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeTests.txt

