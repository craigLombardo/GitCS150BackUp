#!/bin/bash
clear
PWD=`pwd`
DIRECTORY=`echo $PWD"/"`
DIRNAME=`echo someData/`

SAVETO=`echo $DIRECTORY$DIRNAME`
read -p "The save directory will be...
$SAVETO

Enter y to proceed, anything else to exit
: " ANSWER

if [ "$ANSWER" == "y" ]
	then
		echo
		MYSAVEPATH=`echo $DIRECTORY`
		mkdir $SAVETO
		JAVAPROG=`echo $1`
		JAVACOMP=`echo $JAVAPROG.java`

		javac $JAVACOMP

		for i in ${@:2}
		do
		    FILE=`echo $SAVETO$JAVAPROG$i.csv`
		    java $JAVAPROG $i > $FILE
		done

		osascript testCompleted.scpt
	
	else
		
		echo "
Okay maybe some other time
"
fi