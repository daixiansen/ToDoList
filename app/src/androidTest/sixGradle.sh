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
adb uninstall cn.v6.sixrooms
adb uninstall cn.v6.sixrooms.test

echo "install APK and Test APK"
adb install sixRooms/build/outputs/apk/sixRooms-debug.apk
adb install sixRooms/build/outputs/apk/sixRooms-debug-

echo "start to run test"
adb shell am instrument -w -e reportDir $junitReportPath -e reportFile junit-report.xml  cn.v6.sixrooms.test/.Runners.Runner

echo "pull junit report"
adb pull $junitReportPath/junit-report.xml

echo "pull crash.txt"
adb pull  $testautoRootPath/


echo "pull screenshots"
adb pull $screenshotPath/