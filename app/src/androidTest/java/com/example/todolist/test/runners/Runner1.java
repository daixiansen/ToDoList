package com.example.todolist.test.runners;

import com.example.todolist.test.testcases.LatestTest;
import com.example.todolist.test.testsuites.LoginSuite;
import com.example.todolist.test.testsuites.ToDoListSuite;

import junit.framework.TestSuite;

public class Runner1 extends CommonRunner {

	@Override
	public TestSuite getAllTests() {
		// TODO Auto-generated method stub
		TestSuite suite = new TestSuite();
		/**
		 * 将登陆模块和任务列表模块的suite添加进来
		 */
		suite.addTest(LoginSuite.getTestSuite());
		suite.addTest(ToDoListSuite.getTestSuite());
		suite.addTestSuite(LatestTest.class);
		
		if(isNeedRegenerate){
            suite = reGenerateTestSuiteWhenCrash(getCaseNameList(suite));
        }
		return suite;
	}
}
