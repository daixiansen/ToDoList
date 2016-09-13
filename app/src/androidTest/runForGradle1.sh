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
adb  uninstall com.example.todolist
adb  uninstall com.example.todolist.test

echo "install APK and Test APK"
adb install app/build/outputs/apk/app-debug.apk
adb install app/build/outputs/apk/app-debug-androidTest-unaligned.apk

echo "start to run test"
adb shell am instrument -w -e reportDir $junitReportPath -e reportFile junit-report.xml com.example.todolist.test/com.example.todolist.test.runners.Runner1
 
echo "pull junit report"
if [ ! -d "$junitReportPath_xml" ]; then
  adb pull $junitReportPath/junit-report.xml
fi

echo "pull crash.txt"
if [ ! -d "$testautoRootPath" ]; then
  adb pull  $testautoRootPath/
fi

echo "pull screenshots"
# -d 参数判断 $folder 是否存在

if [ -d "$screenshotPath" ]; then
  adb pull $screenshotPath/
fi

