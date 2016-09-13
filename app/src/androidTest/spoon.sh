#!/bin/sh

#define root folder for testauto
testautoRootPath=/mnt/sdcard/testauto
junitReportPath=$testautoRootPath/junit
junitReportPath_xml=$junitReportPath/junit-report.xml
#默认截图地址
screenshotPath=/mnt/sdcard/Robotium-Screenshots

echo remove report and screenshot from last build and crash.txt
adb shell rm -r $junitReportPath/*
adb shell rm -r $screenshotPath/*
adb shell rm -r $testautoRootPath/*

echo "uninstall APK and Test APK"
#adb  uninstall com.example.todolist
#adb  uninstall com.example.todolist.test

echo "install APK and Test APK"
#adb install app/build/outputs/apk/app-debug.apk
#adb install app/build/outputs/apk/app-debug-androidTest-unaligned.apk

echo "start to run test"
#adb shell am instrument -w -e reportDir $junitReportPath -e reportFile junit-report.xml com.example.todolist.test/com.example.todolist.test.runners.Runner1

java -jar spoon-runner-1.7.0-jar-with-dependencies.jar --apk app/build/outputs/apk/app-debug.apk --test-apk app/build/outputs/apk/app-debug-androidTest-unaligned.apk

echo "pull junit report"
cp -r spoon-output ../../userContent/


#adb pull $junitReportPath/junit-report.xml
#
#echo "pull crash.txt"
#adb pull  $testautoRootPath/
#
#echo "pull screenshots"
#adb pull $screenshotPath/