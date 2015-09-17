#!/bin/bash
javac -cp .:../Users/robertwarren/GitHub/tic-tac-toe/src/main/java/edu/jsu/mcis/TicTacToeKeywords.java
java -cp .:../Users/robertwarren/RobotFramework/swinglibrary-1.9.4.jar;../build/classes/main;/Users/robertwarren/RobotFramework/robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeGUITests.txt