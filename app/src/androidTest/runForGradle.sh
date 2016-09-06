#!/bin/sh
echo "uninstall APK and Test APK"
adb  uninstall com.example.todolist
adb  uninstall com.example.todolist.test

echo "install APK and Test APK"
adb install app/build/outputs/apk/app-debug.apk
adb install app/build/outputs/apk/app-debug-test-unaligned.apk

echo "start to run test"
adb shell am instrument -w -e reportDir /mnt/sdcard -e reportFile junit-report.xml com.example.todolist.test/com.example.todolist.test.runners.Runner1
 
echo "pull junit report"
adb pull /mnt/sdcard/junit-report.xml  $WORKSPACE/junit-report.xml