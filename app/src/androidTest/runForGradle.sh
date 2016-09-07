#!/bin/sh

#define root folder for testauto
testautoRootPath=/mnt/sdcard/testauto
junitReportPath=$testautoRootPath/junit
screenshotPath=/mnt/sdcard/Robotium-Screenshots

echo remove report and screenshot from last build and crash.txt
adb -s $1 shell rm -r $junitReportPath/*
adb -s $1 shell rm -r $screenshotPath/*

echo "uninstall APK and Test APK"
adb  -s $1 uninstall com.example.todolist
adb  -s $1 uninstall com.example.todolist.test

echo "install APK and Test APK"
adb -s $1 install app/build/outputs/apk/app-debug.apk
adb -s $1 install app/build/outputs/apk/app-debug-androidTest-unaligned.apk

echo "start to run test"
adb -s $1 shell am instrument -w -e reportDir $junitReportPath -e reportFile junit-report.xml com.example.todolist.test/com.example.todolist.test.runners.Runner1
 
echo "pull junit report"
adb -s $1 pull $junitReportPath/junit-report.xml

echo "pull screenshots"
adb -s $1 pull $screenshotPath/