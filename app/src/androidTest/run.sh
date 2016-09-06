#!/bin/sh
# uninstall previous APP and test APP
echo "uninstall pre-installing APPs"
adb -s $1 uninstall com.example.todolist
adb -s $1 uninstall com.example.todolist.test


#delete .xml and .png file crash.txtfrom previous build
/usr/bin/rm -fr *.txt *.jpg *.xml

#define root folder for testauto
testautoRootPath=/mnt/sdcard/testauto
junitReportPath=$testautoRootPath/junit
screenshotPath=/mnt/sdcard/Robotium-Screenshots


#remove report and screenshot from last build and crash.txt
adb -s $1 shell rm -r $junitReportPath/*
adb -s $1 shell rm -r $screenshotPath/*
adb -s $1 shell rm -r $testautoRootPath/crash.txt


echo "start to build APP and test APP"
cd todolisttest
ant clean debug
cd ..


echo "start to install source apk"
adb -s $1 install todolist/bin/todolist-debug.apk
echo "start to install test apk"
adb -s $1 install todolisttest/bin/todolistTest-debug.apk


echo "start to run test"
#define variable used for crash handing 
loop=true
regenerateTestsuite=false
crashCount=0
while [ $loop == "true" ]
do
  adb -s $1 shell am instrument -w -e reportDir $junitReportPath -e reportFile junit-report_${crashCount}.xml -e regenerateTestsuite $regenerateTestsuite com.example.todolist.test/com.example.todolist.test.runners.Runner1
  adb -s $1 pull $junitReportPath/junit-report_${crashCount}.xml  $WORKSPACE/junit-report_${crashCount}.xml
  adb -s $1 pull  $testautoRootPath/crash.txt $WORKSPACE
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
adb -s $1 pull $screenshotPath/ $WORKSPACE/

echo "merge xml files"
java -jar todolisttest/merger.jar