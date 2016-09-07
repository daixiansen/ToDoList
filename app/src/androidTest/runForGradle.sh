#!/bin/sh

#define root folder for testauto
testautoRootPath=/mnt/sdcard/testauto
junitReportPath=$testautoRootPath/junit
screenshotPath=/mnt/sdcard/Robotium-Screenshots

echo remove report and screenshot from last build and crash.txt
adb shell rm -r $junitReportPath/*
adb shell rm -r $screenshotPath/*
adb shell rm -r $testautoRootPath/*

echo "uninstall APK and Test APK"
adb uninstall com.example.todolist
adb uninstall com.example.todolist.test

echo "install APK and Test APK"
adb install app/build/outputs/apk/app-debug.apk
adb install app/build/outputs/apk/app-debug-androidTest-unaligned.apk

#
echo "start to run test"
loop=true
regenerateTestsuite=false
crashCount=0
while [ $loop == "true" ]
do
adb shell am instrument -w -e reportDir $junitReportPath -e reportFile junit-report_${crashCount}.xml com.example.todolist.test/com.example.todolist.test.runners.Runner1
adb pull $junitReportPath/
adb pull  $testautoRootPath/

if [ -f $WORKSPACE/crash.txt ];then
     echo "crash  happen "
	 /usr/bin/rm -f $WORKSPACE/crash.txt
     regenerateTestsuite=true
	((crashCount=$crashCount+1))
  else
	  loop=false
  fi
done

echo "pull screenshots"
adb pull $screenshotPath/

#echo "merge xml files"
#java -jar app/src/androidTest/merger.jar