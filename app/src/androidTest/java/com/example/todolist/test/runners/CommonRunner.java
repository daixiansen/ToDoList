package com.example.todolist.test.runners;

import android.os.Bundle;
import android.os.Environment;

import com.zutubi.android.junitreport.JUnitReportTestRunner;

import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommonRunner extends JUnitReportTestRunner {
	private static final String REGENERATE_TESTSUITE = "regenerateTestsuite";
	boolean isNeedRegenerate = false;

	@Override
	public void onCreate(Bundle arguments) {
		// TODO Auto-generated method stub
		String regenerate = arguments.getString(REGENERATE_TESTSUITE);
		if ("true".equals(regenerate)) {
			isNeedRegenerate = true;
		} else {
			isNeedRegenerate = false;
		}
		super.onCreate(arguments);
	}


    /**
     * 用于获取当前Runner的所有用例名的方法
     * @param testSuite
     * @return
     */
	public static List<String> getCaseNameList(TestSuite testSuite) {
		List<String> caseNameList = new ArrayList<String>();
		for (int i = 0; i < testSuite.testCount(); i++) {
			for (int j = 0; j < ((TestSuite) testSuite.testAt(i)).testCount(); j++) {
				caseNameList.add(((TestSuite) testSuite.testAt(i)).testAt(j)
						.toString());
			}
		}
		/**
		 * every suite end with LatestTest, use for delete crash file
		 */
		caseNameList.add("com.example.todolist.test.testcases.LatestTest");
		return caseNameList;
	}

	  /**
     * regenerate test suite from the next one of crash case
       * 获取还未运行过的用例集
     * @param caseNameList
     * @return
     */
    public TestSuite reGenerateTestSuiteWhenCrash(List<String> caseNameList) {
        TestSuite testSuite = new TestSuite();
        String crashCaseName = getCrashCaseName();
        boolean startAddCaseFlag = false;
        for(String name : caseNameList){
            if(name.contains(crashCaseName)){
                startAddCaseFlag = true;
                continue;
            }
            if(startAddCaseFlag){
                try {
                    testSuite.addTestSuite((Class<? extends junit.framework.TestCase>) Class.forName(name));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return testSuite;
    }


    /**
     * 获取发生crash的用例名
     * @return
     */
    private String getCrashCaseName(){
        String caseName = "";
        FileReader crashFileReader = null;
        File logPath = new File(Environment.getExternalStorageDirectory() + "/" + "testauto" + "/" + "crash.txt");
        try {
            crashFileReader =  new FileReader(logPath);
            BufferedReader br = new BufferedReader(crashFileReader);
            caseName = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                crashFileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return caseName;
    }
}
