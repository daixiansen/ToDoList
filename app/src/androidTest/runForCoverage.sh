#!/bin/sh
echo "start to run test"
adb shell am instrument -w -e reportDir /mnt/sdcard/testauto/junit -e reportFile junit-report.xml -e coverage true -e coverageFile /mnt/sdcard/coverage.ec com.example.todolist.test/com.example.todolist.test.runners.Runner1
 
echo "copy coverage.em from todolist/bin"
cp ./todolist/bin/coverage.em ./todolisttest/coverage.em

echo "pull coverage.ec from sdcard"
adb pull /mnt/sdcard/coverage.ec ./todolisttest/coverage.ec

echo "generate xml report"
cd todolisttest
java -cp ./emma.jar emma report -r xml -in coverage.em,coverage.ec  -Dreport.xml.out.file=./coverage.xml
