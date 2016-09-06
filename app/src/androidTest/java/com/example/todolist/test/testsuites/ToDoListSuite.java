package com.example.todolist.test.testsuites;

import junit.framework.TestSuite;

import com.example.todolist.test.testcases.todolist.ToDoList_1;
import com.example.todolist.test.testcases.todolist.ToDoList_2;

public class ToDoListSuite {
	public static TestSuite getTestSuite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(ToDoList_1.class);
		suite.addTestSuite(ToDoList_2.class);
		return suite;
	}
}
