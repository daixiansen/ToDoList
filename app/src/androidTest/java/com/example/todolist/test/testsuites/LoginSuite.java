package com.example.todolist.test.testsuites;

import com.example.todolist.test.testcases.login.Login_1;
import com.example.todolist.test.testcases.login.Login_2;
import com.example.todolist.test.testcases.login.Login_3;

import junit.framework.TestSuite;

public class LoginSuite {
	public static TestSuite getTestSuite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(Login_1.class);
		suite.addTestSuite(Login_2.class);
		suite.addTestSuite(Login_3.class);
		return suite;
	}
}
